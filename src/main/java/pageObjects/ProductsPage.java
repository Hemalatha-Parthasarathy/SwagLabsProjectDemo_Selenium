package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By pageHeader = By.xpath("//span[@class='title']");
    By Slt_sortDrpdown = By.xpath("//select[@class='product_sort_container']");
    By Lst_productsLsts = By.xpath("//div[@class='inventory_item']");
    By prodName = By.xpath(".//div[contains(@class,'inventory_item_name')]");
    By Lst_prdNames = By.xpath("//div[@class='inventory_item_name ']");
    By Lst_prdPrices = By.xpath("//div[@class='inventory_item_price']");
    By Lst_btnAddToCarts = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");
    By prdName = By.xpath("//div[@class='inventory_details_name large_size']");
    By btnAddCart = By.id("add-to-cart");
    By btnRemove = By.id("remove");
    By btnBackToProduct = By.id("back-to-products");
    By Lst_btnRemoveCard = By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory ']");
    By iconCart = By.xpath("//a[@class='shopping_cart_link']");
    By cartIconCount = By.xpath("//span[@class='shopping_cart_badge']");

    public String validatePageHeader() {
        return driver.findElement(pageHeader).getText();
    }

    public int totalProductList() {
        return driver.findElements(Lst_productsLsts).size();
    }

    public void cartIcon() {
        driver.findElement(iconCart).isDisplayed();
    }

    public void clk_carticon() {
        driver.findElement(iconCart).click();
    }

    public int cartIconCount() {
        List<WebElement> cartcount = driver.findElements(cartIconCount);
        if (cartcount.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(cartcount.get(0).getText());
    }

    public void sortdropdown() {
        driver.findElement(Slt_sortDrpdown).isDisplayed();
    }

    public void selectSortDropdown() {
        driver.findElement(Slt_sortDrpdown).click();
    }

    public void drpSelectValue(String selectValue) {
        Select select = new Select(driver.findElement(Slt_sortDrpdown));
        switch (selectValue) {
            case "Name (A to Z)":
                select.selectByVisibleText("Name (A to Z)");
                break;

            case "Name (Z to A)":
                select.selectByVisibleText("Name (Z to A)");
                break;

            case "Price (low to high)":
                select.selectByVisibleText("Price (low to high)");
                break;

            case "Price (high to low)":
                select.selectByVisibleText("Price (high to low)");
                break;
        }
    }

    public List<String> validateProductsSort() {
        List<String> nameList = new ArrayList<>();
        List<WebElement> names = driver.findElements(Lst_prdNames);
        for (WebElement e : names) {
            String name = e.getText();
            nameList.add(name);
        }
        return nameList;
    }

    public List<Double> validatePriceSort() {
        List<Double> priceList = new ArrayList<>();
        List<WebElement> prices = driver.findElements(Lst_prdPrices);
        for (WebElement e : prices) {
            String price = e.getText().replace("$", "").trim();
            priceList.add(Double.parseDouble(price));
        }
        return priceList;
    }

    public void clkProductname_single(String product) {
        List<WebElement> prdSelect = driver.findElements(Lst_prdNames);
        for (WebElement e : prdSelect) {
            if ((e.getText()).equals(product)) {
                e.click();
                break;
            }
        }
    }

    public void clkAddToCart_single(String product) {
        By addtocart = By.xpath("//div[text()='" +
                product + "']/ancestor::div[@class='inventory_item_description']//button[contains(text(),'Add')]");
        driver.findElement(addtocart).click();
    }

    public void clkAddToCart_multiple(List<String> products) {
        for (String productname : products) {
            clkAddToCart_single(productname);
        }

    }

    public void displayAddToCart_single(String product) {
        By addtocart = By.xpath("//div[text()='" +
                product + "']/ancestor::div[@class='inventory_item_description']//button[contains(text(),'Add')]");
        driver.findElement(addtocart).isDisplayed();
    }

    public void displayAddToCart_multiple(List<String> products) {
        for (String productname : products) {
            displayAddToCart_single(productname);
        }
    }

    public void clkRemove_single(String product) {
        By remove = By.xpath("//div[text()='" +
                product + "']/ancestor::div[@class='inventory_item_description']//button[contains(text(),'Remove')]");
        driver.findElement(remove).click();

    }

    public void clkRemove_multiple(List<String> products) {
        for (String removeproducts : products) {
            clkRemove_single(removeproducts);
        }

    }

    public void displayRemove_single(String product) {
        By remove = By.xpath("//div[text()='" +
                product + "']/ancestor::div[@class='inventory_item_description']//button[contains(text(),'Remove')]");
        driver.findElement(remove).isDisplayed();

    }

    public void displayRemove_multiple(List<String> products) {
        for (String productname : products) {
            displayRemove_single(productname);
        }
    }

    public List<String> get_removeProducts() {
        List<String> addedlist = new ArrayList<>();

        List<WebElement> prodlist = driver.findElements(Lst_productsLsts);
        System.out.println("Total Items: "+prodlist.size());

        for (WebElement elet : prodlist) {
            String button = elet.findElement(Lst_btnRemoveCard).getText();
            String name = elet.findElement(prodName).getText();

            System.out.println("button : "+button);
            System.out.println("name : "+name);
            if (button.equals("Remove")){
                addedlist.add(name);
        }
    }
        return addedlist;
    }

    public String get_prodprdname() {
        return driver.findElement(Lst_prdNames).getText();
    }

    //methods with suffix prd denotes inside the specific product page
    public String prdname_prd() {
        return driver.findElement(prdName).getText();
    }

    public void display_addtocart_prd() {
        if (driver.findElement(btnAddCart).isDisplayed()) {
            System.out.println("Add to Cart button is displayed");
        } else {
            System.out.println("Add to Cart button is not displayed");
        }
    }

    public void clk_addtocart_prd() {
        driver.findElement(btnAddCart).click();
    }

    public void display_remove_prd() {
        if (driver.findElement(btnRemove).isDisplayed()) {
            System.out.println("Remove button is displayed");
        } else {
            System.out.println("Remove button is not displayed");
        }
    }

    public void clk_remove_prd() {
        driver.findElement(btnRemove).click();
    }

    public void clk_backtoproduct_prd() {
        if (driver.findElement(btnBackToProduct).isDisplayed()) {
            driver.findElement(btnBackToProduct).click();
        } else {
            System.out.println("Back to Product is not displayed");
        }

    }

}




