package test;

import org.testng.annotations.Test;

import page.Cashonpickpage;

public class Cashonpicktest1 extends BaseclassCash{

	@Test
	public void test1(){  
		Cashonpickpage obj=new Cashonpickpage(driver);
		obj.search("samsung");
		obj.positiondrop(1);
		obj.displaydrop(2);
	}
}
