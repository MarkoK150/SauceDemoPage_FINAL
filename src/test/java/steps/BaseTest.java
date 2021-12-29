package steps;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    DriverManager driverManager;

    public void init(String BROWSER, String  BROWSER_VERSION, String WAIT_TIME){
        driverManager= DriverManagerFactory.getDriverManager(BROWSER);
        driver=driverManager.getWebDriver(BROWSER_VERSION);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(WAIT_TIME), TimeUnit.SECONDS);

    }

    public void quit(){
        driverManager.quitWebDriver();
    }

    public void takeScreenshot(String fileName){
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("src/test/screenshots/"+fileName+".png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }




}

