package test.java.crm;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import main.java.listeners.CustomListener;
import main.java.page.crm.HomePage;
import main.java.page.crm.LoginPage;
import test.java.BasePageTest;

public class LoginPageTest extends BasePageTest {
	
	private LoginPage loginPage;
	private Logger log = Logger.getLogger(LoginPageTest.class);

	/*@Test(priority=1)
	public void verifyLoginPageHeaderTest(){
		String title = page.getInstance(LoginPage.class).getLoginPageHeader();
		Assert.assertEquals(title, prop.getProperty("test.crm.title"));
	}*/
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		log.info("****************************** starting test case - verifyLoginPageTitleTest *****************************************");
		String loginPageTitle = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println("loginPageTitle >>"  + loginPageTitle );
	//Brands For Less | Buy Best Branded Products Online! Best Prices in UAE
		Assert.assertEquals(loginPageTitle , prop.get("test.crm.title"),"Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyLoginTest(){
		log.info("****************************** starting test case - verifyLoginTest *****************************************");
		HomePage homePage = page.getInstance(LoginPage.class).doLogin("nileshwarirt@gmail.com", "Nileshwari@29");
		//System.out.println("homePage >>"  + homePage );
		Assert.assertEquals(homePage.getHomePageTitle(), prop.get("test.ecom.homepage.title"),"Home page title not matched");
	}
		
//	@Test(priority=2)
//	public void crmLogoImageTest(){
//		boolean flag = loginPage.validateCRMImage();
//		Assert.assertTrue(flag);
//	}
	
}
