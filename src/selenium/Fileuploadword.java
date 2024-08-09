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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Fileuploadword {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void uploadFile() throws AWTException, InterruptedException {
        driver.get("https://www.ilovepdf.com/word_to_pdf");

        WebElement button = driver.findElement(By.id("pickfiles"));
        button.click();

        // Wait for the file upload dialog to open
        Thread.sleep(2000);

        // File path to be uploaded
        String filePath = "C:\\Users\\HP\\OneDrive\\Desktop\\IntroToUnitTesting\\Reverse Program-Group activity-Group 3.docx";

        // Check if the file exists
        if (!Files.exists(Paths.get(filePath))) {
            System.out.println("File does not exist at specified path: " + filePath);
            return;
        }

        // Upload the file
        fileUpload(filePath);
    }

    public void fileUpload(String filePath) throws AWTException, InterruptedException {
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
        Thread.sleep(5000); // Adjust the wait time as needed
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
