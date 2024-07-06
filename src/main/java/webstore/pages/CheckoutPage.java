package webstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import BasePage.BasePage;
import utils.GlobalVariables;
import webstore.objectRepository.CheckoutPageObjects;

public class CheckoutPage extends BasePage{
	
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = CheckoutPageObjects.XPATH_TXT_SELECT_COUNTRY)
	private WebElement txtCountryField;
	

	@FindBy(xpath = CheckoutPageObjects.XPATH_TXT_OPTION_COUNTRY)
	private WebElement textCountryFieldOption;
	
	@FindBy(xpath = CheckoutPageObjects.XPATH_BTN_PLACE_ORDER)
	private WebElement btnPlaceOrder;
	
	public void selectCountry(String productNameText) {
		
		sendKeysUsingActions(txtCountryField, productNameText);
		waitUntilElementIsDisplayed(textCountryFieldOption, GlobalVariables.DELAY_LOW);
		clickUsingActions(textCountryFieldOption);
		
	}
	
	public OrderReceiptPage placeOrder() {
		
		clickUsingActions(btnPlaceOrder);
		OrderReceiptPage orderReceiptPage = new OrderReceiptPage(driver);
		return orderReceiptPage;
		
	}
	
	
	

	
	
	

	
	
	
	
	
	

}
