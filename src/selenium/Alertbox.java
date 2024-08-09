package selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Alertbox {
	EdgeDriver driver;
	int count;
	@Before
	public void setup()
	{
		driver=new EdgeDriver();
		driver.get("file:///C:/Users/HP/OneDrive/Desktop/IntroToUnitTesting/alert.html");
	}
	@Test
	public void test()
	{   
		driver.findElement(By.xpath("//*[@value=\"Display alert box\"]")).click();
		Alert s =driver.switchTo().alert();
		s.accept();
		driver.findElement(By.xpath("//*[@name=\"firstname\"]")).sendKeys("abc");
		driver.findElement(By.xpath("//*[@name=\"lastname\"]")).sendKeys("xyz");
		driver.findElement(By.xpath("//*[@value=\"Submit\"]")).click();
		
		WebElement button=driver.findElement(By.xpath("//*[@value=\"Display alert box\"]"));
		String act=button.getAttribute("value");
		System.out.println(act);
		String exp="Display alert box";
		if(exp.equals(act))
		{
			System.out.println("passed");
		}
		else
			System.out.println("failed");
		
	}

	@After
	public void after()
	{
	}
}
