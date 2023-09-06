package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_Login(String email,String pwd,String exp_res) 
	{
		logger.info("Starting TC_003_LoginDataDrivenTest.....");
		//System.out.println("helloo1111");
	
		try {
		//HomePAge
			
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		System.out.println(exp_res);
		if(exp_res.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
				{
					Assert.assertTrue(false);
				}
		}
		if(exp_res.equalsIgnoreCase("Invalid")) 
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
				{
					Assert.assertTrue(true);
				}
		}
		}
		catch(Exception e) {
			//System.out.println("helloo");
			System.out.println("Exception- "+e);
			Assert.fail();
		}
		
		logger.info("Finished TC_003_LoginDataDrivenTest.....");
	}

}
