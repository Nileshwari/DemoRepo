package test.java;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragDropFeatureTest {

		Logger log = Logger.getLogger(DragDropFeatureTest.class);
		WebDriver driver;
		
		@BeforeMethod
		public void setUp() {
			BasicConfigurator.configure();
			log.info("****************************** Starting DragDropFeatureTest execution  *****************************************");
			
			System.setProperty("webdriver.chrome.driver", "/Users/shailesh/Nileshwari/seleniumDownloads/chromedriver");	

			driver = new ChromeDriver();

			Options options = driver.manage();
			
			options.window().maximize(); 
			driver.manage().deleteAllCookies();
			options.timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			options.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  		
			driver.get("https://jqueryui.com/droppable/");

		}

		@Test(enabled=true)
		public void verifyDragDropFeatureTest(){
			
			log.info("****************************** starting test case - verifyDragDropFeatureTest *****************************************");
			
		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
			
			//WebElement on which drag and drop operation needs to be performed
			WebElement fromElement = driver.findElement(By.xpath("//div[@id='draggable']"));

			//WebElement to which the above object is dropped
			WebElement toElement = driver.findElement(By.xpath("//div[@id='droppable']"));

			//Creating object of Actions class to build composite actions
			Actions builder = new Actions(driver);

			//Building a drag and drop action
			Action dragAndDrop = builder.clickAndHold(fromElement)
										.moveToElement(toElement)
										.release(toElement)
										.build();

			//Performing the drag and drop action
			dragAndDrop.perform();		
		}
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}

}
