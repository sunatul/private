package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriver {
	public static WebDriver getDriver() {
	 WebDriver driver;
   
    	 System.setProperty("webdriver.chrome.driver","chromedriver.exe");   
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         return driver;
      
    }

}
