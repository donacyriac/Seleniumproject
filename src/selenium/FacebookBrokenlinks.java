package selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FacebookBrokenlinks {

ChromeDriver	driver = new ChromeDriver();

    @Before
    public void setUp() {
        // Set the path to your WebDriver executable
        
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testForBrokenLinks() {
        driver.get("https://www.facebook.com/login/");
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
                    connection.setRequestMethod("HEAD");
                    connection.connect();
                    int responseCode = connection.getResponseCode();
                    System.out.println(url + " - " + responseCode);
                    assertTrue("Broken link: " + url, responseCode < 400);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}