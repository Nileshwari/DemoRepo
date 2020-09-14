package main.java.page.crm;

import java.util.List;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.base.BasePage;
import main.java.util.HelperUtil;

public class ContactsPage extends BasePage {

	private By newContactButton = By.xpath("//a[@href='/contacts/new']");
	private By exportButton = By.xpath("//button[contains(text(), 'Export')]");
	private By showFiltersButton = By.xpath("//button[contains(text(), 'Show Filters')]");
	private By selectAllcheckBox = By.xpath("//input[@type = 'checkbox']/parent::div[@title = 'Select All']");
	private By viewContactButtonList = By.xpath("//a[contains(@href, '/contacts/edit/')]/preceding-sibling::a[contains(@href, '/contacts/')]");
	private By editContactButtonList = By.xpath("//a[contains(@href, '/contacts/edit/')]");
	private By deleteContactButtonList = By.xpath("//i[@class= 'trash icon']/parent:: button");
	//TODO
	private By deleteYesButton = By.xpath("//button[contains(text(), 'Cancel')]/following-sibling::button");
	private By action = By.xpath("//div[@role='option']/parent:: div/parent ::div[@name= 'action']");
	private By actionsList = By.xpath("//div[@name= 'action']/div/div[@role='option']");
	private By checkButton = By.xpath("//i[@class = 'checkmark icon']/ parent :: div[@role= 'button']");
	private By contactList = By.xpath("//tbody/tr");
	private By okExportButton = By.xpath("//div[@class = 'actions']/button[contains(text(), 'OK')]");
	private By cancelExportButton = By.xpath("//div[@class = 'actions']/button[contains(text(), 'Cancel')]");		
	/*
	 @FindBy(xpath = "")
	WebElement callContactButton;
	*/
	
	// Initializing the Page Objects:
	public ContactsPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getNewContactButton() {
		return getElement(newContactButton);
	}

	public WebElement getExportButton() {
		return getElement(exportButton);
	}

	public WebElement getShowFiltersButton() {
		return getElement(showFiltersButton);
	}

	public WebElement getSelectAllcheckBox() {
		return getElement(selectAllcheckBox);
	}

	public List<WebElement> getViewContactButtonList() {
		return getElements(viewContactButtonList);
	}

	public List<WebElement> getEditContactButtonList() {
		return getElements(editContactButtonList);
	}

	public List<WebElement> getDeleteContactButtonList() {
		return getElements(deleteContactButtonList);
	}

	public WebElement getDeleteYesButton() {
		return getElement(deleteYesButton);
	}

	public WebElement getActions() {
		return getElement(action);
	}

	public List<WebElement> getActionsList() {
		return getElements(actionsList);
	}

	public WebElement getCheckButton() {
		return getElement(checkButton);
	}

	public WebElement getContactList() {
		return getElement(contactList);
	}

	public WebElement getOkExportButton() {
		return getElement(okExportButton);
	}

	public WebElement getCancelExportButton() {
		return getElement(cancelExportButton);
	}

	public void clickCreateNewContactButton() {
//	public NewContactPage clickCreateNewContactButton() {
		getElement(newContactButton).click();
		//return new NewContactPage();
	}

	public void clickExportButton() {
		getElement(exportButton).click();
		getElement(okExportButton).click(); //TODO
	}
	
	public void clickShowFiltersButton() {
		getElement(showFiltersButton).click();
	}
	
	public void clickSelectAllContactsButton() {
		getElement(selectAllcheckBox).click();
		System.out.println("contactList>" + contactList);
		List<WebElement> options = driver.findElements(By.xpath("//input[@type = 'checkbox' and @class='hidden']/ parent::div"));

		for(int i = 0 ; i< options.size() ; i++){
			options.get(i).click();
		}
	}
	
	
	public void clickViewContactButton() {
		//TODO - //a[ contains(@href, '/contacts/edit/')][0]  Select item on runtime???
		performCrudOperation(getElements(viewContactButtonList));
	}
	
	public void clickEditContactButton() {
		//TODO - //a[ contains(@href, '/contacts/edit/')][0]  Select item on runtime???
		performCrudOperation(getElements(editContactButtonList));
	}
	/*
	public void clickCallContactButton() {
		showFiltersButton.click();
	}
	*/
	
	public void clickDeleteContactButton() {
		performCrudOperation(getElements(deleteContactButtonList));
		getElement(deleteYesButton).click();
	}
	
	public void performCrudOperation(List<WebElement> crudButtonList) {
		int contactIndex = HelperUtil.getUserInput(getElements(contactList).size()) - 1;
		crudButtonList.get(contactIndex).click();
	}
	
	
	public void setAction(String action) {
		//HelperUtil.setDropdownValue(driver, getElement(action), getElements(actionsList), "Delete");
	}
	
	public void clickCheckButton() {
		getElement(checkButton).click();
	}
	
}
