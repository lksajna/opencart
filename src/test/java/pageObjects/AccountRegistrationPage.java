package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement txtFirstNme;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement txtLastNme;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@placeholder='Password Confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement ConfirmMsg;
	
	public void setFirstName(String fname) 
	{
		txtFirstNme.sendKeys(fname);
	}
	
	public void setLastName(String lname) 
	{
		txtLastNme.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tphone)
	{
		txtTelephone.sendKeys(tphone);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String confirmpwd)
	{
		txtConfirmPassword.sendKeys(confirmpwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkPolicy.click();
	}
	
	public void setContinueBtn()
	{
		btnContinue.click();
	}
	
	public String getConfirmMsg() 
	{
		return ConfirmMsg.getText();
		
	}
	
	
	
	
	
}
