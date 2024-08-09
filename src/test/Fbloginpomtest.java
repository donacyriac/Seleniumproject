package test;

import org.testng.annotations.Test;
import page.Fbloginpompage;

public class Fbloginpomtest extends Baseclass  {
    
   

	@Test
    public void testLogin() {
        Fbloginpompage fb = new Fbloginpompage(driver);
        fb.login("abc@gmail.com", "abc123");
        fb.clickLogin();
    }

   
}
