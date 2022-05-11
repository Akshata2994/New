package Test;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGDemo {

	static WebDriver driver = null;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
	}
	
	@Test
	public static void googleSearchTest() throws InterruptedException
	{
		
        GoogleSearchPage obj = new GoogleSearchPage(driver);
		obj.setTextInSearchBar("Automation Step By Step");
		obj.ClickSearch();
		Thread.sleep(3000);
		System.out.println("Succesful");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
