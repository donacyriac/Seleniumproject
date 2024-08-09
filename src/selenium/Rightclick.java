package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Rightclick {
	ChromeDriver driver;

	@BeforeTest
	public void setup()
	{	driver=new ChromeDriver();

	}

	
	@BeforeMethod
	public void url()
	{
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
	}
	
	@Test
	public void test()
	{	WebElement rightclick=driver.findElement(By.xpath("//*[@class=\"context-menu-one btn btn-neutral\"]"));
		WebElement edit=driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[1]"));
		Actions act=new Actions(driver);
		act.contextClick(rightclick);
		act.perform();
		act.click(edit);
		act.perform();
		driver.switchTo().alert().accept();
		WebElement doubleclick=driver.findElement(By.xpath("//button"));
		act.doubleClick(doubleclick);
		act.perform();
		driver.switchTo().alert().accept();

	}
	
}
