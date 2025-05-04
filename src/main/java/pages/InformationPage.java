package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CustomMethods;

public class InformationPage extends BasePage {

    public InformationPage(WebDriver driver) {
        super(driver);
    }

    public static String storedFirstName;
    public static String storedLastName;
    public static String storedZipCode;

    @FindBy(xpath = "//span[@class='title']")
    WebElement pageTitle;

    @FindBy(id = "cancel")
    WebElement cancelButton;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    public String verifyPageTitle () {
        return pageTitle.getText();
    }

    public String verifyCancelButtonIsDisplayed() {
        return cancelButton.getText();
    }

    public void enterFirstName() {
        storedFirstName = CustomMethods.getRandomFirstName();
        firstName.sendKeys(storedFirstName);
        System.out.println("Entered First Name: " + storedFirstName);
    }

    public void enterLastName() {
        storedLastName = CustomMethods.getRandomLastName();
        lastName.sendKeys(storedLastName);
        System.out.println("Entered Last Name: " + storedLastName);
    }

    public void enterPostalCode() {
       storedZipCode = CustomMethods.getRandomZipCode();
        postalCode.sendKeys(storedZipCode);
        System.out.println("Entered Zip Code: " + storedZipCode);
    }

    public void continueToNextPage() {
        continueButton.click();
    }

    // Getter methods to use later for assertions or logs
    public String getStoredFirstName() {
        return storedFirstName;
    }

    public String getStoredLastName() {
        return storedLastName;
    }

    public String getStoredZipCode() {
        return storedZipCode;
    }
}
