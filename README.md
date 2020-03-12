# CKSelenium
## Introduction:
This is the Automation framework develped for simple usage with out any complexities in the process of using the framework. So every beginner will love to use this framework.
It is developed for selenium with Java. Please note that it is in initial stage and suggestions are welcome and encouraged to contribute your part for this project.

Note the tools we are using:

1. Eclipse
2. Selenium
3. TestNG
4. Maven
5. Excel Plugins to read the data from Excel
6. HTML to visualize the reports 

# How to use CKSelenium framework:
 Download the jar file **CKFramework.jar** , **pom.xml** from the above repository
 Create a fresh New Maven project in Eclipse.


### Adding Jar file to the project:
Add the download the jar file **CKFramework.jar** to your Eclipse build path like below:

Right click on the Project --> Build Path --> Configure Build Path --> Java Buildpath --> Add External JARs and select the downloaded jar file *CKFramework.jar* and Refresh the project.
### Changing the pom file:
do not touch the first section with groupid, artifactId, version tags that repersents your project name. Replace the next sections that installs dependancies, plugins and save.
you can observe the % of your repo downloading dependancies at the bottom down of eclipse.
Now, we are done with adding framework to our project, downloading dependancies from pom file.

### How to write the elements based on the Jar file:

Let us take the example of adding elemets from Naukri.

```
package ck.scripts;

import org.openqa.selenium.By;
import ck.library.*;
import ck.library.SimpleLib.Type;

public class Naukri_Page_Ids extends SimpleLib{

//	Title of Naukri Home
	public static String Title = "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com";
	
// Username TextField	
	public static Textfield usertextfield = new Textfield("//input[@id='usernameField']", Type.XPATH);
	
// Password Textfield	
	public static Textfield passtextfield = new Textfield("//input[@id='passwordField']");   
	
//  Lgin Button	
	public static Button loginButton = new Button("//button[text()='Login']", Type.XPATH);
	
// Skip and COntinur Button	
	public static Button skipandcontinue = new Button("//button[text()='SKIP AND CONTINUE']", Type.XPATH);
	
//	View and Update Profile Button
	public static Button updateprofilebutton = new Button("//div[text()='UPDATE PROFILE']", Type.XPATH);

//	Login Link
	public static Link loginLink = new Link("//a[@id='login_Layer']/div", Type.XPATH);
	
//	Submit Button
	public static Button submitButton = new Button("//input[@name='Login']", Type.XPATH);
		
//	My Nauri Link Text
	public static Link myNaukriLinkText = new Link("//a[contains(text(),'My Naukri')]",Type.XPATH);  // Need to check ID is correct or not..?
	
//	Upload Link
	public static Button updateResumeButton = new Button("//input[@id='attachCV']",Type.XPATH);
	
//	Attach CV TextField
	public static Textfield attachCVTextField = new Textfield("//input[@id='attachCV']", Type.XPATH);
	
//	Save Button
	public static Button saveButton = new Button("//button[@type='button']", Type.XPATH);
	
//	Confirm Message
	public static Label confirmMessage = new Label("//span[@id='confirmMessage']", Type.XPATH);
	
//	Uploaded on date
	public static Label uploadedondate = new Label("//span[@class='updateOn']/text()[2]", Type.XPATH);
	
// LogOut Link	
	public static Link logoutlink = new Link("//a[@href='https://www.naukri.com/nlogin/logout']", Type.XPATH);
	
}
```


Now we have elements of Username, Password, login button etc...

Now to write the script on usertextfield, Just call the object usertextfield that follows the methods used for the Textfield which are overridden methods of Selenium Wendriver.

Similarly same goes for Label, Link, Button etc. So you dont have to call the driver or mostly used webdriver commands are equipped with those elements.

### How to get the data from Excel:

create an object for the ReadExcel just like below: 

ReadExcel getdata = new ReadExcel();

```
Naukri_Page_Ids.usertextfield.setText(getdata.readexceldatawithheadings(sTestdata_Path, "Sheet1", "Naukri_ProfileUpdate","Username"), "UsernameTextField");
```
Naukri_Page_Ids - this is the class where elements are written
usertextfield  -  element in the class for the Username field
setText  -  Method in the Textfield class to write the data to username from hte excel.
getdata  -  This is the object for the class ReadExcel
readexceldatawithheadings - Method in the ReadExcel to get data base on the column name and row name which are passed as parameters forthis method
sTestdata_Path - Path of the test data excel work book
Sheet1 - Name of the sheet, incase of having multiple sheets in the work book
Naukri_ProfileUpdate  - Row name, Suggest to write the script name
Username  -  this is the heading for the column where the row Naukri_ProfileUpdate and column Username meets is the value returns.
UsernameTextField  -  This is just for reference and it will display in the reports.

## Reports:
Report will be created in the CKReporting folder with a stime stamp. So when you run the script again and again, it will not overwrite the report.




