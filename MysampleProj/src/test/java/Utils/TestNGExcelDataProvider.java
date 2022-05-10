package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGExcelDataProvider {
	
	static WebDriver driver= null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeSuite
	public void reportSetUp()
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReports/TestNGExtentReport.html");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("TestNG Read Excel data","This test validates Read Excel data");
		
	}
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="testdata")
	public void test1(String username,String password) throws InterruptedException
	{
		System.out.println(username + "|" + password);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		test.log(Status.INFO, "Launched Orange HRM Login Page");
		test.pass("Navigated to Orange HRM Login Page");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		test.pass("Entered username ");
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		test.pass("Entered password ");
		driver.findElement(By.id("btnLogin")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		
		
	}

	
	@DataProvider(name ="testdata")
	public Object[][] getData()
	{
		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath  +"/Excel/data.xlsx";
		
		Object data[][] =testData(excelPath,"Sheet1");
		return data;
	}
	
	public Object[][] testData(String excelPath,String sheetName) 
	{
		
		ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		Object data[][] = new Object[rowCount-1][colCount];
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				
				/* if datatype in cols is different use this
				 * Object cellData= excel.getCellValue(i, j);
				 */
				String cellData = excel.getCellString(i, j);
				//System.out.println(cellData + "|");
				data[i-1][j]=cellData;
				
			}
		}
		return data;
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		test.log(Status.INFO,"Browser quit Sucessfully");
		extent.flush();
	}
}
