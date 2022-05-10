package Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(Listeners.TestNGListeners.class)
public class TestNGListenersDemo {
	
	@Test
	public void Test1()
	{
		System.out.println("Inside Test1");
	}
	
	@Test
	public void Test2()
	{
		System.out.println("Inside Test2");
		
       WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Akshata");
		
		//invalid xpath so that we can see on test failed
		driver.findElement(By.xpath("//input[@name='xx']")).sendKeys("Akshata");
		
		driver.close();
		
	}

	@Test
	public void Test3()
	{
		System.out.println("Inside Test 3");
	}
}
