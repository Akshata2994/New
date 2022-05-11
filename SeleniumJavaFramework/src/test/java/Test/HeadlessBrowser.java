package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowser {
	
	static WebDriver driver;
	
	public static void main(String args[]) throws InterruptedException
	{
		test();
	}

	public static void test() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		//options.addArguments("window-size=1920,1080");
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://google.com");
		Thread.sleep(3000);
		System.out.println("title is :"+ driver.getTitle());
		driver.quit();
	}
}
