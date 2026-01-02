package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By btncontinueShop = By.id("continue-shopping");
    By btncheckout = By.id("checkout");
    By lblquantity = By.xpath("//div[@class='cart_quantity_label']");
    By lbldecription = By.xpath("//div[@class='cart_desc_label']");
    By pagetitle = By.xpath("//span[@class='title']");
    By iconCart = By.xpath("//a[@class='shopping_cart_link']");
    By itemcount = By.xpath("//span[@class='shopping_cart_badge']");
    By cart_prdname = By.xpath("//div[@class='inventory_item_name']");
    By cart_price = By.xpath("//div[@class='inventory_item_price']");
    By cart_qty = By.xpath("//div[@class='cart_quantity']");
    By Lst_cartremove = By.xpath("//button[@class='btn btn_secondary btn_small cart_button']");


    public String validatePagetitle() {
        return driver.findElement(pagetitle).getText();
    }

    public int cartprodcount() {
        List<WebElement> cartprodcounts = driver.findElements(cart_prdname);
        if (cartprodcounts.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(cartprodcounts.get(0).getText());
    }

    public String display_txtcheckout() {
        String txtcheckout = "";
        if (driver.findElement(btncheckout).isDisplayed()) {
            txtcheckout = driver.findElement(btncheckout).getText();
        } else {
            System.out.println("checkout button is not displayed");
        }
        return txtcheckout;
    }

    public String display_txtcontinueshop() {
        String txtcontinueshop = "";
        if (driver.findElement(btncontinueShop).isDisplayed()) {
            txtcontinueshop = driver.findElement(btncontinueShop).getText();
        } else {
            System.out.println("continueshop button is not displayed");
        }
        return txtcontinueshop;
    }

    public String display_txtquantity() {
        String txtquantity = "";
        if (driver.findElement(lblquantity).isDisplayed()) {
            txtquantity = driver.findElement(lblquantity).getText();
        } else {
            System.out.println("Quantity header is not displayed");
        }
        return txtquantity;
    }

    public String display_txtdescription() {
        String txtdescription = "";
        if (driver.findElement(lbldecription).isDisplayed()) {
            txtdescription = driver.findElement(lbldecription).getText();
        } else {
            System.out.println("Description header is not displayed");
        }
        return txtdescription;
    }

    public String display_iconitemcount() {
        driver.findElement(iconCart).isDisplayed();
        String count = null;
        if (driver.findElement(itemcount).isDisplayed()) {
            count = driver.findElement(itemcount).getText();
        } else {
            System.out.println("cart icon with count is not displayed");
        }
        return count;
    }

    public String get_cartprodname() {
        return driver.findElement(cart_prdname).getText();
    }

    public List<String> get_cartprodname_multiple() {
        List<String> cartprodname = new ArrayList<>();
        List<WebElement> cartprodnames = driver.findElements(cart_prdname);

        for (WebElement e : cartprodnames) {
            cartprodname.add(e.getText());
        }
        return cartprodname;
    }

    public void clk_cartRemove(String product) {
        By cartremove = By.xpath("//div[text()='" +
                product + "']/ancestor::div[@class='inventory_item_description']//button[contains(text(),'Remove')]");
        driver.findElement(cartremove).click();

    }

    public void clk_removemultiple(List<String> products) {
        for (String productname : products) {
            clk_cartRemove(productname);
        }
    }

}