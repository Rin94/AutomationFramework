package Login;

import TestComponents.BaseTest;
import TestComponents.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;
import webstore.pages.CartPage;
import webstore.pages.CheckoutPage;
import webstore.pages.OrderReceiptPage;
import webstore.pages.ProductsPage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ErrorValidationsTest extends BaseTest{
	
	
	@Test(groups = {"smoke-test"}, retryAnalyzer = Retry.class)
	public void getLoginErrorMessage() throws InterruptedException, IOException {

		landingPage.login("wrong@gmail.com", "Admin@12345");
		String actualErrorMessage = landingPage.getErrorMessage();
		Assert.assertEquals("Incorrect email or password.", actualErrorMessage);

	}
	@Test
	public void verifyProductName() throws InterruptedException, IOException {

		ProductsPage productsPage = landingPage.login("jared12345@gmail.com", "Admin@12345");
		String productNameTxt = "ZARA COAT 3";
		productsPage.addProductToCart(productNameTxt);
		CartPage cartPage = productsPage.clickShopingCart();
		boolean match = cartPage.verifyProductDisplayInTheCart(productNameTxt);
		Assert.assertTrue(match);

	}
	

}
