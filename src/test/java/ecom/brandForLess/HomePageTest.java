package test.java.ecom.brandForLess;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import main.java.listeners.CustomListener;
import main.java.page.ecom.brandForLess.HomePage;
import test.java.BasePageTest;

@Listeners(CustomListener.class)
public class HomePageTest extends BasePageTest {

	private HomePage homePage;
	Logger log = Logger.getLogger(HomePageTest.class);


	@Test(enabled=true)
	public void verifyHomePageLogoExistsTest(){
		log.info("****************************** starting test case - verifyHomePageLogoExistsTest *****************************************");
		Assert.assertTrue(homePage.verifyHomePageLogo());
	}
	
	@Test(enabled=true)
	public void verifyHomePageTitleTest(){
		log.info("****************************** starting test case - verifyHomePageTitleTest *****************************************");
		String homePageTitle = page.getInstance(HomePage.class).getHomePageTitle();
		System.out.println("homePageTitle>>"  + homePageTitle);
		Assert.assertEquals(homePageTitle, prop.get("test.ecom.title"),"Home page title not matched");
	}

	@Test(enabled=true)
	public void verifyHomePageHeaderTest(){
		log.info("****************************** starting test case - verifyHomePageHeaderTest *****************************************");
		String homePageHeader = page.getInstance(HomePage.class).getHomePageHeader();
		System.out.println("homePageHeader>>"  + homePageHeader);
		Assert.assertEquals(homePageHeader, prop.get("test.ecom.title"),"Home page title not matched");
	}
	/*
	@Test 
	public void verifyLoginTest(){
		log.info("****************************** starting test case - verifyLoginTest *****************************************");
		LoginPage loginPage = page.getInstance(LoginPage.class).doLogin("nileshwarirt@gmail.com", "Nileshwari@29");
		System.out.println("homePageHeader>>"  + homePageHeader);
		Assert.assertEquals(homePageHeader, prop.get("test.ecom.title"),"Home page title not matched");
	}
	*/
	
	@Test(enabled=false)
	public void verifyMouseOverTabTest(){
		//TODO : Tabs window is not getting closed
		homePage.moveOverHomeandLiving();		
	}
	
	@Test(enabled=false, groups="SearchFieldActions")
	public void verifySearchInputFieldTest(){

		homePage.insertDataIntoSearchInput();		
	}
	
	// TODO
	@Test(enabled=false, groups="SearchFieldActions", dependsOnMethods={"verifySearchInputFieldTest"})
	public void verifySearchHistoryFieldTest(){

		homePage.selectSearchHistoryItem();		
	}

	// TODO
	@Test(enabled=false, groups="SearchFieldActions", dependsOnMethods={"verifySearchHistoryFieldTest"})
	public void verifySearchHistoryFieldDeleteTest(){
		homePage.deleteSearchHistory();		
	}
	
	@Test(enabled=false)
	public void verifyNavigateForwardAndBackTest(){
		try {
			homePage.navigateforwardAndBack();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

	@Test(enabled=false)
	public void verifyDubbizleMouseOverTabTest(){

		homePage.moveOverPropertyForRent();		
	}
	
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
}
