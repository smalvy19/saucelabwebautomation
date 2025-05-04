package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfrimationPage extends BasePage {

    public ConfrimationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (className = "complete-header")
    WebElement thankYou;

    @FindBy (className = "complete-text")
    WebElement textMessage;

    @FindBy (xpath = "//button[@id='back-to-products']")
    WebElement backHome;

    public String verifyConfirmation () {
        return thankYou.getText();
    }

    public String verifyMessage () {
        return textMessage.getText();
    }

    public void goHome(){
        backHome.click();
    }


}
