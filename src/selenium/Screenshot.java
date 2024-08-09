package selenium;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	ChromeDriver driver;
	
	@Before
	public void setup()
	{
		
		
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/HP/OneDrive/Desktop/IntroToUnitTesting/alert.html");
	}
	
	@Test
	public void test() throws IOException
	{
		WebElement button=driver.findElement(By.xpath("//input[@value=\"Display alert box\"]"));
//		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		File src=button.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\HP\\OneDrive\\Desktop\\IntroToUnitTesting\\screen//button.png"));
	}
	
}
