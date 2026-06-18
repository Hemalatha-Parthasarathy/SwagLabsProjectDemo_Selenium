package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.CartPage;
import pageObjects.ProductsPage;

import java.util.ArrayList;
import java.util.List;

public class CartPageSteps {
    private ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());
    private CartPage cartPage = new CartPage(DriverFactory.getDriver());


    @Then("User is on the cart page")
    public void user_is_on_the_cart_page() {
        String cartpagetitle = cartPage.validatePagetitle();
        Assert.assertEquals("Your Cart", cartpagetitle);
    }

    @And("Continue shopping and Checkout is displayed")
    public void continue_shopping_and_checkout_is_displayed() {
        String txt_checkout = cartPage.display_txtcheckout();
        Assert.assertEquals("Checkout", txt_checkout);
        String txt_continueshop = cartPage.display_txtcontinueshop();
        Assert.assertEquals("Continue Shopping", txt_continueshop);
    }

    @And("Quantity and Description is displayed")
    public void quantity_and_description_is_dispalyed() {
        String txt_quantity = cartPage.display_txtquantity();
        Assert.assertEquals("QTY", txt_quantity);
        String txt_description = cartPage.display_txtdescription();
        Assert.assertEquals("Description", txt_description);
    }

    @And("Cart icon with quantity is displayed")
    public void cart_icon_with_quantity_is_displayed() {
        String itemcount = cartPage.get_iconitemcount();
        Assert.assertEquals("2", itemcount);
    }

    @And("Cart icon and quantity is displayed")
    public void cart_icon_and_quantity_is_displayed() {
        cartPage.display_iconCart();
        cartPage.display_cartItemCount();

    }


    @And("Verify that the selected {string} is on the Cart Page")
    public void verify_that_the_selected_is_on_the_cart_page(String product) {
        String actualprodname = cartPage.get_cartprodname();
        Assert.assertEquals(product, actualprodname);

    }

    @And("Verify that the Cart page contains the selected products")
    public void verify_that_the_cart_page_contains_the_selected_products() {
        List<String> cartPageProducts = cartPage.get_cartprodname_multiple();
        cartPage.clk_txtcontinueshop();
        productsPage.validatePageHeader();
        List<String> productPageProducts = productsPage.get_removeProducts();
        Assert.assertEquals(productPageProducts,cartPageProducts);
        productsPage.clk_carticon();

    }

    @When("User clicks on Remove button of {string}")
    public void user_clicks_on_remove_button_of(String product) {
        int beforecount = Integer.parseInt(cartPage.get_iconitemcount());
        System.out.println(beforecount);
        cartPage.clk_cartRemove(product);
        Assert.assertTrue("Cart Item count is Empty",cartPage.cartItemCountNotpresent());
    }

    @When("User clicks on Remove button of specific {string}")
    public void user_clicks_on_remove_button_of_specific(String product) {
        int beforecount = Integer.parseInt(cartPage.get_iconitemcount());
        System.out.println(beforecount);
        cartPage.clk_cartRemove(product);
        int aftercount = Integer.parseInt(cartPage.get_iconitemcount());
        System.out.println(aftercount);
        Assert.assertEquals(aftercount, (beforecount - 1));
        }


    @When("User clicks on Remove for multiple products on cart page")
    public void user_clicks_on_remove_for_multiple_products_on_cart_page(DataTable dataTable) {
        int beforecount = Integer.parseInt(cartPage.get_iconitemcount());
        List<String> removelist = dataTable.asList();
        cartPage.clk_removemultiple(removelist);
        Assert.assertTrue("Cart Item count is Empty",cartPage.cartItemCountNotpresent());
    }

    @Then("Removed {string} should not be displayed on Cart page")
    public void removed_should_not_be_displayed_on_cart_page(String product) {
        List<String> cartprodlist = cartPage.get_cartprodname_multiple();
        if (!cartprodlist.contains(product)) {
            System.out.println("Items are not present in the cart page: " );
        }
        else{
            System.out.println("Items is present in the cart page: " );
        }


    }

    @Then("Removed products should not be displayed on Cart page")
    public void removed_products_should_not_be_displayed_on_cart_page(DataTable dataTable) {
        List<String> removedlist = dataTable.asList();
        List<String> cartprodlist = cartPage.get_cartprodname_multiple();
        List<String> noitemlist = new ArrayList<>();
        for (String item : removedlist) {
            if (!cartprodlist.contains(item)) {
                noitemlist.add(item);
            }
        }
        System.out.println("Items are not present in the cart page: " + noitemlist);
    }

    @And("Validate cart products and cart Icon item count")
    public void validate_cart_products_and_cart_icon_item_count() {
        int prodcount = cartPage.cartprodcount();
        Assert.assertEquals(0, prodcount);
        int itemcount = productsPage.cartIconCount();
        Assert.assertEquals(0, itemcount);
    }

    @Then("Removed product should not be displayed on Cart Page")
    public void removed_product_should_not_be_displayed_on_cart_page(DataTable dataTable) {
        List<String> removedlist = dataTable.asList();
    }
}
