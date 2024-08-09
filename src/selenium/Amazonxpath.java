package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazonxpath {

	ChromeDriver driver;
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
	}
	
	@Test
	public void test()
	{   driver.findElement(By.xpath("//*[@name='field-keywords']")).sendKeys("mobiles",Keys.ENTER);
		driver.findElement(By.id("nav-cart-count")).click();
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();
		driver.findElement(By.name("email")).sendKeys("dona");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(By.id("nav-hamburger-menu")).click();

		}
	@After
	public void after()
	{
		driver.close();
	}
	
	
}
