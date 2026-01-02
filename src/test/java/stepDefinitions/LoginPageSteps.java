package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.LoginPage;

public class LoginPageSteps {


    private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());

    @Given("User is on the Login page")
    public void user_is_on_the_login_page() throws InterruptedException {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @When("User enters Username as {string} and Password as {string}")
    public void user_enters_Username_And_Password(String username, String password) {
        loginpage.setUsername(username);
        loginpage.setPassword(password);
    }

    @When("User enters Username as {string}")
    public void user_enters_username_as(String username){
        loginpage.setUsername(username);
    }

    @And("Click on login button")
    public void click_on_login_button() throws InterruptedException {
        loginpage.clickOnlogin();
        ;
        Thread.sleep(1000);
    }

    @Then("Validate the Page title in Login page")
    public void validate_the_page_title_in_login_page() {
        String loginPageTitle = loginpage.getPageTitle();
        Assert.assertEquals("Swag Labs", loginPageTitle);
    }

    @When("User click on logout page")
    public void user_click_on_logout_page() throws InterruptedException {
        loginpage.clickOnOpenMenu();
        ;
        Thread.sleep(1000);
        loginpage.clickLogout();
        ;
    }

    @Then("Validate the Page title Home page")
    public void validate_the_page_title_home_page() {
        String homePageTitle = loginpage.getPageTitle();
        Assert.assertEquals("Swag Labs", homePageTitle);
    }

    @Then("Validate the error message for locked out user")
    public void validate_the_error_message_for_locked_out_user() throws InterruptedException {
        Thread.sleep(5000);
        String errorMsg_LockedUser = loginpage.errorMsgLockedUser();
        System.out.println("Error message displayed is: " + errorMsg_LockedUser);
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", errorMsg_LockedUser);
    }

    @Then("Validate the error message for invalid user")
    public void validate_the_error_message_for_invalid_user() throws InterruptedException {
        Thread.sleep(5000);
        String errorMsg_InvalidUser = loginpage.errorMsgInvalidUser();
        System.out.println("Error message displayed is: " + errorMsg_InvalidUser);
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorMsg_InvalidUser);
    }

    @Then("Validate the error message for empty username and password")
    public void validate_the_error_message_for_empty_username_and_password() throws InterruptedException {
        Thread.sleep(5000);
        String errorMsg_Emptyfields = loginpage.errorMsgEmptyfields();
        System.out.println("Error message displayed is: " + errorMsg_Emptyfields);
        Assert.assertEquals("Epic sadface: Username is required", errorMsg_Emptyfields);
    }

    @Then("Validate the error message for empty password")
    public void validate_the_error_message_for_empty_password() throws InterruptedException {
        Thread.sleep(5000);
        String errorMsg_Emptypassword= loginpage.errorMsgEmptypassword();
        System.out.println("Error message displayed is: " + errorMsg_Emptypassword);
        Assert.assertEquals("Epic sadface: Password is required", errorMsg_Emptypassword);
    }

    @Then("Validate the error message for empty username")
    public void validate_the_error_message_for_empty_username() throws InterruptedException {
        Thread.sleep(5000);
        String errorMsg_Emptyusername= loginpage.errorMsgEmptyusername();
        System.out.println("Error message displayed is: " + errorMsg_Emptyusername);
        Assert.assertEquals("Epic sadface: Username is required", errorMsg_Emptyusername);
    }
}
