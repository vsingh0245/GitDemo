package ParentOfAllProject.SeleniumFrameworkDesign.PageObject;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

public class ErrorValidation extends InitialzeDriver {
		 
	@Test
	public void ErrorOnSubmit() throws InterruptedException, IOException
	{
			
		 String productName="ZARA COAT 3";
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMessage());
		System.out.println(lp.getErrorMessage());
		 
	}

}