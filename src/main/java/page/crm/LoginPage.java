package main.java.page.crm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import main.java.base.BasePage;

public class LoginPage extends BasePage {

	private By username = By.name("email") ;
	private By password = By.name("password");
	private By loginBtn = By.xpath("//div[@class='ui fluid large blue submit button']");
	
	//TODO
	//@FindBy(xpath="//input[@type='submit']")
	
	// Initializing the Page Objects:
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getUsername() {
		return getElement(username);
	}

	public WebElement getPassword() {
		return getElement(password);
	}


	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}

	public String getLoginPageTitle(){
		return getPageTitle();
	}
	
//	public String getLoginPageHeader(){
//		return getPageHeader(getElement(locator));
//	}
	
//	public boolean validateCRMImage(){
//		return crmLogo.isDisplayed();
//	}
	
	public HomePage doLogin(String un, String pwd){
		getElement(username).sendKeys(un);
		getElement(password).sendKeys(pwd);
		//loginBtn.click();

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
		    	
		return getInstance(HomePage.class);
	}
	
}
