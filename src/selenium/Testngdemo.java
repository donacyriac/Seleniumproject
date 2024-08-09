package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testngdemo {
	ChromeDriver driver;

	@BeforeTest
	public void setup()
	{
		
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void url()
	{
		driver.get("https://www.linkedin.com/checkpoint/rm/sign-in-another-account");
		
	}
	@Test
	public void test1()
	{
		String act=driver.getTitle();
		String exp="linkdinnn";
		Assert.assertEquals(act, exp);
	
//		if(exp.equals(act))
//		{
//			System.out.println("passed");
//		}
//		else
//			System.out.println("failed");
	}
	
	@Test
	public void test2()
	{
		List<WebElement> link=driver.findElements(By.tagName("a"));
		for(WebElement linkss:link)
		{
			System.out.println(linkss);
		}
		
	}
	
	@AfterMethod
	public void after()
	{
		System.out.println("ended");
	}
}
