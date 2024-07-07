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

import static java.lang.Thread.sleep;


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

	protected void waitUntilElementIsDisplayed(By by, long delay) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(delay));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	public void waitForElementToDisappear(int time) {

		delay(time);

	}

	protected void waitUntilElementIsClickeable(WebElement element, long delay) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(delay));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void delay(int duration) {
        try {
            sleep((duration*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

	protected WebElement findElementByXpathGivenAString(String locator, String text) {
		locator = locator.replace("replace",text);
		return driver.findElement(By.xpath(locator));
	}

	public CartPage clickShopingCart() {
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
