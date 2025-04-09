package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import TD.regression.TestSetUp;
import utils.ScreenshotUtil;

import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((TestSetUp) testClass).driver; // 'driver' should be public in your test class

        ScreenshotUtil.captureScreenshot(driver, result.getName());
    }
}
