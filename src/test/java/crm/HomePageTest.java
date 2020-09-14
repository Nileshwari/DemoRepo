package test.java.crm;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import main.java.page.crm.CalendarPage;
import main.java.page.crm.ContactsPage;
import main.java.page.crm.HomePage;
import main.java.page.crm.LoginPage;
import test.java.BasePageTest;

public class HomePageTest extends BasePageTest {
	
	private LoginPage loginPage;
	private HomePage homePage;
	private ContactsPage contactsPage;
	private CalendarPage calendarPage;
	Logger log = Logger.getLogger(HomePageTest.class);

	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.getHomePageTitle();
		Assert.assertEquals(homePageTitle, prop.get("test.crm.title"),"Home page title not matched");
	}
	
	
	/*
	@Test(priority=2)
	public void verifyUserNameTest(){
		//switchToFrame();
		 Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	*/
	
	/*
	@Test 
	public void verifyLoginTest(){
		log.info("****************************** starting test case - verifyLoginTest *****************************************");
		LoginPage loginPage = page.getInstance(LoginPage.class).doLogin("nileshwarirt@gmail.com", "Nileshwari@29");
		System.out.println("homePageHeader>>"  + homePageHeader);
		Assert.assertEquals(homePageHeader, prop.get("test.ecom.title"),"Home page title not matched");
	}
	*/
	
	
	@Test(priority=3) 
	public void verifyContactsLinkTest(){
		//switchToFrame();
		log.info("****************************** starting test case - verifyContactsLinkTest *****************************************");
		homePage.clickOnContactsLink();
		ContactsPage contactsPage = page.getInstance(ContactsPage.class);
		//System.out.println("contactsPage>>"  + contactsPage);
		Assert.assertEquals(contactsPage.getPageTitle(), prop.get("test.ecom.contacts"),"Home page title not matched");
		
	}
		
	
	@Test(priority=4) 
	public void verifyCalendarLinkTest(){
		homePage.clickOnCalendarLink();
		page.getInstance(CalendarPage.class);
	}
	
	@Test(priority=3) 
	public void verifyDeleteButtonTest(){
		assertTrue(homePage.verifyDeleteButton());
	}	
	
	
	
}
