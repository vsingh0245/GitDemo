package ParentOfAllProject.SeleniumFrameworkDesign.PageObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ParentOfAllProject.SeleniumFrameworkDesign.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		 
		 LandingPage lp = new LandingPage(driver);
		 
		 driver.get("https://rahulshettyacademy.com/client/");
		 driver.manage().window().maximize();
		 driver.findElement(By.id("userEmail")).sendKeys("vik1@gmail.com");
		 driver.findElement(By.id("userPassword")).sendKeys("Vikram@123");
		 driver.findElement(By.id("login")).click();
		 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		 List<WebElement> product = driver.findElements(By.cssSelector(".mb-3"));
		 
		 WebElement prod= product.stream().filter(s-> 
		 s.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		 
		 prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		 
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		 wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		 driver.findElement(By.cssSelector(".fa.fa-shopping-cart")).click();	
		 Thread.sleep(1000);
		
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(".totalRow button")));
		 
		 driver.findElement(By.cssSelector(".totalRow button")).click();
		
		 driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).sendKeys("Ind");
		 List<WebElement> country = driver.findElements(By.cssSelector(".ta-item.list-group-item.ng-star-inserted"));
		 
		 	for(WebElement w:country)
		 	{
		 		if(w.getText().equalsIgnoreCase("India"))
		 		{
		 			w.click();
		 			break;
		 		}
		 	}
		 
		 //country.stream().filter(s->s.getText().equalsIgnoreCase("India"))
		 
		 
		 
	}

}