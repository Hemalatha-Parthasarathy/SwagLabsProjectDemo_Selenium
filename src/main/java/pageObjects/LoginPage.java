package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    //***Constructor of Page class
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //***Locators of WebElements
    By txtUsername = By.id("user-name");
    By txtPassword = By.id("password");
    By btnLogin = By.id("login-button");
    By btnOpenmenu = By.xpath("//button[@id='react-burger-menu-btn']");
    By lnkLogout = By.xpath("//a[@id='logout_sidebar_link']");
    By errorUser = By.cssSelector("h3[data-test='error']");

    //***Page Actions
    public void setUsername(String username) {
        driver.findElement(txtUsername).clear();
        driver.findElement(txtUsername).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(txtPassword).clear();
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickOnlogin() {
        driver.findElement(btnLogin).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickOnOpenMenu() {
        driver.findElement(btnOpenmenu).click();
    }

    public void clickLogout() {
        driver.findElement(lnkLogout).click();
    }

    public String errorMsgLockedUser() throws InterruptedException {
        Thread.sleep(1000);
        if (driver.findElement(errorUser).isDisplayed()) {
            System.out.println("Error message is displayed");
            Thread.sleep(1000);
        } else {
            System.out.println("Error message is not displayed - Incorrect Validation");
        }
        return driver.findElement(errorUser).getText();
    }

    public String errorMsgInvalidUser() throws InterruptedException {
        Thread.sleep(1000);
        if (driver.findElement(errorUser).isDisplayed()) {
            System.out.println("Error message is displayed");
            Thread.sleep(1000);
        } else {
            System.out.println("Error message is not displayed - Incorrect Validation");
        }
        return driver.findElement(errorUser).getText();
    }

    public String errorMsgEmptyfields() throws InterruptedException {
        Thread.sleep(1000);
        if (driver.findElement(errorUser).isDisplayed()) {
            System.out.println("Error message is displayed");
            Thread.sleep(1000);
        } else {
            System.out.println("Error message is not displayed - Incorrect Validation");
        }
        return driver.findElement(errorUser).getText();
    }

    public String errorMsgEmptypassword() throws InterruptedException {
        Thread.sleep(1000);
        if (driver.findElement(errorUser).isDisplayed()) {
            System.out.println("Error message is displayed");
            Thread.sleep(1000);
        } else {
            System.out.println("Error message is not displayed - Incorrect Validation");
        }
        return driver.findElement(errorUser).getText();
    }

    public String errorMsgEmptyusername() throws InterruptedException {
        Thread.sleep(1000);
        if (driver.findElement(errorUser).isDisplayed()) {
            System.out.println("Error message is displayed");
            Thread.sleep(1000);
        } else {
            System.out.println("Error message is not displayed - Incorrect Validation");
        }
        return driver.findElement(errorUser).getText();
    }

}
