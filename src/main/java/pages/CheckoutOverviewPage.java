package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutOverviewPage extends BasePage {

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='title']")
    WebElement pageTitle;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> checkoutProductName;

    @FindBy(className = "inventory_item_price")
    List<WebElement> cartProductPrices;

    @FindBy(className = "cart_quantity")
    List<WebElement> cartProductQuantities;

    @FindBy(xpath = "//div[normalize-space()='Payment Information:']")
    WebElement paymentInfoLabel;

    @FindBy(xpath = "//div[normalize-space()='SauceCard #31337']")
    WebElement cardInfo;

    @FindBy(xpath = "//div[normalize-space()='Shipping Information:']")
    WebElement shippingInfoLabel;

    @FindBy(xpath = "//div[normalize-space()='Free Pony Express Delivery!']")
    WebElement shippingInfo;

    @FindBy(xpath = "//div[normalize-space()='Price Total']")
    WebElement priceTotalLabel;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    WebElement summaryPriceTotal;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    WebElement tax;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    WebElement total;

    @FindBy(id = "cancel")
    WebElement cancelButton;

    @FindBy(id = "finish")
    WebElement finishButton;

    public String verifyPageTitle () {
        return pageTitle.getText();
    }

    public String verifyCancelButtonIsDisplayed() {
        return cancelButton.getText();
    }

    public boolean isProductInCart(String expectedProductName) {
        for (WebElement product : checkoutProductName) {
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

    public String verifyPaymentInformationLabelIsDisplayed () {
        return paymentInfoLabel.getText();
    }

    public String verifyCardInformationIsDisplayed () {
        return cardInfo.getText();
    }

    public String verifyShippingInformationLabelIsDisplayed () {
        return shippingInfoLabel.getText();
    }

    public String verifyShippingInformationIsDisplayed () {
        return shippingInfo.getText();
    }

    public String verifyPriceTotalLabelIsDisplayed () {
        return priceTotalLabel.getText();
    }

    public String verifyItemPrice () {
        return summaryPriceTotal.getText();
    }

    public String verifyTax () {
        return tax.getText();
    }

    public String verifyTotal () {
        return total.getText();
    }

    public void finish(){
        finishButton.click();
    }

    public double getItemTotalValue() {
        String itemTotalText = summaryPriceTotal.getText(); // e.g., "Item total: $29.99"
        return Double.parseDouble(itemTotalText.replace("Item total: $", "").trim());
    }

    public double getTaxValue() {
        String taxText = tax.getText(); // e.g., "Tax: $2.40"
        return Double.parseDouble(taxText.replace("Tax: $", "").trim());
    }

    public double getTotalValue() {
        String totalText = total.getText(); // e.g., "Total: $32.39"
        return Double.parseDouble(totalText.replace("Total: $", "").trim());
    }

    public double getCartProductPriceValue() {
        String priceText = getCartProductPrice(); // e.g., "$29.99"
        return Double.parseDouble(priceText.replace("$", "").trim());
    }





}
