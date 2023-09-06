package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;  // Log4j
import org.apache.logging.log4j.Logger;   // Log4j


public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	//To use config.properties file - Approach1
	public ResourceBundle rb;//to read config files
	@Parameters({"browser"})
	@BeforeClass(groups= {"sanity","regression","master"})
	public void setUp(String br) throws IOException 
	{
		//To use config.properties file - Approach1
		rb=ResourceBundle.getBundle("config");//to load config.properties
		
		//To use config.properties file - Approach2
		//FileReader file = new FileReader(".\\Users\\sajna_home\\workspace\\opencart\\src\\test\\resources\\config.properties");//./opencart/src/test/resources/config.properties");//""Users\sajna_home\workspace\opencart\src\test\resources\config.properties");
		//Properties p = new Properties();
		//p.load(file);
		logger= LogManager.getLogger(this.getClass());
		if(br.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		driver.manage().deleteAllCookies();//Deletes all cookies from browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//To use config.properties file - Approach1
		driver.get(rb.getString("appURL"));
		
		//String url=p.getProperty("appURL");
		//driver.get(url);
	}

	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown() 
	{
		driver.quit();
	}
	
	public String randomString() 
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomAlphaNumeric() 
	{
		String generatedString=RandomStringUtils.randomAlphanumeric(6);
		return generatedString;
	}
	public String randomNumeric() 
	{
		String generatedString=RandomStringUtils.randomNumeric(8);
		return generatedString;
	}
	public String captureScreen(String tname)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String destination=System.getProperty("user.dir")+"/screenshots/"+tname+"_"+timeStamp+".png";
		try {
			FileUtils.copyFile(source,new File(destination));
		}catch(Exception e) 
		{
			e.getMessage();
		}
		return destination;
}
}
