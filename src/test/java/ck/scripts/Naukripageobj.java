package ck.scripts;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.http.client.UserTokenHandler;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
//import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ck.library.FrameLib;

import ck.readExcel.ReadExcel;
import ck.report.Reporter;


public class Naukripageobj extends FrameLib{
	private String baseUrl;
	private String urlTail;
	//	private String Email = "bkckrao@gmail.com";
	//	private String phone = "password";
	private String Title;// = "Jobseeker's Login: Search the Best Jobs available in India & Abroad - Naukri.com";

	//	private String sTestdata_Path;

	ReadExcel getdata = new ReadExcel();

	/*	@BeforeSuite(alwaysRun = true)
	public void setupBeforeSuite(ITestContext context) {

//		Url = context.getCurrentXmlTest().getParameter("selenium.url");

	  pathoftestdata = context.getCurrentXmlTest().getParameter("pathoftestdata");
	  System.out.println("before suite");
	  System.out.println("Url : "+Url);
	}
	 */

	@BeforeTest
	public void setUp() throws Exception {
		//		openBrowser(Select_Browser.CHROME);
		openBrowser();
		System.out.println("before Test");
	}

	@Test
	public void Naukri_ProfileUpdate(Method m) throws Exception {

		Reporter.heading(m.getName());
		driver.get(sUrl);
		Reporter.report("Url :"+sUrl+ "  , has been passed to the browser");

		this.Title = getdata.readexceldatawithheadings(sTestdata_Path, "Sheet1", "Naukri_ProfileUpdate","Title");
		System.out.println("Title : "+Title);
		waitfortitleandvalidate(Title);

		Naukri_Page_Ids.usertextfield.setText(getdata.readexceldatawithheadings(sTestdata_Path, "Sheet1", "Naukri_ProfileUpdate","Username"), "UsernameTextField");
		Reporter.report("Username : "+getdata.readexceldatawithheadings(sTestdata_Path, "Sheet1", "Naukri_ProfileUpdate","Username")+"  , has been passed to the Username field");
		Naukri_Page_Ids.passtextfield.setText(getdata.readexceldatawithheadings(sTestdata_Path, "Sheet1", "Naukri_ProfileUpdate","Password"), "PasswordTextField");
		Reporter.report("Password : "+getdata.readexceldatawithheadings(sTestdata_Path, "Sheet1", "Naukri_ProfileUpdate","Password")+"  , has been passed to the password field");
		Naukri_Page_Ids.loginButton.click();
		Reporter.report("Submit button is clicked");

		sleepfor10sec();
		
//	verifying the existence of Skip and Continue button
		try {
			if(	isElementPresent(By.xpath(Naukri_Page_Ids.skipandcontinue.toString()))){
				Naukri_Page_Ids.skipandcontinue.click();
				Reporter.report("Skip and continue link is found and clicked");
			}else {
				Reporter.report("Skip and continue link seems to be not appeared");
			}
		} catch (Exception e) {
			Reporter.report("Skip and continue link seems to be not appeared");
		}


		Naukri_Page_Ids.updateprofilebutton.waitForElement("View and Update Profile Button");
		Naukri_Page_Ids.updateprofilebutton.click();
		Reporter.report("Update profile button is clicked");

		sleepfor10sec();

//		Naukri_Page_Ids.updateResumeButton.waitForElement("Update Resume button");
//		Naukri_Page_Ids.updateResumeButton.click();
		
		Naukri_Page_Ids.updateResumeButton.waitForElement("Update Resume button");
		Naukri_Page_Ids.updateResumeButton.click();
		
		Reporter.report("Update Resume button is clicked.");

				sleepfor10sec();
				
//	Autoit script to upload the CV on Windows dialogue
		Runtime.getRuntime().exec(sAutoitScriptPath);
		sleepfor10sec();
		
		


//		System.out.println("Uploaded on date :"+ Naukri_Page_Ids.uploadedondate.getText());
		
	System.out.println("uploaded on :" + driver.findElement(By.xpath("//span[@class='updateOn']")).getText());
	Reporter.report("CV upload successful on : "+driver.findElement(By.xpath("//span[@class='updateOn']")).getText().substring(12) );
//		Naukri_Page_Ids.logoutlink.click();
	
	Actions actions = new Actions(driver);
	WebElement menu = driver.findElement(By.xpath(Naukri_Page_Ids.myNaukriLinkText.toString()));
	actions.moveToElement(menu);

	WebElement subMenu = driver.findElement(By.xpath(Naukri_Page_Ids.logoutlink.toString()));
	actions.moveToElement(subMenu);
	actions.click().build().perform();
	
	
	}

	@Test
	public static void Secondtestcase(Method m){
		Reporter.heading(m.getName());
		Reporter.report(driver, "actualValue", "expectedValue");
		Reporter.report(driver, "actualValue", "actualValue");
	}

	@AfterTest
	public void aftertest() throws IOException{
		Reporter.writeResults();
	}
}
