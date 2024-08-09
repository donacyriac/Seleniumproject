package page;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class VrlBooking {

	WebDriver driver;
	By alertclose = By.xpath("//*[@id=\"largeModal\"]/div/div/button");
	By source = By.xpath("//*[@id=\"FromCity\"]");
	By destination = By.xpath("//*[@id=\"ToCity\"]");
	By datepicker = By.xpath("//*[@id=\"txtFromDate\"]");
	By searchbutton = By.xpath("//*[@id=\"demo\"]/section[2]/div/div/div[2]/div/div/div/div[1]/div/div[3]/button");

	public VrlBooking(WebDriver driver) {
		this.driver = driver;
	}

	public void alert() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(alertclose));
		element.click();
}
public void selsource(String Text) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(source));

		// Scroll to the element to ensure it is in view
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

		wait.until(ExpectedConditions.elementToBeClickable(element));

		element.click();
		element.sendKeys(Text, Keys.ENTER);
}

	public void seldestination(String Text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement destination1 = wait.until(ExpectedConditions.visibilityOfElementLocated(destination));

		Actions actions = new Actions(driver);
		actions.moveToElement(destination1).perform();

		wait.until(ExpectedConditions.elementToBeClickable(destination1));

		// Click the elements
		destination1.click();
		destination1.sendKeys(Text, Keys.ENTER);
	}

	public void datepicker() throws InterruptedException {
		String date = "31";
		String month = "July 2024";
		driver.findElement(datepicker).click();
		Thread.sleep(3000);

		while (true) {
			String act = driver.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[1]/th[2]")).getText();
			if (act.equals(month)) {
				break;
			} else
				Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[1]/th[3]")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr[5]/td[4]")).click();
	}

	public void search() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(searchbutton).click();
	}
}