package selenium_core;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    WebDriver driver;

    abstract void createWebDriver(String BROWSER_VERSION);

    public void quitWebDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

    public WebDriver getWebDriver(String BROWSER_VERSION){
        if (driver==null){
            createWebDriver(BROWSER_VERSION);
        }
        return driver;
    }

}

