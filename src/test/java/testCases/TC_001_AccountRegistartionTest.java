package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistartionTest extends BaseClass {

	
	
	@Test(groups= {"regression","master"})
	public void test_accountRegistration() 
	{
		
		logger.info("****TC_001_AccountRegistartionTest Starting****");
		HomePage hp=new HomePage(driver);
		logger.info("Clicking on MyAccount");
		hp.clickMyAccount();
		
		logger.info("Clicking on Register Link");
		hp.clickRegister();
		
		logger.info("Providing Customer Details");
		AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		/*
		regpage.setFirstName("abc");
		regpage.setLastName("xyz");
		regpage.setEmail("123@gh.com");;
		regpage.setTelephone("11222334455");
		regpage.setPassword("123456");
		regpage.setConfirmPassword("123456");
		regpage.setPrivacyPolicy();
		regpage.setContinueBtn();
		String confirmmsg = regpage.getConfirmMsg();
		Assert.assertEquals(confirmmsg, "Your Account Has Been Created!");
		*/
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomAlphaNumeric()+"@sad.com");
		regpage.setTelephone(randomNumeric());
		
		String password= randomNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.setContinueBtn();
		String confirmmsg = regpage.getConfirmMsg();
		if(confirmmsg.equals("Your Account Has Been Created!!!!")) 
		{
			Assert.assertTrue(true);
			logger.info("Registration Successful......");
		}
		else
		{
			logger.error("Registartion failed");
			//System.out.println("Exception- "+e);
			Assert.fail();
		}
		
		logger.info("****TC_001_AccountRegistartionTest Finished****");
		
	}	
	
	
}
