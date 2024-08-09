package test;

import java.awt.AWTException;

import org.testng.annotations.Test;

import page.Automationqapage;


public class Automationqatestpage extends Baseclassautoqa {

	@Test
	public void test1() throws InterruptedException, AWTException{  
		Automationqapage obj=new Automationqapage(driver);
		obj.Keypassing("dona", "cyriac", "abc po", "dona@gmail.com", "7896786545", "Adobe InDesign", "pass123", "pass123");
	
	}
}
