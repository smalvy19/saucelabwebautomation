package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import utils.ConfigReader;

import java.io.IOException;
import java.time.Duration;

@Listeners(utils.TestListener.class)
public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite
    public void setUp() {

        if (driver == null) {
            String browser = ConfigReader.get("browser").toLowerCase();
            boolean isCI = System.getenv("CI") != null; // Check if in CI environment

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (isCI) {
                        // Run in headless mode if in CI environment
                        chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--disable-gpu");
                        chromeOptions.addArguments("--window-size=1920x1080");
                    }
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().clearDriverCache().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isCI) {
                        // Run in headless mode if in CI environment
                        firefoxOptions.addArguments("--headless");
                        firefoxOptions.addArguments("--disable-gpu");
                        firefoxOptions.addArguments("--window-size=1920x1080");
                    }
                    driver = new FirefoxDriver();
                    break;

                case "safari":
                    driver = new SafariDriver();
                    break;

                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(ConfigReader.get("baseUrl"));
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();  // Ensure proper cleanup
            }
            catch (Exception e) {
                System.out.println("Error during WebDriver quit: " + e.getMessage());
            }
            // Try killing the WebDriver process manually if it's still running
            try {
                if (driver instanceof ChromeDriver) {
                    // For ChromeDriver, check if there's a hanging chromedriver process
                    Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");  // Windows
                } else if (driver instanceof FirefoxDriver) {
                    // For FirefoxDriver, check if there's a hanging geckodriver process
                    Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");  // Windows
                }
            } catch (IOException e) {
                System.out.println("Error killing WebDriver process: " + e.getMessage());
            }
            finally {
                driver = null;  // Set driver to null to prevent further usage
            }
        }
    }
}
