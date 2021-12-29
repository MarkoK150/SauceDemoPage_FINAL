package pages;

import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.components.FooterComponents;
import pages.components.HeaderComponents;

import java.util.Random;

public class ProductsPage extends CommonComponentsAndActions {
    WebDriver driver;
    public HeaderComponents headerComponents;
    public FooterComponents footerComponents;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        headerComponents = new HeaderComponents(driver);
        footerComponents = new FooterComponents(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class=\"title\"]")
    WebElement textTitleProductsPage;

    public String getTextTitleProductsPage() {
        return textTitleProductsPage.getText();
    }

    public void addProductByName(String nameProduct){
        WebElement productByName=driver.findElement(By.xpath("//div[@class='inventory_list']/div//div[text()='"+nameProduct+"']/../../../div[@class='pricebar']//button"));
        clickElement(productByName);

    }

    public void addProductRandomNum(){
        Random random=new Random();
        int num=random.nextInt(5)+1;

        WebElement productRandom=driver.findElement(By.xpath("//div[@class=\"inventory_list\"]/div["+num+"]//button[text()=\"Add to cart\"]"));
        clickElement(productRandom);
    }


}
