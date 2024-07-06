package webstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import BasePage.BasePage;
import utils.GlobalVariables;
import webstore.objectRepository.OrderReceiptPageObjects;

public class OrderReceiptPage extends BasePage{
	
	
	@FindBy(xpath = OrderReceiptPageObjects.XPATH_TXT_ORDER_HEADER)
	private WebElement txtOrderReceiptHeader;
	
	
	public OrderReceiptPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getOrderReceiptHeader() {
		waitUntilElementIsDisplayed(txtOrderReceiptHeader, GlobalVariables.DELAY_MEDIUM);
		return getElementText(txtOrderReceiptHeader);
		
	}


}
