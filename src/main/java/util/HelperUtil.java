package main.java.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HelperUtil {
	

	private static Properties propertiesFile;
	
	public static String []months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

	public static Properties loadPropertiesFile() {
//		System.out.println("Utilities >> loadPropertiesFile" + new File("").getAbsolutePath());		
		
		
			try {
				///Users/shailesh/Nileshwari/seleniumworkspace/Ecom_BrandForLess/src/main/resource/config.properties

//				/Users/shailesh/Nileshwari/seleniumworkspace/Ecom_BrandForLess/src/main/resource/config.properties
				System.out.println(System.getProperty("user.dir"));
				propertiesFile = new Properties();
				FileInputStream ip = new FileInputStream("/Users/shailesh/Nileshwari/seleniumworkspace/Ecom_BrandForLess/src/main/resource/config.properties");
				propertiesFile.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return propertiesFile;
		}
		
	
	 public static ArrayList<Object[]> getNewContactsList() {
		return fetchCustomersFromExcel();	
	}

	
	  public static ArrayList<Object[]> fetchCustomersFromExcel() {
	 
		ArrayList<Object[]> customerList = new ArrayList<Object[]>();
		ExcelReader excelReader = null;
		
		try {
			excelReader = new ExcelReader("/Users/shailesh/Nileshwari/seleniumworkspace/testData/testData.xlsx"); 
			//System.out.println("***" + excelReader + "***" + excelReader.getRowCount("Customers"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int rowCount = 2; rowCount <= excelReader.getRowCount("Customers"); rowCount++) {
			
			System.out.println(rowCount + ">>***" + excelReader.getCellData("Customers", "Firstname", rowCount));
			
			String firstName = excelReader.getCellData("Customers", "Firstname", rowCount);
			String lastName = excelReader.getCellData("Customers", "Lastname", rowCount);
			String emailId = excelReader.getCellData("Customers", "Email id", rowCount);
			String category = excelReader.getCellData("Customers", "Category", rowCount);
			String status = excelReader.getCellData("Customers", "Status", rowCount);
			
			String address = excelReader.getCellData("Customers", "Address", rowCount);
			String city = excelReader.getCellData("Customers", "City", rowCount);
			String zipcode = excelReader.getCellData("Customers", "Zipcode", rowCount);
			String country = excelReader.getCellData("Customers", "Country", rowCount);
			
			String phoneNumber= excelReader.getCellData("Customers", "Phone Number", rowCount);
			String position = excelReader.getCellData("Customers", "Position", rowCount);
			String source = excelReader.getCellData("Customers", "Source", rowCount);
			
			String doNotCallFlag = excelReader.getCellData("Customers", "Do Not Call", rowCount);
			String doNotTextFlag = excelReader.getCellData("Customers", "Do Not Text", rowCount);
			String doNotEmailFlag = excelReader.getCellData("Customers", "Do Not Email", rowCount);
			
			String dob = excelReader.getCellData("Customers", "Date Of Birth", rowCount);
			
			String img  = excelReader.getCellData("Customers", "Image", rowCount);
			System.out.println("********" + img);
			
			customerList.add(new Object[] {firstName, lastName, emailId, category, status, address, city, zipcode, country, phoneNumber, position, source, doNotCallFlag, doNotTextFlag, doNotEmailFlag, dob});
		}
		
		return customerList;
		
	}
	
	
	public static void setDropdownValue(WebDriver driver, WebElement element, List dropdownList, String valueSelected) {
		element.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		

		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();

		Iterator<WebElement> it = dropdownList.iterator();

		while (it.hasNext()) {
		    WebElement wb  = it.next();
		    if(wb.getText().equals(valueSelected)) {
		        wb.click();
		        break;
		    }
		}			
	}

	
	public static void clickByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
	}

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");		
	}

	public static void scrollPageUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-250)", "");
	}
	
	public static void refreshByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}

	public static int getUserInput(int size) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		System.out.println(input);

		return Integer.parseInt(input);
	}
	
}
