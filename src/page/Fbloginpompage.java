package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fbloginpompage {
    WebDriver driver;
    By email = By.id("email");
    By password = By.id("pass");
    By loginButton = By.name("login"); // Changed locator to name for login button

    public Fbloginpompage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String emailText, String passwordText) {
        driver.findElement(email).sendKeys(emailText);
        driver.findElement(password).sendKeys(passwordText);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
