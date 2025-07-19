package ParentOfAllProject.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
		WebDriver driver;
		public LandingPage(WebDriver driver)
		{
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
		
		public void loginApplication() {
			
		}
		
}
