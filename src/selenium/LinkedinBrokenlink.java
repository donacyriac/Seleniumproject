package selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LinkedinBrokenlink {
	ChromeDriver driver;
		@Before
	    public void setUp() {
	        // Setup WebDriver using WebDriverManager
	        driver = new ChromeDriver();
	    }

	    @Test
	    public void testCountBrokenLinks() {
	        // Navigate to the webpage
	        driver.get("https://in.linkedin.com/"); // Replace with the actual URL

	        // Find all links on the webpage
	        List<WebElement> links = driver.findElements(By.tagName("a"));

	        // Initialize a counter for broken links
	        int brokenLinksCount = 0;

	        // Iterate over each link
	        for (WebElement link : links) {
	            String url = link.getAttribute("href");
	            if (url != null && !url.isEmpty()) {
	                try {
	                    // Create a connection to the URL
	                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	                    connection.setRequestMethod("GET");
	                    connection.connect();

	                    // Get the response status code
	                    int responseCode = connection.getResponseCode();
	                    if (responseCode >= 400) {
	                        System.out.println(url + " is a broken link with status code: " + responseCode);
	                        brokenLinksCount++;
	                    }

	                } catch (IOException e) {
	                    System.out.println("Exception while checking link: " + url + " - " + e.getMessage());
	                }
	            }
	        }

	        // Print the total number of broken links
	        System.out.println("Total number of broken links: " + brokenLinksCount);
	    }

	    @After
	    public void tearDown() {
	        if (driver != null) {
	            
	        }
	    }
	}

