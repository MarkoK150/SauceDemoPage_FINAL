package selenium_core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{
    @Override
    void createWebDriver(String BROWSER_VERSION) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver"+BROWSER_VERSION+".exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("start-maximized");
        this.driver=new ChromeDriver(options);
    }
}
