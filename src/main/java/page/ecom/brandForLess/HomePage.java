package main.java.page.ecom.brandForLess;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import main.java.base.BasePage;

public class HomePage extends BasePage {

	private By logoImage = By.xpath("//img[contains(@alt, 'BRANDS FOR LESS')]");
	private By homeAndLivingTab = By.xpath("//li[contains(@class, 'top-level-menu')]/span[contains(@class, 'arrow-wrapper')]/span[contains(text(), 'Home & Living')]");
	private By searchInput = By.xpath("//input[@id='search_input' and @placeholder='Search for items or brands']");
	//private By searchInputHistoryList = By.xpath("//ul[@class = 'search_trending search_recent']/li");
	//private By deleteSearchInputHistoryItem = By.xpath("//ul[@class = 'search_trending search_recent']/li/button[@class = 'cross_btn']");
		
	// Initializing the Page Objects:
	public HomePage(WebDriver driver) {
		super(driver);
	}


	public WebElement getLogoImage() {
		return getElement(logoImage);
	}


	public WebElement getHomeAndLivingTab() {
		return getElement(homeAndLivingTab);
	}


	public WebElement getSearchInput() {
		return getElement(searchInput);
	}
	
	public String getHomePageTitle() {
		return getPageTitle();
	}
	
	public String getHomePageHeader() {
		return "test header";
				//return getPageHeader(locator);
	}
	
//TODO
//	public HomePage doLogin(String username, String password) {
		/*getEmailId().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();
		
		return getInstance(HomePage.class);*/
		
//	}

	public boolean verifyHomePageLogo() {
		Object result = ((JavascriptExecutor) driver).executeScript(
				   "return arguments[0].complete && "+
				   "typeof arguments[0].naturalWidth != \"undefined\" && "+
				   "arguments[0].naturalWidth > 0", logoImage);

				    boolean loaded = false;
				    if (result instanceof Boolean) {
				      loaded = (Boolean) result;
				    }
				    
	    return loaded;
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public void moveOverHomeandLiving() {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(getElement(homeAndLivingTab)).build().perform();
		
			Thread.sleep(2000);
			
			driver.findElement(By.linkText("Bedding")).click();
			//action.moveToElement(driver.findElement(By.linkText("Bedding"))).click().build().perform();
			action.moveByOffset(10, 10);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
	}

	public void moveOverPropertyForRent() {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.linkText("Property for Rent"))).build().perform();
		
			Thread.sleep(2000);
			
			driver.findElement(By.linkText("Apartment/Flat for Rent")).click();
			//action.moveToElement(driver.findElement(By.linkText("Apartment/Flat for Rent"))).click().build().perform();
			//action.release();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

	public void insertDataIntoSearchInput() {
		WebElement searchField = getElement(searchInput);
		searchField.sendKeys("waterbottle");
		searchField.sendKeys(Keys.ENTER);

	}

	public void selectSearchHistoryItem() {
		getElement(searchInput).click();
		
		WebElement searchItem = driver.findElement(By.xpath("//ul[@class = 'search_trending search_recent']/li[contains(text(), 'hanger')]"));
		searchItem.click();
		
	}

	public void deleteSearchHistory() {
		getElement(searchInput).click();

		WebElement deleteItemButton = driver.findElement(By.xpath("//ul[@class = 'search_trending search_recent']/li[contains(text(), 'waterbottle')/button[@class = 'cross_btn']"));
		deleteItemButton.click();
	}

	public void navigateforwardAndBack() throws InterruptedException {
		//insertDataIntoSearchInput();
		//Thread.sleep(2000);
		
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.gmail.com/");
		Thread.sleep(2000);
		
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.navigate().back();
		Thread.sleep(3000);

		//TODO: not working with brandForLess.. else working between ggogle and gmail
		driver.navigate().forward();
		Thread.sleep(2000);

		//driver.navigate().back();
	}
}