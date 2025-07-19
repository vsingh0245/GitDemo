package ParentOfAllProject.SeleniumFrameworkDesign.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;

import ReusableComponent.ReusableComponent;

public class ProductCatalog extends ReusableComponent {
	
		WebDriver driver;
		public ProductCatalog(WebDriver driver)
		{	
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
		
		
		// List<WebElement> product = driver.findElements(By.cssSelector(".mb-3"));
		// OR
		@FindBy(css=".mb-3")
		List<WebElement> products;
		
		@FindBy(css=".ng-animating")
		WebElement disappear;
		
		By productBy = By.cssSelector(".mb-3");
		By addToCart = By.cssSelector(".card-body button:last-of-type");
		By toastMessage=By.cssSelector("#toast-container");
		
		public List<WebElement> getProductList()
		{
			waitForElementToAppear(productBy);   //we can not send products because we have to send only (By.cssSelector(".mb-3")).
			return products;					// That is why we need to create a new variable productBy of 'By' type
		
		}
		
		public WebElement getProductByName(String productName)
		{
			WebElement prod= getProductList().stream().filter(s-> 
			 s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			
			return prod;
		}
		
		public void addProductToCart(String productName) throws InterruptedException
		{
			WebElement prod = getProductByName(productName);
			 prod.findElement(addToCart).click();
			 waitForElementToAppear(toastMessage);
			 waitForElementToDisappear(disappear);
		}
		
		
	
}
