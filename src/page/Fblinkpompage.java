package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fblinkpompage {
    WebDriver driver;
    By createLink = By.xpath("//*[@id=\"reg_pages_msg\"]/a");
    By email1 = By.id("email");
    By password1 = By.id("pass");
    By loginButton1 = By.id("loginbutton"); 


    public Fblinkpompage(WebDriver driver) {
        this.driver = driver;
    }

    public void createpage() {
        driver.findElement(createLink).click();
    }

    public void createlogin(String emaill,String passwd) {
        driver.findElement(email1).sendKeys(emaill); // Dummy input
        driver.findElement(password1).sendKeys(passwd); // Dummy input
    }
    public void clickLogin() {
        driver.findElement(loginButton1).click();
    }
}

