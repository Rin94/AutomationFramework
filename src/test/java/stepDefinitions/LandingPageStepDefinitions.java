package stepDefinitions;

import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import TestComponents.TestContextSetup;
import webstore.pages.LandingPage;
import java.io.IOException;

public class LandingPageStepDefinitions{

    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
        this.landingPage =testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("I landed on Ecommerce page")
    public void I_landed_on_Eccomerce_Page(){
        landingPage.goTo();
    }
    @Given ("^username (.+) and password (.+) is logged$")
    public  void username_and_password_is_logged(String username, String password){
        testContextSetup.pageObjectManager.productsPage = landingPage.login(username,password);
    }

    @Then("^the (.+) message is displayed$")
    public void the_message_is_displayed(String errorMessage) {
        // Write code here that turns the phrase above into concrete actions
        String actualErrorMessage = landingPage.getErrorMessage();
        Assert.assertEquals(errorMessage, actualErrorMessage);

    }

}
