/**package TD.regression;

	import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class TestSetUp {
	    WebDriver driver;

	    @BeforeClass
	    public void setup() {
	    	System.setProperty("webdriver.chrome.driver",
	                "C:\\Users\\rashm\\eclipse-workspace\\regression\\Driver\\chromedriver.exe");

	        // Instantiate a ChromeDriver class.
	        driver = new ChromeDriver();
	        
	        driver.manage().window().maximize();
	    }

	    
	    @Test (priority = 2)
	    
		public void tdfirstTestCase() {
			System.out.println("priority = 2 Temple Dekho");
		}
	    @Test (priority = 1)
	    public void tdtestTitle() throws InterruptedException {
	    	//  public void tdtestApplication() throws InterruptedException {
	    	 driver.get("https://test.templedekho.com/");
	    	 
	    	 String actualTitle = driver.getTitle();
	         String expectedTitle = "Temple Dekho Best Online Puja Platform | Book Online Puja in India";
	    	 
	         Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");

	     //   System.out.println("Title: " + driver.getTitle());
	        System.out.println("priority = 1 ");
	        Assert.assertEquals(driver.getTitle(), "Temple Dekho Best Online Puja Platform | Book Online Puja in India");
	        
	        // Create WebDriverWait instance (Maximum wait time: 20 seconds)
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        {
	            // Maximize the browser
	            driver.manage().window().maximize();

	            // Launch the website
	            driver.get("https://test.templedekho.com/");

	            // modify xpath using class and button
//	            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
//	                    "//body/div[@id='root']/div[@class='templeApp']/div[@class='MuiBox-root css-0']/div[@class='headerMainNav MuiBox-root css-0']/nav[@class='MuiPaper-root MuiPaper-elevation MuiPaper-elevation4 MuiAppBar-root MuiAppBar-colorPrimary MuiAppBar-positionFixed mui-fixed css-1vfuvx1']/nav[@class='headerContainer']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 row d-flex align-items-center mainGrid css-isbt42']/div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-3 MuiGrid-grid-lg-3 MuiGrid-grid-xl-3 hdRightGrid css-wfj9yb']/div[@class='headerRight MuiBox-root css-0']
	            //     /div[@class='profileBlock MuiBox-root css-0']/a[@href='javascipt:void()']/button[1]")));
	        }
	    }
	            // Wait for Login button to be clickable and click it
	          //  WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'profileBlock')]//button[1]")));
	       
	    
	        
	        @Test (priority = 2)
	        public void tdtestApplication() throws InterruptedException {
	        	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        	 WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'profileBlock')]//button[1]")));
	            Assert.assertTrue(loginButton.isDisplayed());
	            loginButton.click();

	            // Wait for mobile input field and enter mobile number
	            WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=':rb:']")));
	            mobileInput.sendKeys("9830162522");
	           Thread.sleep(10000);
	 //         implicit wait
//	            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	           
	         //    Wait for Proceed button and click it
//	           WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='PROCEED']")));
	            WebElement proceedButton = driver.findElement(By.xpath("//button[normalize-space()='PROCEED']"));
	            proceedButton.click();
	          //*[@id="root"]/div/div[2]/div[1]/div/nav/nav/div[1]/div[3]/div/div[3]/a/button
	           
//	        wait.until(ExpectedConditions.elementToBeClickable(proceedButton)).click();
	            
	            
	        
				
	            Thread.sleep(10000);
	            // Wait for OTP screen to appear
	            WebElement otpScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'otpScreen')]")));
	            System.out.println(otpScreen.getText());

	            // Wait for OTP fields and enter OTP
	            List<WebElement> otpScreensInputs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class, 'otpFields')]/div/input")));
	            for (int i = 0; i < otpScreensInputs.size(); i++) {
	            
	         //   for (int i = 0; i < 6; i++) {
	                WebElement ipEl = otpScreensInputs.get(i);
	                if ((i + 1) % 2 == 0) {
	                    ipEl.sendKeys("2");
	                } else {
	                    ipEl.sendKeys("1");
	                }
	                System.out.println(ipEl.getAttribute("value")); // Use getAttribute("value") instead of getText() for input fields
	            }

	            // Wait for Confirm button and click it
	            WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Confirm']")));
	            confirmButton.click();

	            // Scroll down
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("window.scrollBy(0,500)");

	            // Scroll up
	            js.executeScript("window.scrollBy(0,-500)");

	            
	          //*[@class="links"]//a[contains(text(), 'Temple')]
	            
	            WebElement element = driver.findElement(By.xpath("//*[@id='root']//div[2]/div[2]//p"));
	            System.out.println(element.getText());
	            
	            List<WebElement> buttonNames = driver.findElements(By.xpath("//ul[@class=\"links\"]/li"));
//	            System.out.println(((WebElement) buttonNames).getText());
	            String[] menuNames1 = {"Home","Temple", "Puja", "Chadhava", "Prasad", "Blog","Darshan"};
//	            for (int i = 0; i < buttonNames.size()-1; i++) {
	            	 for (int i = 0; i < 7; i++) {
	                
	                System.out.println("======in loop");
	              
					String title = buttonNames.get(i).getText();
	                if(title.equals(menuNames1[i])) {
	                	
	                	System.out.println(title    +  " exist");
	                }else {
	                	System.out.println(title + "  does not exist");
	                }
	               
	            }
	            System.out.println("======out loop");

	         
	        }
	       
	        
	    
	   
	    @AfterClass
	    public void teardown() {
	        driver.quit();
	    }
	}
**/



