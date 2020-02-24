package ck.scripts;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.http.client.UserTokenHandler;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
//import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ck.library.FrameLib;
//import ck.library.FrameLib.Select_Browser;
import ck.readExcel.ReadExcel;
import ck.report.Reporter;

public class Copy_Naukripageobj2 extends FrameLib{
	private String baseUrl;
	private String Url;
	private String urlTail;
//	private String Email = "bkckrao@gmail.com";
//	private String phone = "2321479";
	private String Path = "C:\\CK\\ChennaKesav_Testing_Resume.doc" ;
	//	private String Title = "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com";
//	private String Title = "Naukri.com Login: Search the best jobs available in India. Apply to jobs online.";
	private String Title = "Jobseeker's Login: Search the Best Jobs available in India & Abroad - Naukri.com";

	private String pathoftestdata;

	ReadExcel getdata = new ReadExcel();
	//	Page_Ids Page_IdsObj;

	
	@BeforeSuite(alwaysRun = true)
	public void setupBeforeSuite(ITestContext context) {
	  Url = context.getCurrentXmlTest().getParameter("selenium.url");
	  pathoftestdata = context.getCurrentXmlTest().getParameter("pathoftestdata");
	}
	
	
	@BeforeTest
	public void setUp() throws Exception {
		openBrowser(Select_Browser.CHROME);
		Reporter.initialize();
		
	}

	@Test(testName="Naukri Update Resume")
	public void Naukri_ProfileUpdate(Method m) throws Exception {
//		driver.get(baseUrl);
		driver.get(Url);

		//		sleepfor10sec();
		Reporter.heading(m.getName());
		System.out.println("Method name:" +	m.getName());
System.out.println("pathoftestdata :"+pathoftestdata);
//		System.out.println("Expected gangothri, Actual : " + getdata.readexceldatawithheadings("C://Tools//Testdata_Sample.xlsx", "one", "TC3","Field2")); 

	waitfortitleandvalidate(Title);
//	System.out.println("value from Excel = "+	getdata.readexceldatawithheadings("C://Tools//Testdata_Sample.xlsx", "one", "TC3","Field2"));
//	getdata.readexceldatawithheadings(pathoftestdata, "Sheet1", "Naukri_ProfileUpdate","Username");

		Reporter.report("Tesing the Info Messages");
		Reporter.report(driver,"actualValue","expectedValue");

		/*	
		Page_Ids.loginLink.waitForElement("Login Link");
		Page_Ids.loginLink.click();*/

		System.out.println("Title :"+driver.getTitle());

		//				TextFieldTypeNValidate(By.xpath(Page_Ids.usertextfield.getElement()), "User Name Field", Email);
		
		Naukri_Page_Ids.usertextfield.setText(getdata.readexceldatawithheadings(pathoftestdata, "Sheet1", "Naukri_ProfileUpdate","Username"), "UsernameTextField");
		Naukri_Page_Ids.passtextfield.setText(getdata.readexceldatawithheadings(pathoftestdata, "Sheet1", "Naukri_ProfileUpdate","Password"), "PasswordTextField");
		Naukri_Page_Ids.submitButton.click();

		Naukri_Page_Ids.updateprofilebutton.waitForElement("View and Update Profile Button");

		//		waitforelemby(By.xpath("//div[@class='blueBut']/button"), "View And Update Profile Button");

		Naukri_Page_Ids.updateprofilebutton.click();

		//		driver.findElement(By.xpath("//div[@class='blueBut']/button")).click();

		//		Reporter.log("Test Report after click of Update profile Button");

		/*waitforelemby(By.xpath("//a[@id='uploadLink']"), "UPload Link");
		driver.findElement(By.xpath("//a[@id='uploadLink']")).click();
		 */



		//	    driver.findElement(By.id("attachCV")).clear();
		//		driver.findElement(By.id("attachCV")).sendKeys(Path);
//		Naukri_Page_Ids.uploadLink.waitForElement("Upload Link");
//		Naukri_Page_Ids.uploadLink.click();

		Naukri_Page_Ids.attachCVTextField.click();
//		Naukri_Page_Ids.attachCVTextField.setText(Path, "pathTextField");
		
		sleepfor10sec();
		Runtime.getRuntime().exec("D://ck//Autoit//Naukri_UploadResume");
		sleepfor10sec();
		sleepfor10sec();

		//		driver.findElement(By.cssSelector("button.w85bt.fl")).click();
		Naukri_Page_Ids.saveButton.click();
		sleepfor10sec();
		
		if(driver.findElement(By.xpath("//span[@id='confirmMessage']")).getText().equalsIgnoreCase("Your naukri profile has been updated with your uploaded resume")){
			System.out.println("Resume updated successfully");
		}else{System.out.println("Failed updating resume");}

		Naukri_Page_Ids.logoutlink.click();
		//		driver.findElement(By.linkText("Logout")).click();


		/*	waitfortitleandvalidate("Farmers® - Auto - Home - Life - Business - Motorcycle - Renters - Car Insurance");
		//	Maximizing the window
		Maximizethewindow();
		//		Type the User Name
		TextFieldTypeNValidate(By.id("username"),"UserNameField", usernpass);*/

	}
	@Test
	public static void Secondtestcase(Method m){
		Reporter.heading(m.getName());
		Reporter.report(driver, "actualValue", "expectedValue");
	}

	@AfterTest
	public void aftertest() throws IOException{
		Reporter.writeResults();
	}
}
