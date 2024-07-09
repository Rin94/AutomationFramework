package stepDefinitions;


import io.cucumber.java.en.When;
import TestComponents.TestContextSetup;
import webstore.pages.CartPage;
import webstore.pages.ProductsPage;

public class ProductsPageStepDefinitions{

    TestContextSetup testContextSetup;
    ProductsPage productsPage;
    CartPage cartPage;
    public ProductsPageStepDefinitions(TestContextSetup testContextSetup){

        this.testContextSetup=testContextSetup;
        this.productsPage = testContextSetup.pageObjectManager.productsPage;
        this.cartPage = testContextSetup.pageObjectManager.getCartPage();
    }

    @When("^A product (.+) is added to the Cart")
    public void when_a_product_is_added_to_the_cart(String productName){
        productsPage.addProductToCart(productName);
        cartPage = productsPage.clickShopingCart();
        boolean match =  cartPage.verifyProductDisplayInTheCart(productName);
        //Assert.assertTrue(match);
        this.testContextSetup.pageObjectManager.checkoutPage=cartPage.clickCheckoutButton();
    }

}
