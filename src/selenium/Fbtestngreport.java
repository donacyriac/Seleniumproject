package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Fbtestngreport {

	ChromeDriver driver;
	String baseurl="https://www.facebook.com/";
	ExtentHtmlReporter extentt;
	ExtentReports report;
	ExtentTest test;
	@BeforeTest
	public void setup()
	{	driver=new ChromeDriver();
		extentt=new ExtentHtmlReporter("./Reports/fbtestreport.html");
		extentt.config().setTheme(Theme.DARK);
		extentt.config().setReportName("Facebook Automation Report");
		extentt.config().setDocumentTitle("Report");
		
		report=new ExtentReports();
		report.attachReporter(extentt);
		report.setSystemInfo("OS", "windows11");
		report.setSystemInfo("Host", "General");
		report.setSystemInfo("Tested by", "Dona Cyriac");
	}

	
	@BeforeMethod
	public void url()
	{
		driver.get(baseurl);
	}
	
	@Test
	public void test()
	{
		test=report.createTest("test1");
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[@name='login']")).click();
	
	}
	@Test
	public void test2()
	{			
		test=report.createTest("test2");
		String act=driver.getTitle();
		System.out.println(act);
		String exp="Facebook";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(exp, act);
        softAssert.assertAll();
	
	}
	@Test
	public void test3()
	{
		test=report.createTest("test3");
		WebElement button=driver.findElement(By.xpath("//div[@class=\"_6ltg\"]/button"));
		String act=button.getText();
		String  exp="Log in inn";
		System.out.println(button.getText());
		Assert.assertEquals(act, exp);
	
	}
	@Test
	public void test4()
	{
		test=report.createTest("test4");
		WebElement logo=driver.findElement(By.xpath("//img"));
		Assert.assertTrue(logo.isDisplayed(), "logo is not displayed");
	
	}
	
	
	@AfterTest
	public void quit()
	{
		report.flush();
	}
	
}
