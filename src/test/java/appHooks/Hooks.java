package appHooks;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.Properties;

public class Hooks {

    private DriverFactory driverFactory;
    private ConfigReader configReader;
    private WebDriver driver;
    Properties prop;

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser(){
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }

    @After(order = 0)
    public void closeBrowser(){
       driver.close();

    }

    @After(order =1)
    public void teardown(Scenario scenario){
        if(scenario.isFailed()){
         String screenshotName = scenario.getName().replaceAll("","_");
         byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
         scenario.attach(sourcepath,"image.png",screenshotName);
        }

    }

}
