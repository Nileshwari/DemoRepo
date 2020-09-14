package main.java.base;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.util.HelperUtil;

public class BasePage extends Page {
	
	public BasePage(WebDriver driver) {
		super(driver);
	}

	public static WebDriver driver;
	public static Properties prop;

//	public  static EventFiringWebDriver e_driver;
//	public static WebEventListener eventListener;
	
	public void initialization() {
//		System.out.println("AutomationParent >> initialization");
		
		prop = HelperUtil.loadPropertiesFile();
		
		String browserName = prop.getProperty("test.browser");
		
		if(browserName.equals("chrome")){
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

		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", (String) prop.get("webdriver.firefox.driver"));	
			driver = new FirefoxDriver(); 
		}
	
		Options options = driver.manage();
		
		options.window().maximize(); 
		driver.manage().deleteAllCookies();
		options.timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		options.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		driver.get(prop.getProperty("test.url"));
	}
	
	public static void failedCases() {
		File failedScreenshotImg = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(failedScreenshotImg, new File((String) prop.get("test.fail.screenshot.path")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static void switchToFrame (String frameName) {
	       driver.switchTo().frame(frameName);
	}

	public static void switchToFrame (int frameId) {
	       driver.switchTo().frame(frameId);	
	}
	
	public static void switchToFrame (WebElement element) {
	       driver.switchTo().frame(element);	
	}

	public void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
										                    public Boolean apply(WebDriver driver) {
										                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
										                    }
										                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
	
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Error while creating webelement " + locator.toString());
			e.printStackTrace();
		}
		
		return element;
	}

	@Override
	public List<WebElement> getElements(By locator) {
		List<WebElement> element = null;
		
		try {
			waitForElementPresent(locator);
			element = driver.findElements(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Error while creating webelement " + locator.toString());
			e.printStackTrace();
		}
		
		return element;
	}
	
	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("Error while waiting for webelement " + locator.toString());
			e.printStackTrace();			
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("Error while waiting for Page title : " + title);
			e.printStackTrace();			
		}		
	}
}
