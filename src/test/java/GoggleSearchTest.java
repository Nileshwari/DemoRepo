package test.java;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoggleSearchTest {

	Logger log = Logger.getLogger(GoggleSearchTest.class);
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		BasicConfigurator.configure();
		log.info(
				"****************************** Starting GoggleSearchTest execution  *****************************************");

		System.setProperty("webdriver.chrome.driver", "/Users/shailesh/Nileshwari/seleniumDownloads/chromedriver");

		driver = new ChromeDriver();

		Options options = driver.manage();

		options.window().maximize();
		driver.manage().deleteAllCookies();
		options.timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		options.timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.com");

	}

	@Test(enabled = true)
	public void verifyGoogleSearchInputTest() {

		log.info("****************************** starting test case - verifyGoogleSearchInputTest *****************************************");

		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Selenium java");;
		List<WebElement> optionsList = driver.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='sbl1']"));
		
		for (int i = 0; i < optionsList.size(); i++) {
			log.info("optionsList item - " + i + " = " + optionsList.get(i).getText());

			if(optionsList.get(i).getText().contains("interview questions")) {
				optionsList.get(i).click();
				break;
			}
		}

	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
