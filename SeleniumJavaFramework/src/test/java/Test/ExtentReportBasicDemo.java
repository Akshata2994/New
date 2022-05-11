package Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportBasicDemo {
	

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		
		ExtentHtmlReporter htmlReporter  = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReports/ExtentReportResults.html");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test = extent.createTest("Google Search","Validate Search");
		
		WebDriverManager.chromedriver().setup();
		
	    WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		test.log(Status.INFO, "Launched Google Home Page");
		test.pass("Navigated to Google Home Page");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation Step By Step");
		test.pass("Entered Text in Search Box");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.RETURN);
		test.pass("Pressed the Search button");
		
		Thread.sleep(3000);
		driver.quit();
		test.pass("Closed the browser");
		System.out.println("success");
		test.info("Successful");
		
		extent.flush();
		
		
		
	}

}
