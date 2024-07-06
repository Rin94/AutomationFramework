package webstore.pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import BasePage.BasePage;
import utils.PageScroll;
import webstore.objectRepository.CartPageObjects;

public class CartPage extends BasePage{
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = CartPageObjects.XPATH_TXT_PRODUCT_NAMES)
	private List <WebElement> productNamesList;
	

	@FindBy(xpath = CartPageObjects.XPATH_BTN_CHECKOUT)
	private WebElement btnCheckout;
	
	
	public Boolean verifyProductDisplayInTheCart(String productNameText) {
		
		Boolean match = productNamesList.stream().anyMatch(productName->getElementText(productName).equalsIgnoreCase(productNameText));
		return match;
		
	}
	
	public CheckoutPage clickCheckoutButton() {
		PageScroll.scrollToElement(btnCheckout, driver);
		clickElement(btnCheckout);
		return new CheckoutPage(driver);
		
	}
	
	
	

	
	
	

	
	
	
	
	
	

}
