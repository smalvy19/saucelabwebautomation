package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckoutOverviewPage;
import pages.ProductsDetailPage;
import pages.ProductsPage;

public class CheckoutOverviewTest extends BaseTest {

   CheckoutOverviewPage checkoutOverview;

    @BeforeClass
    public void setupCheckoutOverview() {
        checkoutOverview = new CheckoutOverviewPage(driver);
    }

    @Test (priority = 0)
    public void verifyPageTitile() {
        String actualTitle = checkoutOverview.verifyPageTitle();
        String expectedZTitle = "Checkout: Overview";
        Assert.assertEquals(actualTitle, expectedZTitle, "Title does not match expected");
    }

    @Test (priority = 1)
    public void verifyProductInCart() {
        String expectedProduct = ProductsPage.selectedProductName;

        boolean isProductFound = checkoutOverview.isProductInCart(expectedProduct);
        Assert.assertTrue(isProductFound, "Product not found in the cart: " + expectedProduct);
        System.out.println("Verified product in cart: " + expectedProduct);
    }

    @Test (priority = 2)
    public void verifyProductPriceInCart() {
        String expectedPrice = ProductsDetailPage.selectedProductPrice;
        String actualPrice = checkoutOverview.getCartProductPrice();

        Assert.assertEquals(actualPrice, expectedPrice, "Product price in cart does not match the selected product's price.");
        System.out.println("Verified product price in cart: " + actualPrice);
    }

    @Test (priority = 3)
    public void verifyProductQuantityInCart() {
        int expectedQuantity = 1;
        int actualQuantity = checkoutOverview.getCartProductQuantity();

        Assert.assertEquals(actualQuantity, expectedQuantity, "Cart quantity is not as expected");
        System.out.println("Verified product quantity in cart: " + actualQuantity);
    }

    @Test (priority = 4)
    public void verifyPaymentInformationLabel() {
        String actualTitle = checkoutOverview.verifyPaymentInformationLabelIsDisplayed();
        String expectedZTitle = "Payment Information:";
        Assert.assertEquals(actualTitle, expectedZTitle, "Title does not match expected");
    }

    @Test (priority = 5)
    public void verifyPaymentInformation() {
        String actualTitle = checkoutOverview.verifyCardInformationIsDisplayed();
        String expectedZTitle = "SauceCard #31337";
        Assert.assertEquals(actualTitle, expectedZTitle, "Title does not match expected");
    }

    @Test (priority = 6)
    public void verifyShippingInformationLabelIsDisplayed() {
        String actualTitle = checkoutOverview.verifyShippingInformationLabelIsDisplayed();
        String expectedZTitle = "Shipping Information:";
        Assert.assertEquals(actualTitle, expectedZTitle, "Title does not match expected");
    }

    @Test (priority = 7)
    public void verifyShippingInformationIsDisplayed() {
        String actualTitle = checkoutOverview.verifyShippingInformationIsDisplayed();
        String expectedZTitle = "Free Pony Express Delivery!";
        Assert.assertEquals(actualTitle, expectedZTitle, "Title does not match expected");
    }

    @Test (priority = 8)
    public void verifyPriceTotalInformationIsDisplayed() {
        String actualTitle = checkoutOverview.verifyPriceTotalLabelIsDisplayed();
        String expectedZTitle = "Price Total";
        Assert.assertEquals(actualTitle, expectedZTitle, "Title does not match expected");
    }

    @Test (priority = 9)
    public void verifyTaxIsDisplayed() {
        String actualTitle = checkoutOverview.verifyTax();
        Assert.assertTrue(actualTitle.startsWith("Tax: $"), "Tax label is not displayed as expected");

    }

    @Test(priority = 10)
    public void verifyItemTotalEqualsProductPrice() {
        double expectedPrice = checkoutOverview.getCartProductPriceValue();
        double itemTotal = checkoutOverview.getItemTotalValue();

        Assert.assertEquals(itemTotal, expectedPrice, "Item total does not match the product price.");
        System.out.println("Verified item total equals product price: $" + itemTotal);
    }

    @Test(priority = 11)
    public void verifyTotalEqualsItemTotalPlusTax() {
        double itemTotal = checkoutOverview.getItemTotalValue();
        double tax = checkoutOverview.getTaxValue();
        double expectedTotal = itemTotal + tax;

        double actualTotal = checkoutOverview.getTotalValue();

        Assert.assertEquals(actualTotal, expectedTotal, 0.01, "Total amount is not the sum of item total and tax.");
        System.out.println("Verified total = item total + tax: $" + actualTotal);
    }

    @Test (priority = 12 )
    public void finish(){
        checkoutOverview.finish();
    }

}
