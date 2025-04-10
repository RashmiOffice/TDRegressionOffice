
package TD.regression;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePageLocators;


@Listeners(listeners.TestListener.class)
//@Listeners(TestListener.class)
public class TestSetUp {
    public WebDriver driver;

    // ... your test methods ...

    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\rashm\\eclipse-workspace\\regression\\Driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test(priority = 1)
    public void validatePageTitle() {
        driver.get("https://test.templedekho.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Temple Dekho Best Online Puja Platform | Book Online Puja in India";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");
    }

    @Test(priority = 2)
    public void loginTest() throws InterruptedException {
    	WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(HomePageLocators.LOGIN_BUTTON));
    	loginBtn.click();
    	
        Assert.assertTrue(loginBtn.isDisplayed(), "Login button not visible");
        
        WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.MOBILE_INPUT));
        mobileInput.sendKeys("9830162522");
        Thread.sleep(10000);
        Assert.assertTrue(mobileInput.isDisplayed(), "Mobile input field not visible");
        mobileInput.sendKeys("9830162522");
        Thread.sleep(10000); // Replace with explicit wait or mock OTP in real test

        WebElement proceedBtn = driver.findElement(HomePageLocators.PROCEED_BUTTON);
        proceedBtn.click();
        

        Assert.assertTrue(proceedBtn.isEnabled(), "Proceed button not enabled");
        proceedBtn.click();
        System.out.println("clicked on proceed button");
    }

    @Test(priority = 3)
    public void enterOTPTest() throws InterruptedException {
     Thread.sleep(20000); 
    	 System.out.println("otp screen visible");
    	 
    	// WebElement otpScreen = driver.findElement(By.xpath("//*[contains(@class, 'otpScreen')]"));
    	 WebElement otpScreen = driver.findElement( HomePageLocators.OTP_SCREEN);
         System.out.println(otpScreen.getText());
         Thread.sleep(20000);
    	  Assert.assertTrue(otpScreen.isDisplayed(), "OTP screen not visible");

     // Wait for OTP fields and enter OTP
     
        List<WebElement> otpinput = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((HomePageLocators.OTP_INPUTS)));
        Assert.assertEquals(otpinput.size(), 6, "OTP fields count mismatch");
        System.out.println("OTP fields count");
        for (int i = 0; i < otpinput.size(); i++) {
        	otpinput.get(i).sendKeys((i % 2 == 0) ? "1" : "2");
        }

        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(
              driver.findElement(HomePageLocators.CONFIRM_BUTTON)));
        Assert.assertTrue(confirmButton.isDisplayed(), "Confirm button not visible");
        confirmButton.click();
        System.out.println("confirm button clicked ");
        
    }

    @Test(priority = 4)
    public void verifyNavigationMenuItems() throws InterruptedException {
    	System.out.println("verifyNavigationMenuItems ");

    	List<WebElement> menuItems = driver.findElements(HomePageLocators.MENU_ITEMS);

    	for (WebElement item : menuItems) {
    	    System.out.println(item.getText());
    	}
    
        
      String[] expectedItems = {"Home", "Temple", "Puja", "Chadhava", "Prasad", "Blog", "Darshan","Home", "Temple", "Puja", "Chadhava","Prasad", "Blog"};

    //	 String[] expectedItems = {"Home", "Temple", "Puja", "Chadhava", "Prasad", "Blog", "Darshan"};
      Thread.sleep(10000);
        Assert.assertEquals(menuItems.size(), expectedItems.length, "Mismatch in menu item count");
        System.out.println("verifyNavigationMenuItems 2 ");

        for (int i = 0; i < expectedItems.length; i++) {
            String actualText = menuItems.get(i).getText().trim();
            Assert.assertEquals(actualText, expectedItems[i], "Menu item mismatch at index " + i);
        }
    }

    @Test(priority = 5)
    public void scrollTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("window.scrollBy(0,-500)");

        
        WebElement scrollCheckElement = driver.findElement(HomePageLocators.SCROLL_TEXT);
        Assert.assertTrue(scrollCheckElement.isDisplayed(), "Scroll target element not visible");
    }
    
    
    @Test(priority = 6)
    public void printAllMenuItems() {
        List<WebElement> menuItems = driver.findElements(HomePageLocators.MENU_ITEMS);
        System.out.println("Total menu items found: " + menuItems.size());

        for (WebElement item : menuItems) {
            String menuText = item.getText().trim();
            System.out.println("Menu Item: " + menuText);
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}




