package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.ProductsPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPageSteps {

    private ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());

    @Then("User is on the Products page")
    public void user_is_on_the_products_page() {
        String pageHeaderText = productsPage.validatePageHeader();
        Assert.assertEquals("Products", pageHeaderText);
    }

    @And("Product sort dropdown is present")
    public void product_sort_dropdown_is_present() {
        productsPage.sortdropdown();
    }

    @And("Cart icon with item count is present")
    public void cart_icon_with_item_count_is_present() {
        productsPage.cartIcon();
    }

    @And("Verify the total products on the Page")
    public void verify_the_total_products_on_the_page() {
        int prdlist = productsPage.totalProductList();
        Assert.assertEquals(6, prdlist);
        System.out.println("Total Products on the Page: " + prdlist);
    }

    @When("User click on Product Sort dropdown")
    public void user_click_on_products_sort_dropdown() {
        productsPage.selectSortDropdown();
    }

    @And("Select {string} from the dropdown")
    public void select_from_the_dropdown(String string) {
        productsPage.drpSelectValue(string);
    }

    @Then("Verify the products are sorted based on the {string} on Products Page")
    public void verify_the_products_are_sorted_based_on_the_on_products_page(String string) {
        switch (string) {
            case "Name (A to Z)":
                List<String> actualList1 = productsPage.validateProductsSort();
                List<String> expectedList1 = new ArrayList<>(actualList1);
                Collections.sort(expectedList1);
                System.out.println("Product names are sorted from A to Z");
                Assert.assertEquals(expectedList1, actualList1);
                break;

            case "Name (Z to A)":
                List<String> actualList2 = productsPage.validateProductsSort();
                List<String> expectedList2 = new ArrayList<>(actualList2);
                Collections.sort(expectedList2, Collections.reverseOrder());
                System.out.println("Product names are sorted from Z to A");
                Assert.assertEquals(expectedList2, actualList2);
                break;

            case "Price (low to high)":
                List<Double> actualList3 = productsPage.validatePriceSort();
                List<Double> expectedList3 = new ArrayList<>(actualList3);
                Collections.sort(expectedList3);
                System.out.println("Product prices are sorted from low to high");
                Assert.assertEquals(expectedList3, actualList3);
                break;

            case "Price (high to low)":
                List<Double> actualList4 = productsPage.validatePriceSort();
                List<Double> expectedList4 = new ArrayList<>(actualList4);
                Collections.sort(expectedList4, Collections.reverseOrder());
                System.out.println("Product prices are sorted from high to low");
                Assert.assertEquals(expectedList4, actualList4);
                break;
        }
    }

    @When("User clicks on the {string}")
    public void user_clicks_on_the(String product) {
        productsPage.clkProductname_single(product);
    }

    @Then("Selected specific {string} page is displayed")
    public void selected_page_is_displayed(String product) throws InterruptedException {
        Thread.sleep(1000);
        String actual_prd_name = productsPage.prdname_prd();
        Assert.assertEquals(product, actual_prd_name);
    }

    @When("User clicks on Add to cart in specific product page")
    public void user_clicks_on_add_to_cart_in_specific_product_page() throws InterruptedException {
        int beforecount = productsPage.cartIconCount();
        Thread.sleep(1000);
        productsPage.clk_addtocart_prd();
        productsPage.display_remove_prd();
        int aftercount = productsPage.cartIconCount();
        Assert.assertEquals(aftercount, beforecount + 1);
    }

    @Then("Remove button is displayed")
    public void remove_button_is_displayed() {
        productsPage.display_remove_prd();
    }

    @When("User click on Remove in specific product page")
    public void user_click_on_remove_in_specific_product_page() {
        int beforecount = productsPage.cartIconCount();
        productsPage.clk_remove_prd();
        int aftercount = productsPage.cartIconCount();
        Assert.assertEquals(aftercount, beforecount - 1);
    }

    @Then("Add to cart is displayed")
    public void add_to_cart_is_displayed() {
        productsPage.display_addtocart_prd();
    }

    @And("Validate Cart Item count without any action")
    public void validate_cart_item_count_without_any_action() {
        int cartcount = productsPage.cartIconCount();
        System.out.println("Cart count without any action: " + cartcount);
    }

    @Then("Then Cart icon is updated with item count after adding {string}")
    public void cart_icon_is_updated_with_item_count() {
        int count = productsPage.cartIconCount();

    }

    @Then("Remove button is displayed for specific {string}")
    public void remove_button_is_displayed_for_specific(String product) {
        productsPage.displayRemove_single(product);
    }

    @When("User click on Remove of specific {string}")
    public void user_click_on_remove_of_specific(String product) {
        int beforecount = productsPage.cartIconCount();
        productsPage.clkRemove_single(product);
        int aftercount = productsPage.cartIconCount();
        Assert.assertEquals(aftercount, beforecount - 1);
    }

    @Then("Add to cart is displayed for specific {string}")
    public void add_to_cart_is_displayed_for_specific(String product) {
        productsPage.displayAddToCart_single(product);
    }

    @And("Click on Back to Products Page")
    public void click_on_back_to_products_page() throws InterruptedException {
        Thread.sleep(1000);
        productsPage.clk_backtoproduct_prd();
        Thread.sleep(1000);
        Assert.assertEquals("Products", productsPage.validatePageHeader());
    }

    @Then("Verify the {string} is selected on the Products Page")
    public void verify_the_is_selected_on_the_products_page(String product) {
        productsPage.displayRemove_single(product);
    }

    @When("User clicks on Add to cart of specific {string}")
    public void user_click_on_add_to_cart_of_specific(String product) {
        int beforecount = productsPage.cartIconCount();
        productsPage.clkAddToCart_single(product);
        int aftercount = productsPage.cartIconCount();
        Assert.assertEquals(aftercount, beforecount + 1);
    }

    @When("User clicks on Add to cart of multiple products")
    public void user_clicks_on_Add_to_Cart_of_multiple_products(DataTable datatable) {
        int beforecount = productsPage.cartIconCount();
        List<String> expectedProducts = datatable.asList();
        productsPage.clkAddToCart_multiple(expectedProducts);
        int aftercount = productsPage.cartIconCount();
        Assert.assertEquals(aftercount, beforecount + expectedProducts.size());
    }

    @Then("Remove button is displayed for multiple products")
    public void remove_button_is_displayed_for_multiple_products(DataTable datatable) {
        List<String> expectedremoveProducts = datatable.asList();
        productsPage.displayRemove_multiple(expectedremoveProducts);

    }

    @When("User click on Remove for multiple products")
    public void user_click_on_remove_for_multiple_products(DataTable datatable) {
        int beforecount = productsPage.cartIconCount();
        List<String> expectedclkremoveProducts = datatable.asList();
        productsPage.clkRemove_multiple(expectedclkremoveProducts);
        int aftercount = productsPage.cartIconCount();
        Assert.assertEquals(aftercount, beforecount - expectedclkremoveProducts.size());
    }

    @Then("Add to cart is displayed for mutliple products")
    public void add_to_cart_is_displayed_for_multiple_products(DataTable datatable) {
        List<String> expectedaddtocartProducts = datatable.asList();
        productsPage.displayAddToCart_multiple(expectedaddtocartProducts);
    }

    @Then("Verify that all the below products are selected on the Products Page")
    public void verify_that_all_the_below_products_are_selected_on_the_products_page(DataTable datatable) {
        List<String> selectedproducts = datatable.asList();
        productsPage.displayRemove_multiple(selectedproducts);
    }

    @When("User clicks on Cart icon on Products Page")
    public void user_clicks_on_cart_icon_on_products_page() {
        productsPage.clk_carticon();
    }


}
