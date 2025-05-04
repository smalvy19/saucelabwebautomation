package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsDetailPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    ProductsPage productsPage;

    @BeforeClass
    public void setupProductsPage() {
        productsPage = new ProductsPage(driver);
    }

    @Test (priority = 0)
    public void verifyPageTitile() {
        String actualTitle = productsPage.verifyPageTitle();
        String expectedZTitle = "Products";
        Assert.assertEquals(actualTitle, expectedZTitle, "Title does not match expected");
    }

    @Test (priority = 1)
    public void selectRandomProduct() {
        productsPage.selectRandomProduct();
    }

}
