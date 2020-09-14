package test.java.crm;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.page.crm.ContactsPage;
import main.java.page.crm.HomePage;
import main.java.page.crm.LoginPage;
import main.java.page.crm.NewContactPage;
import main.java.util.HelperUtil;
import test.java.BasePageTest;

public class NewContactPageTest extends BasePageTest {
	
	private LoginPage loginPage;
	private HomePage homePage;
	private ContactsPage contactsPage;
	private NewContactPage newContactPage;
	
//	@BeforeMethod
//	public void setUp() {
//		initialization();
//		newContactPage = new NewContactPage();
//		contactsPage = new ContactsPage();
//		loginPage = new LoginPage();
//
//		homePage = loginPage.login(prop.getProperty("test.crm.username"), prop.getProperty("test.crm.password"));
//		contactsPage = homePage.clickOnContactsLink();
//		newContactPage = contactsPage.clickCreateNewContactButton();		
//		System.out.println("------------" + driver.getCurrentUrl());
//		
//		//driver.navigate().refresh();
//	}
	
	@DataProvider(name = "ContactListProvider")
	public Iterator<Object[]> getNewContactList(){
//		System.out.println("<><> getNewContactList()" + newContactPage);  //null
		ArrayList<Object[]> newContactList = HelperUtil.getNewContactsList();
		return newContactList.iterator();
	}
	
	@Test(dataProvider = "ContactListProvider")
	public void validateCreateNewContact(String firstName, String lastName, 
			String emailId, String category, String status,
			String address, String city, String zipcode, String country,
			String phoneNumber, String position, String source,
			String doNotCallFlag, String doNotTextFlag, String doNotEmailFlag, String dob) {

		System.out.println("<>" + firstName + "<><>" + lastName);
		newContactPage.addNewContacts(firstName, lastName, 
				emailId, category, status,
				address, city, zipcode, country, 
				phoneNumber, position, source, 
				doNotCallFlag, doNotTextFlag, doNotEmailFlag, dob); 
	}
	
//	@Test 
//	public void testMe(){
//	Assert.assertTrue(true);	
//	}

	
	
}
