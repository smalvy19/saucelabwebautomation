package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((tests.BaseTest) testClass).driver;

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String name = System.getProperty("user.dir") + "/screenshots/" + result.getName() + "_" + timestamp + ".png";

        try {
            Files.copy(screenshot.toPath(), new File(name).toPath());
            System.out.println("Screenshot saved: " + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
