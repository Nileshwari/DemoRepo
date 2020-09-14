package test.java.crm;

import org.testng.annotations.Test;

import main.java.page.crm.ContactsPage;
import main.java.page.crm.HomePage;
import main.java.page.crm.LoginPage;
import test.java.BasePageTest;

public class ContactPageTest extends BasePageTest{
	
	private LoginPage loginPage;
	private HomePage homePage;
	private ContactsPage contactsPage;
	
//		@BeforeMethod
//		public void setUp() {
//			initialization();
//			contactsPage = new ContactsPage();
//			loginPage = new LoginPage();
//			
//			homePage = loginPage.login(prop.getProperty("test.crm.username"), prop.getProperty("test.crm.password"));
//			//TestUtil.runTimeInfo("error", "login successful");
//			//testUtil.switchToFrame();
//			contactsPage = homePage.clickOnContactsLink();
//		}
	
	@Test (enabled = true) 
	public void validateCreateNewContactButton(){
		contactsPage.clickCreateNewContactButton();
	}
	
	@Test  (enabled = false)
	public void validateShowFiltersButton(){
		contactsPage.clickShowFiltersButton();
	}
	
	@Test (enabled = false)
	public void validateSelectAllContactsButton(){
		contactsPage.clickSelectAllContactsButton();
	}

	@Test  (enabled = false)
	public void validateExportButtonOnAllContacts(){
		contactsPage.clickSelectAllContactsButton();
		contactsPage.clickExportButton();
	}
	
	@Test  (enabled = false)
	public void validateDeleteContactButton(){
		System.out.println("validateDeleteContactButton: ");
		contactsPage.clickDeleteContactButton();
	}

	@Test  (enabled = false)
	public void validateEditContactButton(){
		System.out.println("validateEditContactButton: ");
		contactsPage.clickEditContactButton();
	}
	
	@Test  (enabled = false)
	public void validateViewContactButton(){
		System.out.println("validateViewContactButton: ");
		contactsPage.clickViewContactButton();
	}

}
