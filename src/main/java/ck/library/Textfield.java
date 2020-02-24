package ck.library;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

/**this class provides methods used for Textfield those are supported by selenium. 
 * You just have to create an object for your element like public static Textfield elem1 = new Textfield(<xpath>, Type.xpath)
 *All the supporting methods can be called like elem1.Textfield(), elem1.clearText(), elem1.gettext, elem1.waitForElement, elem1.getElement, elem1.setElement
 *@author ChennnakesavaRao
 */

public class Textfield extends SimpleLib{
	
	private WebDriver driver;

	private Type type;
	private String element;
	
	public Textfield(String element, Type type){
		this.type = type;
		this.element = element;
		this.driver = FrameLib.driver;
	}
	
	/* this method to avoid specifying the second argument in the Textfield constructor
	 * 
	 */
	public Textfield(String element){
		this.type = Type.XPATH;
		this.element = element;
		this.driver = FrameLib.driver;
	}
	
//	clear Textfield
//	set Textfield
//	get Textfield
	
	public void clearText(){

		switch(type){
		case ID: driver.findElement(By.id(element)).clear(); break;
		case NAME: driver.findElement(By.name(element)).clear(); break;
		case XPATH: driver.findElement(By.xpath(element)).clear(); break;
		case CSS: driver.findElement(By.cssSelector(element)).clear(); break;
		}
	}
	
	public void getText(){

		switch(type){
		case ID: driver.findElement(By.id(element)).getText(); break;
		case NAME: driver.findElement(By.name(element)).getText(); break;
		case XPATH: driver.findElement(By.xpath(element)).getText(); break;
		case CSS: driver.findElement(By.cssSelector(element)).getText(); break;
		}
	}

	public void setText(String Valuetopass, String fieldname) throws Exception{

		switch(type){
		case ID:  
			waitForElement(fieldname);	clearText();
			driver.findElement(By.id(element)).sendKeys(Valuetopass);
			if(driver.findElement(By.id(element)).getAttribute("value").contains(Valuetopass)){
				Reporter.log("Value = " +Valuetopass+ " is entered successfully in Textfield : "+fieldname);
			}else{
				System.out.println("Value = " +Valuetopass+" is not entered properly in Textfield : "+fieldname);
			}break;

		case NAME: 
			waitForElement(fieldname);	clearText();
			driver.findElement(By.name(element)).sendKeys(Valuetopass);
			if(driver.findElement(By.name(element)).getAttribute("value").contains(Valuetopass)){
				Reporter.log("Value = " +Valuetopass+ " is entered successfully in Textfield : "+fieldname);
			}else{
				System.out.println("Value = " +Valuetopass+" is not entered properly in Textfield : "+fieldname);
			} break;
		case XPATH: 
			waitForElement(fieldname);	clearText();
			driver.findElement(By.xpath(element)).sendKeys(Valuetopass);
			if(driver.findElement(By.xpath(element)).getAttribute("value").contains(Valuetopass)){
				Reporter.log("Value = " +Valuetopass+ " is entered successfully in Textfield : "+fieldname);
			}else{	System.out.println("Value = " +Valuetopass+" is not entered properly in Textfield : "+fieldname);
			}break;
		case CSS: 
			waitForElement(fieldname);	clearText();
			driver.findElement(By.cssSelector(element)).sendKeys(Valuetopass);
			if(driver.findElement(By.cssSelector(element)).getAttribute("value").contains(Valuetopass)){
				Reporter.log("Value = " +Valuetopass+ " is entered successfully in Textfield : "+fieldname);
			}else{
				System.out.println("Value = " +Valuetopass+" is not entered properly in Textfield : "+fieldname);
			}break;
		}
	}

	public void waitForElement(String ElementName) throws Exception{

		switch(type){
		case ID:  waitForElementBy(By.id(element), ElementName); break;
		case NAME: waitForElementBy(By.name(element), ElementName); break;
		case XPATH: waitForElementBy(By.xpath(element), ElementName); break;
		case CSS: waitForElementBy(By.cssSelector(element), ElementName); break;
		}
	}

	public void click(){

		switch(type){
		case ID: driver.findElement(By.id(element)).click(); break;
		case NAME: driver.findElement(By.name(element)).click(); break;
		case XPATH: driver.findElement(By.xpath(element)).click(); break;
		case CSS: driver.findElement(By.cssSelector(element)).click(); break;
		}
	}	
	
	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}
	
	
}
