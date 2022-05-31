package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
	
	WebDriver driver =null;
	
	By search_textbox = By.xpath("//input[@name='q']");
	
	By search_button = By.xpath("//input[@class='gNO89b' and @xpath='1']");
	
	public GoogleSearchPage(WebDriver driver)
	{
		//this points to current driver
		this.driver = driver;
	}
	
	
	public void setTextInSearchBar(String text)
	{
		
		driver.findElement(search_textbox).sendKeys(text);
	}

	
	public void ClickSearch()
	{
		
		driver.findElement(search_textbox).sendKeys(Keys.RETURN);
	}
	
	
}
