package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

public class LoginTest extends BaseTest {

    LoginPage loginPage; // Declare globally

    @BeforeClass
    public void setupLoginPage() {
        loginPage = new LoginPage(driver); // Initialize loginPage here
    }

    @Test (priority = 0)
    @Description("Check Login Null Values")
    public void NullValues() {
        String actualError = loginPage.nullLogin();
        String expectedError = "Epic sadface: Username is required";
        Assert.assertEquals(actualError, expectedError, "Error message does not match expected");
    }

  @Test (priority = 1)
    public void InvalidLogin() {
        loginPage.invalidLogin(ConfigReader.get("username"), ConfigReader.get("incorrectpassword"));
      String actualError = loginPage.getErrorMessage();
      String expectedError = "Epic sadface: Username and password do not match any user in this service";
      Assert.assertEquals(actualError, expectedError, "Error message does not match expected");
    }

    @Test (priority = 2)
    public void ValidLogin() {
        loginPage.validLogin(ConfigReader.get("username"), ConfigReader.get("password"));
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            boolean urlChanged = wait.until(ExpectedConditions.urlToBe(expectedUrl));

            Assert.assertTrue(urlChanged, "Login failed or did not redirect to the expected page.");
            System.out.println("Login successful. Redirected to expected URL.");
        } catch (Exception e) {
            String actualUrl = driver.getCurrentUrl();
            System.err.println("Login failed. Actual URL: " + actualUrl);
            Assert.fail("Exception while waiting for URL to change: " + e.getMessage());
        }

    }
}
