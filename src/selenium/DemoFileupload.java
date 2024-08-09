package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoFileupload {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void url() throws InterruptedException, AWTException {
        driver.get("https://demo.guru99.com/test/upload/");
        Thread.sleep(2000);

        // File path to be uploaded
        String filePath = "C:\\Users\\HP\\OneDrive\\Desktop\\sem 4\\subhfinalprint (1).docx";

        // Check if the file exists
        

        // Locate the file input element and set the file path
        WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"uploadfile_0\"]"));
		Actions act=new Actions(driver);
        act.click(fileInput);
        act.perform();
        // Wait to ensure the file is uploaded
        Thread.sleep(2000);
        fileupload(filePath);

        // Interact with the checkbox and submit button
        
    }

	private void fileupload(String filePath) throws InterruptedException, AWTException {
		
		StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        // Use Robot class to simulate keyboard actions
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Add a wait to ensure the file is uploaded
        Thread.sleep(5000); // 
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.id("submitbutton")).click();
        
	}

   
}
