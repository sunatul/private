package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class WebstaurantPageObject { 
	
     @Test
     public void testCase1() throws InterruptedException{
    	 WebDriver driver = SeleniumDriver.getDriver();
    	driver.get("http://webstaurantstore.com");
    	 driver.findElement(By.xpath("//*[@id='searchval']")).sendKeys("stainless work table" + Keys.ENTER);
    	 //Get list of web-elements with tagName  - a
    	 List<WebElement> allLinks = driver.findElements(By.xpath("//*[@id='product_listing']//a[@class='description']" ));
         //Traversing through the list and printing its text along with link address
    	 String text = "";
    	 int i = 0; 
         for(WebElement link:allLinks){
        	
        	
        	 text = link.getText().toLowerCase();
 
        	 Assert.assertTrue(text.contains("table"));
        	 
         }
         driver.close();
         
        
     }
     @Test
     public void testCase2() throws InterruptedException {
    	 WebDriver driver = SeleniumDriver.getDriver();
    	driver.get("http://webstaurantstore.com");
    	 driver.findElement(By.xpath("//*[@id='searchval']")).sendKeys("stainless work table" + Keys.ENTER);
    	 List<WebElement> allLinks = driver.findElements(By.xpath("//*[@id='product_listing']//a[@class='description']" ));
    	 String actualItemDescription = allLinks.get(allLinks.size()-1).getText();
    	 
    	 ////*[@id='product_listing']/div[60]//input[@name = 'addToCartButton']
    	  driver.findElement(By.xpath("//*[@id='product_listing']/div[" +allLinks.size()+"]" + "//input[@name = 'addToCartButton']")).click();
    	
    	  WebDriverWait wait = new WebDriverWait(driver,12);
    	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class = 'notification-center']")));
    	driver.findElement(By.xpath("//*[contains(@aria-label,'View your cart.')]")).click();
    	  
    	  String firstItemInCartDescription = driver.findElement(By.xpath("//div[@class='cartItems']//a[contains(text(),'Table')]")).getText();
    	  Assert.assertEquals(actualItemDescription.trim(),firstItemInCartDescription.trim());
    	driver.findElement(By.xpath("//*[@class='emptyCartButton btn btn-mini btn-ui pull-right']")).click();
    	 WebElement emptyCartButton = driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(),'Empty Cart')]"));
    	 emptyCartButton.click();
   	 WebElement closeButton = driver.findElement(By.xpath("//*[@class='btn btn-light']"));
	 closeButton.click();
    	 String finalWord=driver.findElement(By.xpath("//*[@class='header-1']")).getText().trim();
    	 String expectedFinalWord="Your cart is empty.";
    	 Assert.assertEquals(finalWord, expectedFinalWord);
    	
    	  driver.close();
     }
   
     
}

