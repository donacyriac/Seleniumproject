package selenium;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Copypaste {
	ChromeDriver driver;

	@BeforeTest
	public void setup()
	{	driver=new ChromeDriver();

	}

	
	@BeforeMethod
	public void url()
	{
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void test()
	{
		WebElement email  =driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement pass=driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		email.sendKeys("dona@123");
		Actions act=new Actions(driver);
		act.keyDown(email,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		act.keyDown(email,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		act.keyDown(pass,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
		act.perform();
		
		
	}
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
}
