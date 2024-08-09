package selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datadriventest {

	
	ChromeDriver driver;

	@BeforeTest
	public void setup()
	{	driver=new ChromeDriver();

	}

	
	@BeforeMethod
	public void url()
	{
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void test() throws IOException
	{
	FileInputStream ob=new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\IntroToUnitTesting//Book1.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(ob);
	XSSFSheet sh=wb.getSheet("Sheet1");
	int rowcount=sh.getLastRowNum();
	for(int i=1;i<=rowcount;i++)
	{
		String username=sh.getRow(i).getCell(0).getStringCellValue();
		String password=sh.getRow(i).getCell(1).getStringCellValue();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();


		

	}
	
	}
}
