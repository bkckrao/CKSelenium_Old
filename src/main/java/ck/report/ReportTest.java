package ck.report;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

//import ck.readExcel.ReadExcel;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class ReportTest {
	
	public static void main (String args[]) throws IOException {
		
		
		/*
		ReadExcel read = new ReadExcel();
		read.readexceldatawithheadings("C://Tools//Testdata_Sample.xlsx", "one", "TC1", "Field2");
		*/
		
		
		
		WebDriver driver;
//		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
//		driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		
		Reporter.initialize();
		driver.get("http://www.ontestautomation.com/files/report_test.html");
		
		for (int i = 1; i <=5; i++) {
			WebElement el = driver.findElement(By.id("textfield" + Integer.toString(i)));
//			Reporter.report(driver, el.getAttribute("value"), "Text field " + Integer.toString(i));
			Reporter.report(driver, "Text field","Text field");
			System.out.println("textfield"+i);
		}
		
		driver.findElement(By.id("textfield1"));
		Reporter.report(driver,"textfield" , "Text field " );
		
		
		
		Reporter.writeResults();
		driver.close();	
	}
	
}