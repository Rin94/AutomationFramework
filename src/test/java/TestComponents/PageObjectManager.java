package TestComponents;

import org.openqa.selenium.WebDriver;
import webstore.pages.*;

public class PageObjectManager {

    public LandingPage landingPage;
    public CartPage cartPage;

    public OrderReceiptPage orderReceiptPage;

    public ProductsPage productsPage;

    public WebDriver driver;
    public CheckoutPage checkoutPage;

    public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public LandingPage getLandingPage()
    {
        landingPage= new LandingPage(driver);
        return landingPage;
    }

    public ProductsPage getProductsPage()
    {
        productsPage= new ProductsPage(driver);
        return productsPage;
    }

    public CheckoutPage getCheckoutPage()
    {
        checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }

    public OrderReceiptPage getOrderReceiptPage()
    {
        orderReceiptPage = new OrderReceiptPage(driver);
        return orderReceiptPage;
    }

    public CartPage getCartPage()
    {
        cartPage = new CartPage(driver);
        return cartPage;
    }
}