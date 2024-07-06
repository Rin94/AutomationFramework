package webstore.pages;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GlobalVariables;
import webstore.objectRepository.OrdersPageObjects;

public class OrdersPage extends BasePage{


	@FindBy(xpath = OrdersPageObjects.XPATH_TXT_LAST_ORDER)
	private WebElement txtLastOrderName;

	public OrdersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getLastOrderProductName() {
		waitUntilElementIsDisplayed(txtLastOrderName, GlobalVariables.DELAY_MEDIUM);
		return getElementText(txtLastOrderName);
		
	}


}
