package ReusableComponent;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponent {

	WebDriver driver;
	
	 
	public ReusableComponent(WebDriver driver) 
	{
		this.driver = driver;
		
	}
	public void waitForElementToAppear(By findBy)
	{
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitForElementToDisappear(WebElement element) throws InterruptedException
	{
		Thread.sleep(2000);
	//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		// wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void waitForWebElementToAppear(WebElement element)
	{
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void goToCartPage()
	{
		driver.findElement(By.cssSelector(".fa.fa-shopping-cart")).click();

	}
	public void goToCheckOut() throws InterruptedException
	{
//		Thread.sleep(1500);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(".totalRow button")));
//	 	
		Thread.sleep(1000);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);");
		driver.findElement(By.cssSelector(".totalRow button")).click();
	}
	
}
