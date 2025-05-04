package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsDetailPage;
import pages.ProductsPage;

public class CartTest extends BaseTest {

    CartPage cartPage;

    @BeforeClass
    public void setupCartPage() {
        cartPage = new CartPage(driver);
    }

    @Test (priority = 0)
    public void verifyPageTitile() {
        String actualTitle = cartPage.verifyPageTitle();
        String expectedZTitle = "Your Cart";
        Assert.assertEquals(actualTitle, expectedZTitle, "Title does not match expected");
    }

    @Test (priority = 1)
    public void verifyProductInCart() {
        String expectedProduct = ProductsPage.selectedProductName;

        boolean isProductFound = cartPage.isProductInCart(expectedProduct);
        Assert.assertTrue(isProductFound, "Product not found in the cart: " + expectedProduct);
        System.out.println("Verified product in cart: " + expectedProduct);
    }

    @Test (priority = 2)
    public void verifyProductPriceInCart() {
        String expectedPrice = ProductsDetailPage.selectedProductPrice;
        String actualPrice = cartPage.getCartProductPrice();

        Assert.assertEquals(actualPrice, expectedPrice, "Product price in cart does not match the selected product's price.");
        System.out.println("Verified product price in cart: " + actualPrice);
    }

    @Test (priority = 3)
    public void verifyProductQuantityInCart() {
        int expectedQuantity = 1;
        int actualQuantity = cartPage.getCartProductQuantity();

        Assert.assertEquals(actualQuantity, expectedQuantity, "Cart quantity is not as expected");
        System.out.println("Verified product quantity in cart: " + actualQuantity);
    }

    @Test (priority = 4)
    public void verifyRemoveButtonIsDisplayed() {
        String actualTitle = cartPage.removeButtonIsDisplayed();
        String expectedTitle = "Remove";
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match expected");
    }

    @Test (priority = 5)
    public void verifyContinueSHoppingButtonIsDisplayed() {
        String actualTitle = cartPage.continueShoppingButtonIsDisplayed();
        String expectedTitle = "Continue Shopping";
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match expected");
    }

    @Test (priority = 5)
    public void verifyCheckoutButtonIsDisplayed() {
        String actualTitle = cartPage.checkoutButtonIsDisplayed();
        String expectedTitle = "Checkout";
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match expected");
    }

    @Test (priority = 6)
    public void verifyCheckout() {
        cartPage.verifyCheckout();
    }
}
