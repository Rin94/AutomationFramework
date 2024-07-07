package BasePage;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;
import webstore.objectRepository.BasePageObjects;
import webstore.pages.CartPage;
import webstore.pages.OrdersPage;


public class BasePage {
	
	@FindBy(xpath = BasePageObjects.XPATH_BTN_SHOPPINGCART)
	private WebElement btnShoppingCart;
	@FindBy(xpath = BasePageObjects.XPATH_BTN_ORDERS)
	private WebElement btnOders;
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	protected void enterText(WebElement element, String text) {

		waitUntilElementIsDisplayed(element, GlobalVariables.DELAY_LOW);
		element.clear();
		element.sendKeys(text);
	}
	
	protected void clickElement(WebElement element) {
		waitUntilElementIsDisplayed(element, GlobalVariables.DELAY_LOW);
		element.click();
	}
	
	protected String getElementText(WebElement element) {
		waitUntilElementIsDisplayed(element, GlobalVariables.DELAY_LOW);
		return element.getText();
	}
	
	protected String getElementAttribute(WebElement element, String attributeName) {
		waitUntilElementIsDisplayed(element, GlobalVariables.DELAY_LOW);
		return element.getAttribute(attributeName);
	}
	
	protected void waitUntilElementIsDisplayed(WebElement element, long delay) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(delay));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitUntilElementIsClickeable(WebElement element, long delay) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(delay));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void delay(int duration) {
        try {
            Thread.sleep(duration* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
	
	
	protected void waitUntilLocatorIsDisplayed(String locator, String locatorType, long delay) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(delay));
		switch (locatorType) {
		
			case "XPATH":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
				break;
				
			case "ID":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				break;
				
			case "CSS":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorType)));
				break;
				
			case "CLASSNAME":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorType)));
				break;
				
		}
				
	}
	
	protected WebElement findElementByXpathGivenAString(String locator, String text) {
		locator = locator.replace("replace",text);
		WebElement element = driver.findElement(By.xpath(locator));
		
		return element;
		
	}

	public CartPage clickShopingCart() {
		delay(GlobalVariables.DELAY_MEDIUM);
		clickElement(btnShoppingCart);
		return new CartPage(driver);
	}

	public OrdersPage clickOnOrders(){
		delay(GlobalVariables.DELAY_LOW);
		clickElement(btnOders);
		return new OrdersPage(driver);
	}
	
	protected void clickUsingActions(WebElement element) {
		Actions a = new Actions(driver);
		a.click(element).build().perform();
	}
	
	protected void sendKeysUsingActions(WebElement element, String text) {
		Actions a = new Actions(driver);
		a.sendKeys(element, text).build().perform();
	}
	



}
