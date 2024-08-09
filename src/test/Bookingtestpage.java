package test;

import org.testng.annotations.Test;

import page.VrlBooking;

public class Bookingtestpage extends BaseclassBooking {

	
	@Test
	public void test() throws InterruptedException {
	VrlBooking obj=new VrlBooking(driver);
	obj.alert();
	obj.selsource("Ahmedabad");
	obj.seldestination("Bangalore");
	obj.datepicker();
	obj.search();
	}
	
	
	
}
