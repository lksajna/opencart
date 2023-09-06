package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	@Test(groups= {"sanity","master"})
	public void test_Login() 
	{
		logger.info("Starting TC_002_LoginTest.....");
		try {
		//HomePAge
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		System.out.println(rb.getString("password"));
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetPage, true);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("Finished TC_002_LoginTest.....");
	}

}
