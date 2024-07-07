package Orders;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.DataReader;
import utils.GlobalVariables;
import webstore.pages.*;

public class SumbitOrderTest extends BaseTest{


	String productNameTxt;

	@Test(dataProvider = "getData", groups = {"Purchase"})
	public void submitOrder(HashMap<String,String>input) throws InterruptedException, IOException {

		ProductsPage productsPage = landingPage.login(input.get("email"), input.get("password"));
		productNameTxt = input.get("product");
		productsPage.addProductToCart(productNameTxt);
		CartPage cartPage = productsPage.clickShopingCart();
		boolean match = cartPage.verifyProductDisplayInTheCart(productNameTxt);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
		checkoutPage.selectCountry(input.get("country"));
		OrderReceiptPage orderReceiptPage = checkoutPage.placeOrder();
		String actualText = orderReceiptPage.getOrderReceiptHeader();
		assertEquals(actualText,input.get("orderConfirmation"));

	}
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest(){

		landingPage.login("jared12345@gmail.com", "Admin@12345");
		OrdersPage ordersPage =landingPage.clickOnOrders();
		String actualOrderName = ordersPage.getLastOrderProductName();
		Assert.assertEquals(productNameTxt, actualOrderName);
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String,String>>  data = DataReader.getJsonDataToMap(GlobalVariables.TEST_DATA_PURCHASE_ORDER_PATH);
		return new Object[][]{{data.get(0)},{data.get(1)}};
	}


}
