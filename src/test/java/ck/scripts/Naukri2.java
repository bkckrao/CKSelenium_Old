package ck.scripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ck.library.FrameLib;

public class Naukri2 extends FrameLib{

	
	
	@BeforeTest
	public void setUp() throws Exception {
//		openBrowser(Select_Browser.CHROME);
		openBrowser();
		
		System.out.println("before Test");
	}
	
	
@Test	
public static void meth1() {
		System.out.println("sUrl : "+sUrl);
	driver.get(sUrl);
	}
}
