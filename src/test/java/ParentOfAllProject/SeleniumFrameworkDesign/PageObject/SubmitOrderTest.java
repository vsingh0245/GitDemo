package ParentOfAllProject.SeleniumFrameworkDesign.PageObject;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ReusableComponent.ReusableComponent;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubmitOrderTest extends InitialzeDriver {
		 
	@Test
	public void submitOrder() throws InterruptedException, IOException
	{
		  
		 String productName="ZARA COAT 3";
		 
		// launchApplication();
		 ProductCatalog productCatalog = new ProductCatalog(driver);
		// List<WebElement> products= productCatalog.getProductList();
		 productCatalog.addProductToCart(productName);
		 
		 ReusableComponent reusableComponent = new ReusableComponent(driver);
		 reusableComponent.goToCartPage();
		 
		reusableComponent.goToCheckOut();
		
		
		 driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).sendKeys("Ind");
		 List<WebElement> country = driver.findElements(By.cssSelector(".ta-item.list-group-item.ng-star-inserted"));
		 
		 
		 country.stream().filter(s->s.getText().equalsIgnoreCase("India")).findAny().get().click();
		 
		 
		 
	}

}