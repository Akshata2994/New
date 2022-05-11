package Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import Pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

	static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		googleSearchTest();

	}
	
	public static void googleSearchTest() throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		GoogleSearchPage obj = new GoogleSearchPage(driver);
		obj.setTextInSearchBar("Automation Step By Step");
		obj.ClickSearch();
		Thread.sleep(3000);
		driver.quit();
		System.out.println("success");
		
		
	}

}
