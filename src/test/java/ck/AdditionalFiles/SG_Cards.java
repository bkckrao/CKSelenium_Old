package ck.AdditionalFiles;

import org.apache.http.client.UserTokenHandler;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ck.library.FrameLib;
import ck.scripts.Naukri_Page_Ids;


import ck.library.FrameLib.*;
//import my_FrameWork.Page_Ids;


public class SG_Cards extends FrameLib{
	private String baseUrl;

	//	Page_Ids Page_IdsObj;


/*	@DataProvider(name = "DP1")
	public Object[][] createData() {
		Object[][] retObjArr=new ExcelRetrieve().getTableArray("D:\\ck\\SGCards.xls", "sgcards", "Cards");
		return(retObjArr);
	}
*/

	@BeforeTest
	public void setUp() throws Exception {

		openBrowser(Select_Browser.FF);
		
//		baseUrl = "https://www.test.emea.wexinc.co.uk:9743/IFCS/faces/secure/tnc/tnc.xhtml";
		baseUrl = "https://www.test.emea.wexinc.co.uk:9743/IFCS/faces/secure/home/homepage.xhtml";

	}

	@Test(dataProvider = "DP1")
	public void sgcardsCreate(String name, String CardRetr) throws Exception {
		driver.get(baseUrl);

		sleepfor10sec();

if(driver.findElement(By.id("j_username")).isDisplayed()){
		driver.findElement(By.id("j_username")).clear();
		driver.findElement(By.id("j_username")).sendKeys("ck");
		driver.findElement(By.id("j_password")).clear();
		driver.findElement(By.id("j_password")).sendKeys("password01");
		driver.findElement(By.id("btn_login")).click();
}

		try{
			//	    	waitforelemby(By.id("lform:btn_tnc_agree"), "agree button in TNC page");
			if(driver.findElement(By.id("lform:btn_tnc_agree")).isDisplayed()){
				driver.findElement(By.id("lform:btn_tnc_agree")).click();
				sleepfor10sec();
			}else{ System.out.println("Agree button is not displayed"); } }
		catch (Exception e) {
			// TODO: handle exception
		}


		//	    driver.findElement(By.id("lform:btn_tnc_agree")).click();
		//	    sleepfor10sec();

		driver.findElement(By.id("levelOneCards")).click();
		System.out.println("Cards is clicked");
		driver.findElement(By.id("menu_form:levelTwoCardNew")).click();
		System.out.println("Order card is clicked");
		
		try{
			//	    	waitforelemby(By.id("lform:btn_tnc_agree"), "agree button in TNC page");
			if(driver.findElement(By.id("lform:btn_tnc_agree")).isDisplayed()){
				driver.findElement(By.id("lform:btn_tnc_agree")).click();
				sleepfor10sec();
			}else{ System.out.println("Agree button is not displayed...2"); } }
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
//		driver.findElement(By.id("lform:cardProductVODoTcard_offer_oid")).click();
//		sleepfor10sec();

		new Select(driver.findElement(By.id("lform:cardProductVODoTcard_offer_oid"))).selectByVisibleText("SG Fleet Card");
		driver.findElement(By.id("lform:cardVODoTexpires_onInputDate")).clear();
		driver.findElement(By.id("lform:cardVODoTexpires_onInputDate")).sendKeys("30/06/2020");
		System.out.println("Date Entered :" + driver.findElement(By.xpath("//input[@id='lform:cardVODoTexpires_onInputDate']")).getText());
				sleepfor10sec();
		
		System.out.println("CardRetr : "+CardRetr);
		new Select(driver.findElement(By.id("lform:cardControlProfileVOsDoTcardControlVODoTproduct_restriction_oid"))).selectByVisibleText(CardRetr);
		
		
		
		
		
//		selectByVisibleText(CardRetr);
		
		System.out.println("Product Retriction Entered");
		driver.findElement(By.id("lform:vehicleVODoTlicense_plate")).clear();
		driver.findElement(By.id("lform:vehicleVODoTlicense_plate")).sendKeys(name);
		new Select(driver.findElement(By.id("lform:cardControlProfileVOsDoTcardControlVODoTvelocityAssignmentVODoTvelocity_type_value_1_oid"))).selectByVisibleText("No Limit");
		new Select(driver.findElement(By.id("lform:cardControlProfileVOsDoTcardControlVODoTvelocityAssignmentVODoTvelocity_type_value_2_oid"))).selectByVisibleText("No Limit");
		new Select(driver.findElement(By.id("lform:cardControlProfileVOsDoTcardControlVODoTvelocityAssignmentVODoTvelocity_type_value_3_oid"))).selectByVisibleText("No Limit");
		new Select(driver.findElement(By.id("lform:cardControlProfileVOsDoTcardControlVODoTvelocityAssignmentVODoTvelocity_type_value_4_oid"))).selectByVisibleText("No Limit");
		new Select(driver.findElement(By.id("lform:cardControlProfileVOsDoTcardControlVODoTvelocityAssignmentVODoTvelocity_type_value_5_oid"))).selectByVisibleText("4 Trans");
		new Select(driver.findElement(By.id("lform:cardControlProfileVOsDoTcardControlVODoTvelocityAssignmentVODoTvelocity_type_value_6_oid"))).selectByVisibleText("No Limit");
		new Select(driver.findElement(By.id("lform:cardControlProfileVOsDoTcardControlVODoTvelocityAssignmentVODoTvelocity_type_value_7_oid"))).selectByVisibleText("No Limit");
		new Select(driver.findElement(By.id("lform:cardControlProfileVOsDoTcardControlVODoTvelocityAssignmentVODoTvelocity_type_value_8_oid"))).selectByVisibleText("$500");
		driver.findElement(By.id("lform:cardControlProfileVOsDoTcardControlVODoTis_pos_pin_change_allowed")).click();
		System.out.println("All field Entered");
			    driver.findElement(By.id("lform:btn_orderCard")).click();
			    
			    sleepfor10sec(); sleepfor10sec();
			    driver.findElement(By.id("logoff")).click();
			    sleepfor10sec();
			    

	} 
	@AfterTest
	public static void teardown(){
		  driver.findElement(By.id("logoff")).click();
	}
}
