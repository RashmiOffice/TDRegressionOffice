package pages;


import org.openqa.selenium.By;

public class HomePageLocators {

    // 🔹 XPath locators as public static variables
    public static final By LOGIN_BUTTON = By.xpath("//div[contains(@class, 'profileBlock')]//button[1]");

 //   public static final By MOBILE_INPUT = By.xpath("//input[@id=':rb:']")
  //  public static final By MOBILE_INPUT = By.xpath("//input[starts-with(@value, '91')]");
    public static final By MOBILE_INPUT = By.xpath("//input[contains(@class,'MuiInputBase-input') and @type='text' and @inputmode='numeric']");

    

    public static final By PROCEED_BUTTON = By.xpath("//button[normalize-space()='PROCEED']");
    public static final By OTP_SCREEN = By.xpath("//*[contains(@class, 'otpScreen')]");
    public static final By OTP_INPUTS = By.xpath("//*[contains(@class, 'otpFields')]/div/input");
    public static final By CONFIRM_BUTTON = By.xpath("//button[normalize-space()='Confirm']");
    public static final By MENU_ITEMS = By.xpath("//ul[@class='links']/li");
    public static final By SCROLL_TEXT = By.xpath("//*[@id='root']//div[2]/div[2]//p");
//    public static final By LOGIN_TEXT = By.xpath("//p[contains(@class, 'loginPhNoText')]");
    public static final By LOGIN_TEXT = By.xpath("//p[contains(@class, 'loginPhNoText') and contains(text(), 'LOGIN/SIGNUP')]");

 
    
    public static final By LOGIN_IMG = By.xpath("//*[@id=\"root\"]/div/div[1]/div/nav/nav/div[1]/div[3]/div/div[3]/a/img");
    public static final By LOGGED_USER = By.xpath("//div[@role='presentation']//h6[1]");
    public static final By PUJA_CARD =By.xpath("//div[@class='card templeCard MuiBox-root css-0']");
   // public static final String TEMPLE_CARD = "//div[@class='card templeCard MuiBox-root css-0']";
  
    public static final By PUJAS =By.xpath("p[normalize-space()='Puja']");
    

    

    // Add more locators as needed
    
}
