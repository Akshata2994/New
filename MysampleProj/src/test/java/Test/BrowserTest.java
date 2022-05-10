package Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
 

public class BrowserTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Akshay G A");
		
		WebElement btn = driver.findElement(By.xpath("//input[@class ='gNO89b'and @value='Google Search']"));
		System.out.println("JANDU ACCOUNT FOUND");
		
		Thread.sleep(3000);
		
		btn.click();
		
		driver.findElement(By.xpath("//a[contains(@href,'www.instagram')]")).click();
		
		
		Thread.sleep(3000);
		
	
		
		driver.quit();
		

	}

}
