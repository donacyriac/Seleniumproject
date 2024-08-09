package page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Automationqapage {

	WebDriver driver;
	By firstname = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input");
	By lastname = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input");
	By address = By.xpath("//textarea");
	By email = By.xpath("//*[@id=\"eid\"]/input");
	By file = By.xpath("//*[@id=\"imagesrc\"]");
	By phoneno = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input");
	By malecheck = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input");
	By femalecheck = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input");
	By cricket = By.xpath("//*[@id=\"checkbox1\"]");
	By movies = By.xpath("  //*[@id=\"checkbox2\"]\r\n");
	By hockey = By.xpath("//*[@id=\"checkbox3\"]");
	By languages = By.xpath("//*[@id=\"msdd\"]");
	By skills = By.xpath("//*[@id=\"Skills\"]");
	By country = By.xpath("//*[@id=\"countries\"]");
	By selcountry = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span");
	By year = By.xpath("//*[@id=\"yearbox\"]");
	By month = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select");
	By day = By.xpath("//*[@id=\"daybox\"]");
	By password = By.xpath("//*[@id=\"firstpassword\"]");
	By conpassword = By.xpath("//*[@id=\"secondpassword\"]");
	By submit = By.xpath("//*[@id=\"submitbtn\"]");
	By refresh = By.xpath("//*[@id=\"Button1\"]");

	public Automationqapage(WebDriver driver2) {
		this.driver = driver2;
	}

	public void Keypassing(String firstname1, String lastname1, String address1, String email1, String phoneno1,
			String Skill1, String password1, String conpass1) throws InterruptedException, AWTException {

		driver.findElement(firstname).sendKeys(firstname1);
		driver.findElement(lastname).sendKeys(lastname1);
		driver.findElement(address).sendKeys(address1);
		driver.findElement(email).sendKeys(email1);
		driver.findElement(phoneno).sendKeys(phoneno1);
		String filePATH = "\"C:\\Users\\HP\\OneDrive\\Desktop\\IntroToUnitTesting\\Book1.xlsx\"";
		fileupload(filePATH);
		gender();
		hobbiesselected();
		driver.findElement(languages).click();
		languageselect();
		skillset(Skill1);
		Thread.sleep(1000);
		driver.findElement(selcountry).click();
		selectcountry();
		Thread.sleep(1000);
		selectdob();
		passwordcheck(password1, conpass1);
		driver.findElement(submit).click();
	}

	private void passwordcheck(String password1, String conpass1) {
		WebElement pass = driver.findElement(password);
		pass.sendKeys(password1);
		WebElement cpass = driver.findElement(conpassword);
		cpass.sendKeys(conpass1);
		Assert.assertEquals(pass.getAttribute("value"), password1, "Password field value is incorrect.");
		Assert.assertEquals(cpass.getAttribute("value"), conpass1, "Confirm password field value is incorrect.");

		// Verify that the passwords match
		Assert.assertEquals(password1, conpass1, "Passwords do not match.");
	}

	public void gender() {
		WebElement male = driver.findElement(malecheck);
		if (!male.isSelected()) {
			male.click();
		}
		Assert.assertTrue(male.isSelected(), "Male checkbox is not selected.");
		WebElement female = driver.findElement(femalecheck);
		if (!female.isSelected()) {
			female.click();
		}
		Assert.assertTrue(female.isSelected(), "Male checkbox is not selected.");
	}

	public void hobbiesselected() {
		WebElement cricketCheckbox = driver.findElement(cricket);
		if (!cricketCheckbox.isSelected()) {
			cricketCheckbox.click();
		}
		Assert.assertTrue(cricketCheckbox.isSelected(), "Cricket checkbox is not selected.");

		WebElement moviesCheckbox = driver.findElement(movies);
		if (!moviesCheckbox.isSelected()) {
			moviesCheckbox.click();
		}
		Assert.assertTrue(moviesCheckbox.isSelected(), "Movies checkbox is not selected.");

		WebElement hockeyCheckbox = driver.findElement(hockey);
		if (!hockeyCheckbox.isSelected()) {
			hockeyCheckbox.click();
		}
		Assert.assertTrue(hockeyCheckbox.isSelected(), "Hockey checkbox is not selected.");

	}

	public void fileupload(String filepath) throws InterruptedException, AWTException {
		WebElement upload = driver.findElement(file);
		Actions act = new Actions(driver);
		act.click(upload);
		act.perform();
		StringSelection stringSelection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		// Use Robot class to simulate keyboard actions
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void languageselect() {
		WebElement opt1 = driver
				.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[1]/a"));
		WebElement opt2 = driver
				.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[2]/a"));
		opt1.click();
		opt2.click();

	}

	public void skillset(String skill1) {
		WebElement skill = driver.findElement(skills);
		Select skillset = new Select(skill);
		skillset.selectByValue(skill1);
	}

	public void selectcountry() throws InterruptedException {
		WebElement countrydrop = driver.findElement(selcountry);
		By searchInput = By.xpath("/html/body/span/span/span[1]/input");
		WebElement searchField = driver.findElement(searchInput);
		searchField.sendKeys("Australia");
		Thread.sleep(2000);
		By searchresult = By.xpath("//*[@id=\"select2-country-results\"]/li[1]");

		WebElement option = driver.findElement(searchresult);
		option.click();
		Assert.assertEquals(countrydrop.getText(), "Australia", "The selected country is incorrect.");

	}

	public void selectdob() {
		WebElement days = driver.findElement(day);
		Select dayelement = new Select(days);
		dayelement.selectByValue("5");
		;

		WebElement months = driver.findElement(month);
		Select monthelement = new Select(months);
		monthelement.selectByVisibleText("March");

		WebElement years = driver.findElement(year);
		Select yearelement = new Select(years);
		yearelement.selectByValue("1946");
		Assert.assertEquals(dayelement.getFirstSelectedOption().getAttribute("value"), "5",
				"Selected day is incorrect.");
		Assert.assertEquals(monthelement.getFirstSelectedOption().getText(), "March", "Selected month is incorrect.");
		Assert.assertEquals(yearelement.getFirstSelectedOption().getAttribute("value"), "1946",
				"Selected year is incorrect.");
	}

	public void refresh() {
		driver.findElement(refresh).click();
	}
}
