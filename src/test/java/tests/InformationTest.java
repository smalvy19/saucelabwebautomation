package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.InformationPage;
import utils.CustomMethods;

public class InformationTest extends BaseTest {

    InformationPage informationPage;

    @BeforeClass
    public void setupInformationPage() {
        informationPage = new InformationPage(driver);
    }

    @Test(priority = 0)
    public void verifyPageTitle() {
        String actualTitle = informationPage.verifyPageTitle();
        String expectedZTitle = "Checkout: Your Information";
        Assert.assertEquals(actualTitle, expectedZTitle, "Title does not match expected");
    }

    @Test (priority = 1)
    public void verifyCancelButtonIsDisplayed() {
        String actualTitle = informationPage.verifyCancelButtonIsDisplayed();
        String expectedTitle = "Cancel";
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match expected");
    }


    @Test (priority = 3)
    public void fillInformationFormWithRandomData() {

        informationPage.enterFirstName();
        informationPage.enterLastName();
        informationPage.enterPostalCode();

        String enteredFirstName = informationPage.getStoredFirstName();
        String enteredLastName = informationPage.getStoredLastName();
        String enteredZipCode = informationPage.getStoredZipCode();

        System.out.println("Form submitted with: " + enteredFirstName + " " + enteredLastName + " - " + enteredZipCode);

    }

    @Test (priority = 4)
    public void verifyContinue() {
        informationPage.continueToNextPage();
    }
}
