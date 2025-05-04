package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ProductsDetailPage;
import pages.ProductsPage;

public class ProductsDetailsTest extends BaseTest {

    ProductsDetailPage productsDetailPage;

    @BeforeClass
    public void setupProductsDetailPage() {
        productsDetailPage = new ProductsDetailPage(driver);
    }

    @Test(priority = 0)
    public void verifySelectedProductTitleAndAddToCart() {
        String expectedProductTitle = ProductsPage.selectedProductName;
        String actualProductTitle = productsDetailPage.getProductTitle();
        Assert.assertEquals(expectedProductTitle,actualProductTitle,  "Product titles do not match!");
        productsDetailPage.getProductPrice();
        productsDetailPage.addToCart();
        System.out.println("Product added to cart: " + actualProductTitle);
    }

    @Test (priority = 1)
    public void verifyRemoveButton() {
        String actualTitle = productsDetailPage.verifyRemove();
        String expectedTitle = "Remove";
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match expected");
    }

    @Test (priority = 2)
    public void verifyNavigateToCart() {
        productsDetailPage.navigateToCart();
    }
}
