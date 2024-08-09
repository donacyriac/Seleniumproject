package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Phpdatepicker {

	
	ChromeDriver driver;

	@BeforeTest
	public void setup()
	{	driver=new ChromeDriver();

	}

	
	@BeforeMethod
	public void url()
	{
		driver.get("https://phptravels.net/");
	}
	
	@Test
	public void test() throws InterruptedException
	{
	    String month="September 2024";
	    String date="20";
		WebElement hotel=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[1]/ul/li[2]/a"));
	    hotel.click();
	    Thread.sleep(3000);
	    WebElement checkin=driver.findElement(By.xpath("//*[@id=\"checkin\"]"));
	    checkin.click();
	    while (true) {
	    	String act=driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/div[1]/table/thead/tr[1]/th[2]")).getText();
	    	if(act.equals(month))
	    	{
	    		break;
	    	}
	    	else
	    		Thread.sleep(2000);
	    		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/div[1]/table/thead/tr[1]/th[3]")).click();
	    }
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/div[1]/table/tbody/tr[4]/td[6]")).click();
	    
	}

}
