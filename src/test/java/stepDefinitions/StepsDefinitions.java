package stepDefinitions;

import TestComponents.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import webstore.pages.*;
import java.io.IOException;
import static org.testng.Assert.assertEquals;

public class StepsDefinitions extends BaseTest {

    public LandingPage landingPage;
    public ProductsPage productsPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public OrderReceiptPage orderReceiptPage;
    @Given("I landed on Ecommerce page")
    public void I_landed_on_Eccomerce_Page() throws IOException {
        landingPage = lauchApplication();

    }
    @Given ("^username (.+) and password (.+) is logged$")
    public  void username_and_password_is_logged(String username, String password){
        productsPage = landingPage.login(username,password);
    }

    @When("^A product (.+) is added to the Cart")
    public void when_a_product_is_added_to_the_cart(String productName){
        productsPage.addProductToCart(productName);
        cartPage = productsPage.clickShopingCart();
        boolean match = cartPage.verifyProductDisplayInTheCart(productName);
        //Assert.assertTrue(match);
        checkoutPage = cartPage.clickCheckoutButton();
    }

    @And("^user selects his country (.+)$")
    public void and_user_select_his_country(String country){
        checkoutPage.selectCountry(country);
    }

    @And("Place the order")
    public void and_place_order(){
        orderReceiptPage = checkoutPage.placeOrder();
    }

    @Then("^The page displays the (.+)$")
    public void  paage_display_corfirmation_order(String confirmationOrder) {
        String actualText = orderReceiptPage.getOrderReceiptHeader();
        assertEquals(actualText,confirmationOrder);
    }

    @Then("^the (.+) message is displayed$")
    public void the_message_is_displayed(String errorMessage) {
        // Write code here that turns the phrase above into concrete actions
        String actualErrorMessage = landingPage.getErrorMessage();
        Assert.assertEquals(errorMessage, actualErrorMessage);

    }

    @After
    public void afterScenario(){
        driver.close();
        driver.quit();

    }

}
