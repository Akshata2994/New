package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITFileUpload {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println(" before click");
		//commenting this since its not working manually clicking button
		//driver.findElement(By.xpath("input[@name='upfile']")).click();
		System.out.println("clicked");
		Runtime.getRuntime().exec("C:\\Users\\aksha\\Desktop\\Python_Notes\\PythonFiles\\Files for AutoIT\\FileUploadScript.exe");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Press']")).click();
		Thread.sleep(6000);
		driver.close();
		System.out.println("Success");
		
		

	}

}
