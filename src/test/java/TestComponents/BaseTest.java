package TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.GlobalVariables;
import webstore.pages.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//Config.properties");
		properties.load(fis);
		String browserName =properties.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver(options);
			
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVariables.DELAY_HIGH));
		driver.manage().window().maximize();
		
		return driver;
		
	}
	@BeforeMethod(alwaysRun = true)
	public LandingPage lauchApplication() throws IOException {
		
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return new LandingPage(driver);

	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
		driver.quit();
	}
	
	

}
