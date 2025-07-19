package ParentOfAllProject.SeleniumFrameworkDesign.PageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitialzeDriver 
{
/* We have to create a global property that will store the name of Web Browser in which we want to run the entire Tests.
 *  To store this, There is a class in Java called "Properties". This class can read the global properties. and decide on runtime
 * on which web browser your entire framework has to execute test cases.
 * 
 * We will create a new file with .properties extension. (Go to new--> File --> GlobalData.properties (enter file name)--> finish
 */
	WebDriver driver;
	LandingPage lp;
	
	public WebDriver initialiseDriver() throws IOException
	{	//create properties class that will parse each key value pair from .properties file
		
		Properties prop = new Properties();
		//now load is the method that will load the file. Load method takes an argument of "InputStream" type
		//So first convert your file into "InputStream" type and then call the load method of Properties class
//		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//ReusableComponent//GlobalData.properties");
		
//		FileInputStream file = new FileInputStream(System.getProperty("//SeleniumFrameworkDesign//src//main//java//ReusableComponent//GlobalData.properties"));
//		// Above is the path of the "GlobalData" file. right click on GlobalData.properties --> go to properties-->Copy the path
	//	prop.load(file);
//		
	//	String browserName = prop.getProperty("Browser");
		
		String browserName ="Chrome";
		
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			 WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
			
		}
		
		if(browserName.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
			
		}
		
		if(browserName.equalsIgnoreCase("Edge"))
		{
			 WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
			 
		}
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
		
	}
	
	@BeforeMethod
	public void launchApplication() throws IOException
	{
		driver = initialiseDriver();
		 lp = new LandingPage(driver);
		 lp.goTo();
		//this is correct username and password
		// lp.loginApplication("vik1@gmail.com", "Vikram@123");
		 
		 //Testing Incorrect username and password
		lp.loginApplication("vik1@gmail.com", "Vikram@123");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
