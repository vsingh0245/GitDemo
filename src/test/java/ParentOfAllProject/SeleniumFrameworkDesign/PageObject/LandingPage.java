package ParentOfAllProject.SeleniumFrameworkDesign.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableComponent.ReusableComponent;

public class LandingPage extends ReusableComponent {
	
		WebDriver driver;
		public LandingPage(WebDriver driver)
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
	
		
		// WebElement userName= driver.findElement(By.id("userEmail"));
		// OR
		@FindBy(id="userEmail")
		WebElement userName;
		
		
		// WebElement password = driver.findElement(By.id("userPassword"));
		// OR
		@FindBy(id="userPassword")
		WebElement password;
		
		//WebElement submit =driver.findElement(By.id("login"));
		// OR
		
		@FindBy(id="login")
		WebElement submit; 
		
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMsg;
		
		public void goTo()
		{
			
			 driver.get("https://rahulshettyacademy.com/client/");
			 
		}
		
		public String getErrorMessage() throws InterruptedException
		{
			waitForWebElementToAppear(errorMsg);
			//Thread.sleep(1500); 
			return errorMsg.getText();
		}
		//This is to login the application
		public void loginApplication(String email, String password) 
		{
			
			userName.sendKeys(email);
			this.password.sendKeys(password);
			submit.click();
		}
		
}
