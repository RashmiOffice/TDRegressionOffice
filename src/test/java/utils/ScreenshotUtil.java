package utils;

import org.openqa.selenium.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String testName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String destination = "screenshots/" + testName + "_" + timestamp + ".png";

            FileUtils.copyFile(source, new File(destination));
            System.out.println("📸 Screenshot captured: " + destination);
        } catch (IOException e) {
            System.out.println("❌ Failed to capture screenshot: " + e.getMessage());
        }
    }
}

