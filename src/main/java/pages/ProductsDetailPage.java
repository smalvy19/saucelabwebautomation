package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsDetailPage extends BasePage {

    public ProductsDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "inventory_details_name")
    WebElement productName;

    @FindBy(css = "button.btn_inventory")
    WebElement addToCartButton;

    @FindBy(id = "remove")
    WebElement removeButton;

    @FindBy (className = "shopping_cart_link")
    WebElement cartButton;

    @FindBy(className = "inventory_details_price")
    WebElement productPriceElement;

    public static String selectedProductPrice;


    public String getProductTitle() {
        return productName.getText();
    }

    public void addToCart() {
        addToCartButton.click();
    }


    public String verifyRemove() {
        return removeButton.getText();
    }

    public String getProductPrice() {
        selectedProductPrice = productPriceElement.getText();
        return selectedProductPrice;
    }

    public void navigateToCart() {
        cartButton.click();
    }
}