package TD.regression;

import java.time.Duration;
import java.util.List;

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
        loginBtn.click();
        
        WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.MOBILE_INPUT));
        mobileInput.sendKeys("9830162522");
        Thread.sleep(10000);
        Assert.assertTrue(mobileInput.isDisplayed(), "Mobile input field not visible");
        mobileInput.sendKeys("9830162522");
        Thread.sleep(10000); // Replace with explicit wait or mock OTP in real test

        WebElement proceedBtn = driver.findElement(HomePageLocators.PROCEED_BUTTON);
        proceedBtn.click();
        
      //  WebElement proceedButton = driver.findElement(By.xpath("//button[normalize-space()='PROCEED']"));
        Assert.assertTrue(proceedBtn.isEnabled(), "Proceed button not enabled");
        proceedBtn.click();
    }

    @Test(priority = 3)
    public void enterOTPTest() throws InterruptedException {
    	
    	//WebElement getOtpScreen(WebDriver driver, WebDriverWait wait)
    	 WebElement getOtpScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.OTP_SCREEN));
    	
       // WebElement otpScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(
     //           By.xpath("//*[contains(@class, 'otpScreen')]")));
        Assert.assertTrue(getOtpScreen.isDisplayed(), "OTP screen not visible");

        @SuppressWarnings("unchecked")
		List<WebElement> otpinput = (List<WebElement>) wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.OTP_INPUTS));

       
        Assert.assertEquals(otpinput.size(), 6, "OTP fields count mismatch");

        for (int i = 0; i < otpinput.size(); i++) {
        	otpinput.get(i).sendKeys((i % 2 == 0) ? "1" : "2");
        }

        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(
              driver.findElement(HomePageLocators.CONFIRM_BUTTON)));
        Assert.assertTrue(confirmButton.isDisplayed(), "Confirm button not visible");
        confirmButton.click();
    }

    @Test(priority = 4)
    public void verifyNavigationMenuItems() {
    	
    	List<WebElement> menuItems = driver.findElements(HomePageLocators.MENU_ITEMS);
      //  List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='links']/li"));
        
        String[] expectedItems = {"Home", "Temple", "Puja", "Chadhava", "Prasad", "Blog", "Darshan"};

        Assert.assertEquals(menuItems.size(), expectedItems.length, "Mismatch in menu item count");

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




