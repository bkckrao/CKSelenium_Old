package ck.scripts;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.SeleneseCommandExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.internal.seleniumemulation.SeleneseCommand;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import com.thoughtworks.selenium.SeleneseTestNgHelper;

import ck.library.FrameLib;


public class RedBus extends FrameLib{


	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	private String From = "Vijayawada";
	private String To = "Chennai";
	public String DOJ = "09-Jan-2013";

	@BeforeTest
	public void setUp() throws InterruptedException {

		baseUrl = "http://www.redbus.in";

	}

	@Test
	public void testUntitled() throws InterruptedException {

		driver.get(baseUrl);

		waitfortitleandvalidate("ONLINE BUS TICKETS BOOKING SERVICE � ONLINE BUS TICKET RESERVATION");
		
		driver.findElement(By.id("DDLSource")).clear();
		driver.findElement(By.id("DDLSource")).sendKeys(From);
		driver.findElement(By.id("DDLDestination")).clear();
		driver.findElement(By.id("DDLDestination")).sendKeys(To);

		
		
		try {
			if(driver.findElement(By.xpath("//input[@id='calendar']")).getAttribute("value").equals("dd-mmm-yyyy")){
				System.out.println("\"dd-mmm-yyyy\" is dispalyed successfully");
			}
			

		} catch (Error e) {
			System.out.println("Date field validation with \"dd-mmm-yyyy\" is failed");
		}

//		jsremovattribute("calendar", "readOnly");

		driver.findElement(By.xpath("//input[@id='calendar']")).clear();
		driver.findElement(By.xpath("//input[@id='calendar']")).sendKeys(DOJ);

		driver.findElement(By.id("searchBtn")).click();

		waitfortitleandvalidate("Book Ticket - Search Buses");
		waitforelemby(By.linkText("modify"), "Waiting for link Modify");
		
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		
	}


}
