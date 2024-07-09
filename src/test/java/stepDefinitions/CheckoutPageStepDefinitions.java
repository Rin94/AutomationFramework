package stepDefinitions;

import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import TestComponents.TestContextSetup;
import webstore.pages.CheckoutPage;

import static org.testng.Assert.assertEquals;

public class CheckoutPageStepDefinitions{

    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;

    public CheckoutPageStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.checkoutPage;

    }

    @And("^user selects his country (.+)$")
    public void and_user_select_his_country(String country){
        checkoutPage.selectCountry(country);
    }

    @And("Place the order")
    public void and_place_order(){
       this.testContextSetup.pageObjectManager.orderReceiptPage = checkoutPage.placeOrder();
       //checkoutPage.placeOrder();
    }

}
