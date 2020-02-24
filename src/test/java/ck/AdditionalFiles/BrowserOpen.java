package ck.AdditionalFiles;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

//import com.infor.lib.GeneralFunc;

import ck.library.FrameLib;

public class BrowserOpen extends FrameLib{
@Test
	public static void open_Chrome(){
		// TODO Auto-generated method stub
	/*	System.setProperty("webdriver.chrome.driver", "library\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
*/		
	
	System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
	driver=new ChromeDriver();
		
		driver.get("www.google.com");
	}
}

