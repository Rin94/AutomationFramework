package webstore.pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import BasePage.BasePage;
import org.openqa.selenium.By;
import utils.GlobalVariables;
import webstore.objectRepository.ProductPageObjects;

public class ProductsPage extends BasePage{

	public ProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = ProductPageObjects.XPATH_TXT_PRODUCT_NAMES)
	private List <WebElement> productNamesList;
	@FindBy(xpath = ProductPageObjects.XPATH_TXT_ADDED_TO_CART_MESSAGE)
	private WebElement txtAdd2CartMessage;
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	By toastMessage = By.cssSelector("#toast-container");
	
	
	public void addProductToCart(String productName) {
		clickElement(findElementByXpathGivenAString( ProductPageObjects.XPATH_BTN_ADD_SHOPPING_CART, productName));
		waitUntilElementIsDisplayed(toastMessage, GlobalVariables.DELAY_LOW);
		waitForElementToDisappear(GlobalVariables.DELAY_LOW);
	}
	

	
	
	

	
	
	
	
	
	

}
