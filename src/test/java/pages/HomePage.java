package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.components.FooterComponents;
import pages.components.HeaderComponents;

public class HomePage extends CommonComponentsAndActions {
    WebDriver driver;
    public HeaderComponents headerComponents;
    public FooterComponents footerComponents;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        headerComponents=new HeaderComponents(driver);
        footerComponents=new FooterComponents(driver);
        PageFactory.initElements(driver,this);
    }


}
