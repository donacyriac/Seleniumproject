package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumProgram1 {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
//		driver.get("https://www.facebook.com/");
		driver.get("https://www.linkedin.com/home");
//		driver.findElement(By.name("email")).sendKeys("dona@gmail.com");
//		driver.findElement(By.id("pass")).sendKeys("dona@123");
//		driver.findElement(By.name("login")).click();
//		String Exp="Facebook – log in or sign up";
//		String actual=driver.getTitle();
//		System.out.println(actual);
//		if(Exp.equals(actual))
//		{
//			System.out.println("passed");
//		}
//		else
//		{
//			System.out.println("failed");
//		}
		String exp="LinkedIn";
		String actual=driver.getTitle();
		System.out.println(actual);
	
		if(actual.contains(exp))
		{
			System.out.println("passed");
		}
		else
			System.out.println("failed");
	}
	
	
	

}
