package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitDemo {
	
	ChromeDriver driver;
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://www.instagram.com/");
		
	}
	
	@Test
	public void test()
	{
		String exp="Instagram";
		String actual=driver.getTitle();
		System.out.println(actual);
		if(actual.contains(exp))
		{
			System.out.println("PASSED");
		}
		else
		{
			System.out.println("failed");
		}
	}
	
	@After
	public void after()
	{
		driver.quit();
	}
}
