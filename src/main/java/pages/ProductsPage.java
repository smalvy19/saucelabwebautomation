package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='title']")
    WebElement pageTitle;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productTitles;
    public static String selectedProductName;

    public void selectRandomProduct() {
        if (productTitles.isEmpty()) {
            throw new RuntimeException("No products found on the page.");
        }

        Random rand = new Random();
        int randomIndex = rand.nextInt(productTitles.size());

        WebElement randomProduct = productTitles.get(randomIndex);
        selectedProductName = randomProduct.getText();
        System.out.println("Selected Product: " + selectedProductName);
        randomProduct.click();
    }

    public String getSelectedProductName() {
        return selectedProductName;
    }


    public String verifyPageTitle () {
        return pageTitle.getText();
    }

}
