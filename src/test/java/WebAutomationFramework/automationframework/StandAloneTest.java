package WebAutomationFramework.automationframework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.GlobalVariables;
import webstore.pages.CartPage;
import webstore.pages.CheckoutPage;
import webstore.pages.LandingPage;
import webstore.pages.OrderReceiptPage;
import webstore.pages.ProductsPage;

public class StandAloneTest {
	
	public static void main(String[] args) throws InterruptedException {
		
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVariables.DELAY_HIGH));
		driver.manage().window().maximize();

		//Get to landingPage
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		ProductsPage productsPage = landingPage.login("jared12345@gmail.com", "Admin@12345");
		String productNameTxt = "ZARA COAT 3";
		productsPage.addProductToCart(productNameTxt);
		CartPage cartPage = productsPage.clickShopingCart();
		boolean match = cartPage.verifyProductDisplayInTheCart(productNameTxt);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
		checkoutPage.selectCountry("Belgium");
		OrderReceiptPage orderReceiptPage =checkoutPage.placeOrder();
	
		String actualText = orderReceiptPage.getOrderReceiptHeader();
		assertEquals(actualText,"THANKYOU FOR THE ORDER.");
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		
		
		
		
		
	}
	

}
