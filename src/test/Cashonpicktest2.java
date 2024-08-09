package test;

import org.testng.annotations.Test;

import page.Cashonpickpage;
import page.Cahonpicksearchpage;

public class Cashonpicktest2 extends BaseclassCash{

	@Test
	public void test2()  {  
		Cashonpickpage obj=new Cashonpickpage(driver);
		Cahonpicksearchpage obj2=new Cahonpicksearchpage(driver);
		obj.search("oneplus");
		obj2.advancedsearch("3000", "20000");
		
	}
}

