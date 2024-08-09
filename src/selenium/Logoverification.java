package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Logoverification {

	
	ChromeDriver driver;
	@BeforeTest
	public void setup()
	{	driver=new ChromeDriver();

	}

	
	@BeforeMethod
	public void url()
	{
		driver.get("https://www.google.co.in/");
	}
	
	@Test
	public void test()
	{
		WebElement logo=driver.findElement(By.xpath("//img"));
        if(logo.isDisplayed()==true) {
        	System.out.println("passed");
        }
        	else
        		
        		System.out.println("failed");
        

	}
}
