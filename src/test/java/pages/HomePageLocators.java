package pages;


import org.openqa.selenium.By;

public class HomePageLocators {

    // 🔹 XPath locators as public static variables
    public static final By LOGIN_BUTTON = By.xpath("//div[contains(@class, 'profileBlock')]//button[1]");
    public static final By MOBILE_INPUT = By.xpath("//input[@id=':rb:']");
    public static final By PROCEED_BUTTON = By.xpath("//button[normalize-space()='PROCEED']");
    public static final By OTP_SCREEN = By.xpath("//*[contains(@class, 'otpScreen')]");
    public static final By OTP_INPUTS = By.xpath("//*[contains(@class, 'otpFields')]/div/input");
    public static final By CONFIRM_BUTTON = By.xpath("//button[normalize-space()='Confirm']");
    public static final By MENU_ITEMS = By.xpath("//ul[@class='links']/li");
    public static final By SCROLL_TEXT = By.xpath("//*[@id='root']//div[2]/div[2]//p");

    // Add more locators as needed
}
