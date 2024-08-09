package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cahonpicksearchpage {

	
	WebDriver driver;
    By checkbox=By.id("adv");
    By pricerange1=By.id("pf");
    By pricerange2=By.id("pt");
    By seachbutton=By.xpath("//input[@type=\"submit\"]");
    
    public Cahonpicksearchpage(WebDriver driver) {
		this.driver = driver;
	}

	public void advancedsearch(String pr1,String pr2)
    {
    	driver.findElement(checkbox).click();
    	driver.findElement(pricerange1).sendKeys(pr1);
    	driver.findElement(pricerange2).sendKeys(pr2);
    	driver.findElement(seachbutton).click();;
    }
    
    

    
	
	
}
