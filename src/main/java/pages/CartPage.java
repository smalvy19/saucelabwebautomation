package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='title']")
    WebElement pageTitle;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> cartProductNames;

    @FindBy(className = "inventory_item_price")
    List<WebElement> cartProductPrices;

    @FindBy(className = "cart_quantity")
    List<WebElement> cartProductQuantities;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(xpath = "//button[text()='Remove']")
    List <WebElement> removeButton;

    public String verifyPageTitle () {
        return pageTitle.getText();
    }

    public boolean isProductInCart(String expectedProductName) {
        for (WebElement product : cartProductNames) {
            if (product.getText().equalsIgnoreCase(expectedProductName)) {
                return true;
            }
        }
        return false;
    }

    public String getCartProductPrice() {
        if (!cartProductPrices.isEmpty()) {
            return cartProductPrices.get(0).getText();
        } else {
            throw new RuntimeException("No prices found in cart");
        }
    }

    public int getCartProductQuantity() {
        if (!cartProductQuantities.isEmpty()) {
            String quantityText = cartProductQuantities.get(0).getText();  // Assuming only one product in cart
            return Integer.parseInt(quantityText);
        } else {
            throw new RuntimeException("No quantity element found in cart");
        }
    }

    public String continueShoppingButtonIsDisplayed(){
        return continueShoppingButton.getText();
    }

    public String checkoutButtonIsDisplayed(){
        return checkoutButton.getText();
    }

    public String removeButtonIsDisplayed(){
        return removeButton.get(0).getText();
    }

    public void verifyCheckout() {
        checkoutButton.click();
    }


}
