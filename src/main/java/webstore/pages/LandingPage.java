package webstore.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BasePage.BasePage;
import utils.GlobalVariables;
import webstore.objectRepository.LandingPageObjects;

public class LandingPage extends BasePage{
	
	
	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = LandingPageObjects.XPATH_TXT_USEREMAIL)
	private WebElement txtUserEmailField;
	
	@FindBy(xpath = LandingPageObjects.XPATH_TXT_PASSWORD)
	private WebElement txtPasswordField;
	
	@FindBy(xpath = LandingPageObjects.XPATH_BTN_LOGIN)
	private WebElement btnLogin;
	@FindBy(xpath = LandingPageObjects.XPATH_TXT_LOGIN_ERROR_MESSAGE)
	private WebElement txtLoginErrorMessage;
	
	public ProductsPage login(String username, String password) {
		enterText(txtUserEmailField, username);
		enterText(txtPasswordField, password);
		clickElement(btnLogin);
		return new ProductsPage(driver);
	}

	public String getErrorMessage(){
		//waitUntilElementIsDisplayed(txtLoginErrorMessage, GlobalVariables.DELAY_MEDIUM);
		return getElementText(txtLoginErrorMessage);
	}
	
	public void goTo() {
		
		driver.get(GlobalVariables.WEB_URL);
	}
	
	
	
	
	
	

}
