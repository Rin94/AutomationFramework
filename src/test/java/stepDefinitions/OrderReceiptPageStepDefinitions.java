package stepDefinitions;

import TestComponents.BaseTest;
import io.cucumber.java.en.Then;
import TestComponents.TestContextSetup;
import webstore.pages.*;

import static org.testng.Assert.assertEquals;

public class OrderReceiptPageStepDefinitions{

    public OrderReceiptPage orderReceiptPage;
    TestContextSetup testContextSetup;

    public OrderReceiptPageStepDefinitions(TestContextSetup testContextSetup){

        this.testContextSetup= testContextSetup;
        this.orderReceiptPage = testContextSetup.pageObjectManager.orderReceiptPage;

    }

    @Then("^The page displays the (.+)$")
    public void  paage_display_corfirmation_order(String confirmationOrder) {
        String actualText = orderReceiptPage.getOrderReceiptHeader();
        assertEquals(actualText,confirmationOrder);
    }




}
