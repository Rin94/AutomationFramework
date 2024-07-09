package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.CurrentDateAndTime;
import utils.GetCurrentDateTime;
import utils.GlobalVariables;
import webstore.pages.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(GlobalVariables.SYSTEM_DIR_PATH+GlobalVariables.PROPERTIES_PATH);
		properties.load(fis);
		String browserName =System.getProperty("browser") != null ? System.getProperty("browser") : properties.getProperty("browser");
		String headless = System.getProperty("headless")!= null ? System.getProperty("headless") : properties.getProperty("headless");

		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if(headless.equals("yes")){
				options.addArguments("--headless=new");

			}
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver(options);
			
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVariables.DELAY_HIGH));
		driver.manage().window().maximize();
		fis.close();
		return driver;
		
	}

	public  String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String fileNamePath = GlobalVariables.REPORTS_PATH+ testCaseName +"-"+CurrentDateAndTime.getCurrentTime()+ ".png";
		File file = new File(fileNamePath);
		FileUtils.copyFile(source, file );
		return ts.getScreenshotAs(OutputType.BASE64);
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage lauchApplication() throws IOException {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return new LandingPage(driver);
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
