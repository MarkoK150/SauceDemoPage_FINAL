package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.components.FooterComponents;
import pages.components.HeaderComponents;

public class CheckoutStepsPage extends CommonComponentsAndActions {
    WebDriver driver;
    public HeaderComponents headerComponents;
    public FooterComponents footerComponents;

    public CheckoutStepsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        headerComponents=new HeaderComponents(driver);
        footerComponents=new FooterComponents(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[id=\"first-name\"]")
    WebElement firstName;
    public void enterFirstName(String firstNameValue){
        typeText(firstName,firstNameValue);
    }

    @FindBy(css = "[id=\"last-name\"]")
    WebElement lastName;
    public void enterLastName(String lastNameValue){
        typeText(lastName,lastNameValue);
    }

    @FindBy(css = "[id=\"postal-code\"]")
    WebElement zipCode;
    public void enterZipCode(String zipCodeValue){
        typeText(zipCode,zipCodeValue);
    }

    @FindBy(css = "[id=\"continue\"]")
    WebElement continueButton;
    public void clickContinueButton(){
        clickElement(continueButton);
    }

    @FindBy(css = "[id=\"finish\"]")
    WebElement finishButton;
    public void clickFinishButton(){
        clickElement(finishButton);
    }

    @FindBy(xpath = "//h2[@class=\"complete-header\"][text()=\"THANK YOU FOR YOUR ORDER\"]")
    WebElement buyProductMessage;
    public String getTextBuyProductMessage(){
        return buyProductMessage.getText();
    }

    @FindBy(xpath = "//span[@class=\"title\"][text()=\"Checkout: Complete!\"]")
    public WebElement titleTextBuyProduct;

}
