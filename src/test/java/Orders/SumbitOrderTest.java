package Orders;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.GlobalVariables;
import webstore.pages.*;

public class SumbitOrderTest extends BaseTest{


	String productNameTxt = "ZARA COAT 3";

	@Test
	public void submitOrder() throws InterruptedException, IOException {

		ProductsPage productsPage = landingPage.login("jared12345@gmail.com", "Admin@12345");
		productsPage.addProductToCart(productNameTxt);
		CartPage cartPage = productsPage.clickShopingCart();
		boolean match = cartPage.verifyProductDisplayInTheCart(productNameTxt);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
		checkoutPage.selectCountry("Belgium");
		OrderReceiptPage orderReceiptPage = checkoutPage.placeOrder();
		String actualText = orderReceiptPage.getOrderReceiptHeader();
		assertEquals(actualText,"THANKYOU FOR THE ORDER.");

	}
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest(){

		landingPage.login("jared12345@gmail.com", "Admin@12345");
		OrdersPage ordersPage =landingPage.clickOnOrders();
		String actualOrderName = ordersPage.getLastOrderProductName();
		Assert.assertEquals(productNameTxt, actualOrderName);
	}

	@DataProvider
	public Object[][] getData(){
		HashMap<Object,Object> map = new HashMap<Object,Object>();
		return new Object[][]{{},{}};

	}


}
