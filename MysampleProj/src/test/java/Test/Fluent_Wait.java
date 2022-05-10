package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fluent_Wait {
	
	static WebDriver driver;
	
	public static void main(String args[]) {
		
		fluentWait();
	}
	
	public static void fluentWait() {
		
	   try {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.get("https://google.com");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("akshata mandre");
			driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
			
			
			 // for its presence once every 5 seconds.
			   
			 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				       .withTimeout(Duration.ofSeconds(30))
				       .pollingEvery(Duration.ofSeconds(5))
				       .ignoring(NoSuchElementException.class);

				   WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
				     public WebElement apply(WebDriver driver) {

			       WebElement linkElement= driver.findElement(By.xpath("//a[@href='https://in.linkedin.com/in/akshata-mandre-32abb1127']"));
			       if(linkElement.isEnabled()) {
			    	   System.out.println("Element is enabled");
			    	   
			       }
			       return linkElement;
			     }
			   });

			ele.click();
			driver.close();
			System.out.println("success");
		} 
	   catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
