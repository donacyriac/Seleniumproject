package test;

import org.testng.annotations.Test;

import page.Bookingpage;

public class Busbookingtest extends Baseclass{

	
	
	@Test
	public void test() throws InterruptedException {
	
		
		Bookingpage obj=new Bookingpage(driver);
		obj.alert();
		obj.destination();
		obj.people();
	}
}
