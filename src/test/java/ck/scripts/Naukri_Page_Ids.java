package ck.scripts;

import org.openqa.selenium.By;

import ck.library.*;
import ck.library.SimpleLib.Type;

public class Naukri_Page_Ids extends SimpleLib{

//	Title of Naukri Home
	public static String Title = "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com";
	
	public static Textfield usertextfield = new Textfield("//input[@id='usernameField']", Type.XPATH);
	public static Textfield passtextfield = new Textfield("//input[@id='passwordField']");   

	public static Button loginButton = new Button("//button[text()='Login']", Type.XPATH);
	 
	
	public static Button skipandcontinue = new Button("//button[text()='SKIP AND CONTINUE']", Type.XPATH);
	
//	View and Update Profile Button
//	public static Button updateprofilebutton = new Button("//a[text()='UPDATE PROFILE']", Type.XPATH);
	public static Button updateprofilebutton = new Button("//div[text()='UPDATE PROFILE']", Type.XPATH);
//	public static Button updateprofilebutton = new Button("//input[@value='Update Resume']", Type.XPATH);
	
	
	
	//a[contains(@href, 'https://my.naukri.com/Profile/view?id=&orgn=homepage')])[2]
	
//	Login Link
	public static Link loginLink = new Link("//a[@id='login_Layer']/div", Type.XPATH);
	
	
//	Submit Button
	public static Button submitButton = new Button("//input[@name='Login']", Type.XPATH);
	
		
//	My Nauri Link Text
	public static Link myNaukriLinkText = new Link("//a[contains(text(),'My Naukri')]",Type.XPATH);  // Need to check ID is correct or not..?
	
//	Upload Link
//	public static Button updateResumeButton = new Button("//input[@value='Update Resume']",Type.XPATH);
	public static Button updateResumeButton = new Button("//input[@id='attachCV']",Type.XPATH);
//	public static Button updateResumeButton = new Button("//div[@class='uploadContainer']/input[@id='attachCV']",Type.XPATH);
	
//	Attach CV TextField
	public static Textfield attachCVTextField = new Textfield("//input[@id='attachCV']", Type.XPATH);
	
//	Save Button
	public static Button saveButton = new Button("//button[@type='button']", Type.XPATH);
	
//	Confirm Message
	public static Label confirmMessage = new Label("//span[@id='confirmMessage']", Type.XPATH);
	
	
//	Uploaded on date
	public static Label uploadedondate = new Label("//span[@class='updateOn']/text()[2]", Type.XPATH);
//	public static Label uploadedondate = new Label("//span[@class='updateOn']/text()[2]", Type.XPATH);
	
	public static Link logoutlink = new Link("//a[@href='https://www.naukri.com/nlogin/logout']", Type.XPATH);
	
}
