package pages.components;

import io.cucumber.java.bs.A;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.CommonComponentsAndActions;

import java.security.Key;

public class HeaderComponents extends CommonComponentsAndActions {
    WebDriver driver;

    public HeaderComponents(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#shopping_cart_container a")
    WebElement cart;
    public void clickButtonCartHeader(){
        clickElement(cart);
    }

    @FindBy(xpath = "//a[@class=\"shopping_cart_link\"]/span")
    WebElement numProductCart;
    public String getNumProductCart(){
        return numProductCart.getText();
    }

    @FindBy(xpath = "//div[@class=\"bm-burger-button\"]/button")
    WebElement menu;

    public void clickMenuItem(String menuItem){
        clickElement(menu);
        clickElement(driver.findElement(By.xpath("//nav[@class='bm-item-list']/a[text()='"+menuItem+"']")));
    }

}
