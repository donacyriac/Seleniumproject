package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testngprogram {
	ChromeDriver driver;

	@BeforeTest
	public void setup()
	{
		
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void url()
	{
//		driver.get("https://www.linkedin.com/checkpoint/rm/sign-in-another-account");
		
	}
	@Test (invocationCount = 2,groups = "smoke")
	public void test1()
	{System.out.println("testy1");
	}
	
	@Test (invocationCount = 3)
	public void test2()
	{
		System.out.println("test2");
		
	}
	@Test (groups = "smoke")
	public void test3()
	{
		System.out.println("dvdvf");
		
	}
	@Test
	public void test4()
	{
		System.out.println("dvdvf");
		
	}
	
	@AfterMethod
	public void after()
	{

	}
}
