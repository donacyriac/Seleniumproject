package page;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bookingpage {

	WebDriver driver;
	By alertclose=By.xpath("//*[@id=\"b2indexPage\"]/div[39]/div/div/div/div[1]/div[1]/div/button/span");
	By searchbar=By.xpath("//*[@name=\"ss\"]");
	By destination=By.xpath("//*[@id=\"autocomplete-result-0\"]");
	By checkintext=By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[1]/h3");
	By checkouttext=By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[2]/h3");
	By checkindate=By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[1]/table/tbody/tr[5]/td[4]");
	By checkoutdate=By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[2]/table/tbody/tr[1]/td[7]");
	By peoplebutton=By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div[1]/div[3]/div/button");
	By adultnavigator=By.xpath("//*[@id=\":ri:\"]/div/div[1]/div[2]/button[1]");
	By childrennavigator=By.xpath("//*[@id=\":ri:\"]/div/div[2]/div[2]/button[2]");
	By childrendropdown=By.xpath("//*[@name=\"age\"]");
	By searchbutton=By.xpath("//*[@type=\"submit\"]");
	
	
	public Bookingpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	

	public void alert() throws InterruptedException {
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(alertclose));
		element.click();
	}
	
	public void destination()
	{
		driver.findElement(searchbar).click();
		driver.findElement(destination).click();
		
	}
	public void people() throws InterruptedException
	{
		driver.findElement(peoplebutton).click();
		driver.findElement(adultnavigator).click();
		driver.findElement(childrennavigator).click();
		Thread.sleep(4000);
		WebElement childage=driver.findElement(childrendropdown);
		Select child=new Select(childage);
		child.selectByValue("3");
	}
	
}

