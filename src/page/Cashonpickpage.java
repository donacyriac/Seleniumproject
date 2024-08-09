package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Cashonpickpage {

	
	WebDriver driver;
	By searchbar=By.xpath("//input");
	By position=By.xpath("//*[@id=\"products-orderby\"]");
	By display=By.xpath("//*[@id=\"products-pagesize\"]");
	
	
	public Cashonpickpage(WebDriver driver) {
		this.driver = driver;
	}

	public void search(String keyword)
	{
		driver.findElement(searchbar).sendKeys(keyword,Keys.ENTER);
	
	}
	
	public void positiondrop(int index)
	{
		WebElement position1 =driver.findElement(position);
		Select element=new Select(position1);
		element.selectByIndex(index);
	}
	public void displaydrop(int index)
	{
		WebElement display1 =driver.findElement(display);
		Select elementdisplay=new Select(display1);
		elementdisplay.selectByIndex(index);
	}
}
