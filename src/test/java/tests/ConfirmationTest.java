package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckoutOverviewPage;
import pages.ConfrimationPage;
import pages.ProductsPage;

public class ConfirmationTest extends BaseTest {

    ConfrimationPage confrimationPage;

    @BeforeClass
    public void setupConfirmation() {
        confrimationPage = new ConfrimationPage(driver);
    }

    @Test(priority = 0)
    public void verifyThankYou() {
        String actualTitle = confrimationPage.verifyConfirmation();
        String expectedZTitle = "Thank you for your order!";
        Assert.assertEquals(actualTitle, expectedZTitle, "Title does not match expected");
    }


    @Test(priority = 1)
    public void verifyMessage() {
        String actualTitle = confrimationPage.verifyMessage();
        String expectedZTitle = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        Assert.assertEquals(actualTitle, expectedZTitle, "Title does not match expected");
    }

    @Test(priority = 2)
    public void goHome() {
        confrimationPage.goHome();
        ProductsPage productsPage = new ProductsPage(driver);
        String actualTitle = productsPage.verifyPageTitle();
        String expectedZTitle = "Products";
        Assert.assertEquals(actualTitle, expectedZTitle, "Title does not match expected");
    }
}
