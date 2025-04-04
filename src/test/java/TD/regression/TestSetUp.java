package TD.regression;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class TestSetUp {
	    WebDriver driver;

	    @BeforeClass
	    public void setup() {
	    	System.setProperty("webdriver.chrome.driver",
	                "C:\\Users\\rashm\\eclipse-workspace\\SeleniumUi\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

	        // Instantiate a ChromeDriver class.
	        driver = new ChromeDriver();
	        
	        driver.manage().window().maximize();
	    }

	    
	    
	    @Test
	    public void testApplication() {
	    	 driver.get("https://test.templedekho.com/");
	        System.out.println("Title: " + driver.getTitle());
	    }
	    @Test
		public void firstTestCase() {
			System.out.println("My first Test case");
		}
	    @AfterClass
	    public void teardown() {
	        driver.quit();
	    }
	}




