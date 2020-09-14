package main.java.page.crm;

import java.util.List;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.base.BasePage;
import main.java.util.HelperUtil;

public class NewContactPage extends BasePage{
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	private WebElement newButton;
	
	@FindBy(name="first_name")
	private WebElement firstName;
	
	@FindBy(name="last_name")
	private WebElement lastName;
	
//	@FindBy(placeholder="Email address")
//	WebElement emailId;
//	

	@FindBy(xpath = "//input[@placeholder= 'Email address']")
	private WebElement email;

	@FindBy(xpath = "//div[@name= 'category']/div[@aria-atomic='true']")
	private WebElement categoryDropdown;
	
	@FindBy(xpath = "//div[@name= 'category']/div[2]/div[@role= 'option']")
	private List<WebElement> categoryList;

	@FindBy(xpath = "//div[@name= 'status']/div[@aria-atomic='true']")
	private WebElement statusDropdown;
	
	@FindBy(xpath = "//div[@name= 'status']/div/div[@role= 'option']")
	private List<WebElement> statusList;
	
	@FindBy(name = "address")
	private WebElement address;
	
	@FindBy(name="city")
	private WebElement city;
		
	@FindBy(xpath = "//input[@name='zip']")
	private WebElement zipCode;
	
	@FindBy(xpath="//div[@name= 'country']")
	private WebElement countryDropdown;
		
	@FindBy(xpath="//div[@name= 'country']/div[2 and @role='listbox']/div[@role= 'option']")
	private List<WebElement> countryDropdownList;
	
	@FindBy(xpath="//div[@name= 'hint']")
	private WebElement phoneCountryDropdown;

	@FindBy(xpath="//div[@name= 'hint']/div[@role='listbox']/div[@role= 'option']")
	private List<WebElement> phoneCountryDropdownList;

	@FindBy(xpath="//input[@placeholder= 'Number']")
	private WebElement phoneNumber;
	
	@FindBy(xpath="//input[@name='position']")
	private WebElement position;
	
	@FindBy(xpath="//div[@name= 'source']/div/div[@role= 'option']")
	private List<WebElement> sourceList;

	@FindBy(xpath="//div[@name= 'source']")
	private WebElement source;
	
	@FindBy(xpath = "//input[@name='do_not_call']")
	private WebElement doNotCallButton;
	
	@FindBy(xpath = "//input[@name='do_not_text']")
	private WebElement doNotTextButton;
	
	@FindBy(xpath = "//input[@name='do_not_email']")
	private WebElement doNotEmailButton;

	@FindBy(xpath = "//input[@name= 'day']")
	private WebElement dateOfBirth;
	
	@FindBy(xpath = "//div[@name= 'month']")
	private WebElement monthOfBirth;
	
	@FindBy(xpath = "//div[@name= 'month']/div/div[@role= 'option']")
	private List<WebElement> monthOfBirthList;

	@FindBy(xpath = "//input[@name= 'year']")
	private  WebElement yearOfBirth;
		
	//input[@name= "image"]
	
	@FindBy(xpath = "//i[@class= 'save icon']")
	private WebElement saveBtn;
	
	
	// Initializing the Page Objects:
	public NewContactPage(WebDriver driver) {
		super(driver);
	}
			
//	List<WebElement> myList = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='ui-menu-item'][starts-with(@id,'ui-id-')]//span[@class='autoCompleteItem__label']")));
//	for (WebElement element:myList)
//	    if(element.getText().contains("Mumbai"));
//	        element.click();

	        
	public void addNewContacts(String firstName, String lastName, 
			String emailId, String category, String status,
			String address, String city, String zipcode, String country,
			String phoneNumber, String position, String source,
			String doNotCallFlag, String doNotTextFlag, String doNotmailFlag, String dob) {
		
		System.out.println("in,,,,,,,,,,,,addNewContacts");
		//Select select = new Select(driver.findElement(By.name("title")));
		//select.selectByVisibleText(title);
		WebDriverWait wait = new WebDriverWait(driver, 20);
System.out.println("1,,,,,,,,,,,,"  + this.firstName.isDisplayed());

		if(!this.firstName.isDisplayed()) {
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOf(this.firstName));
		}
System.out.println("2,,,,,,,,,,,,"  + this.firstName.isDisplayed());
		

 		this.firstName.sendKeys(firstName);
 		this.lastName.sendKeys(lastName);
		this.email.sendKeys(emailId);

		HelperUtil.setDropdownValue(driver, this.categoryDropdown, this.categoryList, category);
		HelperUtil.setDropdownValue(driver, this.statusDropdown, this.statusList, status);
		
		HelperUtil.scrollPageUp(driver);
		
		this.address.sendKeys(address);
		this.city.sendKeys(city);
		this.zipCode.sendKeys(zipcode);
		HelperUtil.setDropdownValue(driver, this.countryDropdown, this.countryDropdownList, country);
		
		HelperUtil.setDropdownValue(driver, this.phoneCountryDropdown, this.phoneCountryDropdownList, country);
		this.phoneNumber.sendKeys(phoneNumber);
		
		setToggleButton(doNotCallButton, Boolean.parseBoolean(doNotCallFlag));
		setToggleButton(doNotTextButton, Boolean.parseBoolean(doNotTextFlag));
		setToggleButton(doNotEmailButton, Boolean.parseBoolean(doNotmailFlag));

		this.position.sendKeys(position);
		
		setDateOfBirth(dob);
		
		//saveBtn.click();
		System.out.println("saveBtn,,,,,,,,,,,"  +saveBtn.isDisplayed());
	
		HelperUtil.clickByJS(saveBtn, driver);
		
	}

	private void setToggleButton(WebElement toggleButton, boolean doNotCallFlag) {
		System.out.println("doNotCallButton.isDisplayed>>" + toggleButton.isDisplayed());
		if( (doNotCallFlag && !toggleButton.isDisplayed()) || (!doNotCallFlag && toggleButton.isDisplayed()) ){
			HelperUtil.clickByJS(toggleButton, driver);
		}
	}

	

	private void setDateOfBirth(String dob) {
	// 12/06/1981
	String[] dobArray = dob.split("/");
	
		if(dobArray.length == 3) {
			dateOfBirth.sendKeys(dobArray[0]);
	
			HelperUtil.setDropdownValue(driver, monthOfBirth, monthOfBirthList, HelperUtil.months[ Integer.parseInt(dobArray[1]) ] );
		
			yearOfBirth.sendKeys(dobArray[2]);
		}
	}

	
	
}
