package main.java.page.crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.base.BasePage;

public class HomePage extends BasePage{

	private By userNameLabel = By.xpath("//span[@class = 'user-display']");
	private By contactsLink = By.xpath("//a[@href='/contacts']");
	private By calendarLink = By.xpath("//a[@href='/calendar']");
	private By deleteButton = By.xpath("//button[contains(class(),'ui basic button item')]");
		
	// Initializing the Page Objects:
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getUserNameLabel() {
		return getElement(userNameLabel);
	}

	public WebElement getContactsLink() {
		return getElement(contactsLink);
	}

	public WebElement getCalendarLink() {
		return getElement(calendarLink);
	}

	public WebElement getDeleteButton() {
		return getElement(deleteButton);
	}

	public String getHomePageTitle(){
		return getPageTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return getElement(userNameLabel).isDisplayed();
	}
	 
	public void clickOnContactsLink(){		
		getElement(contactsLink).click();
	}
	
	public void clickOnCalendarLink(){
		getElement(calendarLink).click();
	}
	
	public boolean verifyDeleteButton(){
		return deleteButton != null ? true : false;
	}
	
	
}
