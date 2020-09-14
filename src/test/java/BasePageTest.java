package test.java;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import main.java.base.BasePage;
import main.java.base.Page;
import main.java.util.HelperUtil;

public class BasePageTest {
	
	protected static WebDriver driver;
	public Page page;
	public Properties prop;
	private Logger log = Logger.getLogger(BasePageTest.class);

	@BeforeMethod
	@Parameters({"browser", "testUrl"})
	public void setUpTest(String browser, String testUrl) {
		log.info("****************************** Starting test cases execution : setUpTest *****************************************");
log.info(testUrl);
		prop = HelperUtil.loadPropertiesFile();
		
		BasicConfigurator.configure();

		if(browser.equals("chrome")){
			//TODO
			//WebDriverManager.chromedriver().setup();
			
			System.setProperty("webdriver.chrome.driver", (String) prop.get("webdriver.chrome.driver"));	
			//driver = new ChromeDriver(); // launch chrome
		
			//Create prefs map to store all preferences 
			Map<String, Object> prefs = new HashMap<String, Object>();

			//Put this into prefs map to switch off browser notification - 1:On 2:OFF 
			prefs.put("profile.default_content_setting_values.notifications", 2);

			//Create chrome options to set this prefs
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);

			//options.addArguments("--headless");
			//options.addArguments("--no-sandbox");
			
			//Now initialize chrome driver with chrome options which will switch off this browser notification on the chrome browser
			driver = new ChromeDriver(options);
			//driver = new ChromeDriver();
			
			//waitForLoad();
			page = new BasePage(driver);

		}
		else if(browser.equals("FF")){
			System.setProperty("webdriver.gecko.driver", (String) prop.get("webdriver.firefox.driver"));	
			driver = new FirefoxDriver(); 
		}
	
		Options options = driver.manage();
		
		options.window().maximize(); 
		driver.manage().deleteAllCookies();
		options.timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		options.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		driver.get(prop.getProperty(testUrl));
	}

	public static void takeScreenshot(String testcaseName) {
		//TODO: driver as non static
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("/Users/shailesh/Nileshwari/seleniumworkspace/Ecom_BrandForLess/screenshots/" + testcaseName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@AfterMethod
	public void tearDown() {
		log.info("************ @aftermethod : tearDown ***********");
		//driver.quit();
	}
	
}
