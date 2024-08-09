package test;
import org.testng.annotations.Test;
import page.Fblinkpompage;

public class Fblogincreatepagetest extends Baseclass {
    
   
    @Test
    public void createTest() throws InterruptedException {
        Fblinkpompage fblink = new Fblinkpompage(driver);
        fblink.createpage();
        Thread.sleep(2000);
        fblink.createlogin("abc@gmail.com", "abc123");
        fblink.clickLogin();
    }
}
