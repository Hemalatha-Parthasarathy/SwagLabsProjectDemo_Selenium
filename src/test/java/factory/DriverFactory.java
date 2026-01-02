package factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    public WebDriver driver;

    /* We create the Threadlocal driver for runnning the test in parallel
     */
    private static ThreadLocal<WebDriver> ldriver = new ThreadLocal<>();

    //Method to initialise the desired driver
    public  WebDriver init_driver(String browser){

        if(browser.equals("chrome")){

            ChromeOptions options;
            //To handle if Chrome notifications,alerts,popups arise
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection", false);

            options = new ChromeOptions();
            options.setExperimentalOption("prefs",prefs);

            WebDriverManager.chromedriver().setup();
            ldriver.set(new ChromeDriver(options));
        }
        else if(browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            ldriver.set(new FirefoxDriver());
        }
        else {
            System.out.println("Provide the right browser: "+browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    //Method to get the driver
    public static synchronized WebDriver getDriver(){

        return ldriver.get();
    }
}
