package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.components.FooterComponents;
import pages.components.HeaderComponents;

public class CartPage extends CommonComponentsAndActions {
    WebDriver driver;
    HeaderComponents headerComponents;
    FooterComponents footerComponents;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        headerComponents=new HeaderComponents(driver);
        footerComponents=new FooterComponents(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = "#remove-sauce-labs-backpack")
    WebElement removeProductButton;
    public void clickRemoveProductButton(){
        clickElement(removeProductButton);
    }

    @FindBy(css = "#checkout")
    WebElement checkoutButtonCartPage;
    public void clickCheckoutButtonCartPage(){
        clickElement(checkoutButtonCartPage);
    }

    @FindBy(css = "#continue-shopping")
    WebElement continueShoppingButton;
    public void clickContinueShoppingButton(){
        clickElement(continueShoppingButton);
    }

    public String getNameProductInCart(String nameProduct){
        WebElement nameProductInCart=driver.findElement(By.xpath("//div[@class='cart_item']//div[text()='"+nameProduct+"']"));

        return nameProductInCart.getText();
    }
}

