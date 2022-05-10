package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGExtentReports {
	
	WebDriver driver = null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}

	@BeforeSuite
	public void reportSetUp()
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReports/TestNGExtentReport.html");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("TestNG Google Serach","This test validates google search");
		
	}
	
	@Test
	public void googleSearch() throws InterruptedException, IOException
	{
		
		driver.get("https://google.com");
		test.log(Status.INFO, "Launched Google Home Page");
		test.pass("Navigated to Google Home Page");
		/*test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");*/
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation Step By Step");
		test.pass("Entered Text in Search Box");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.RETURN);
		test.pass("Pressed the Search button");
		
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		test.log(Status.INFO,"Browser quit Sucessfully");
		extent.flush();
	}
	
	
}
