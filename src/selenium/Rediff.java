package selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rediff {
	ChromeDriver driver;
	
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}
	
	@Test
	public void test()
	{
		WebElement button=driver.findElement(By.xpath("//*[@value=\"Check availability\"]"));
		String act=button.getAttribute("value");
		System.out.println(act);
		String exp="Check availability";
		if(exp.equals(act))
		{
			System.out.println("passed");
		}
		else
			System.out.println();
		
	}
}
