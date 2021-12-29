package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.components.FooterComponents;
import pages.components.HeaderComponents;

public class LoginPage extends CommonComponentsAndActions {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        HeaderComponents headerComponents = new HeaderComponents(driver);
        FooterComponents footerComponents = new FooterComponents(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#user-name")
    WebElement usernameField;
    public void enterUsername(String usernameValue){
        typeText(usernameField, usernameValue);
    }

    @FindBy(css = "#password")
    WebElement passwordField;
    public void enterPassword(String passwordValue){
        typeText(passwordField,passwordValue);
    }


    @FindBy(css = "#login-button")
    WebElement buttonLogin;
    public void clickLoginButton(){
        clickElement(buttonLogin);
    }

    @FindBy(xpath = "//h3[@data-test=\"error\"]")
    public WebElement errorMsgLoginPage;
    public String getTextErrorMsgLoginPage(){
        return errorMsgLoginPage.getText();
    }

    @FindBy(css = "[class=\"error-message-container error\"]")
    public WebElement errorMsgLoginPageDiv;



}
