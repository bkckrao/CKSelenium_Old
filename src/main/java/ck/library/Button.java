package ck.library;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**this class provides methods used for buttons those are supported by selenium. 
 * You just have to create an object for your element like public static Button elem1 = new Button(<xpath>, Type.xpath)
 *All the suppoting methods can be called like elem1.click, elem1.waitForElement, elem1.getElement, elem1.setElement
 *@author ChennnakesavaRao
 */

public class Button extends SimpleLib{
	private WebDriver driver;
	private Type type;
	private String element;
	
	public Button(String element, Type type){
		this.type = type;
		this.element = element;
		this.driver = FrameLib.driver;
	}

	public void click(){

		switch(type){
		case ID: driver.findElement(By.id(element)).click(); break;
		case NAME: driver.findElement(By.name(element)).click(); break;
		case XPATH: driver.findElement(By.xpath(element)).click(); break;
		case CSS: driver.findElement(By.cssSelector(element)).click(); break;
		}
	}	
	public void waitForElement(String ElementName) throws Exception{

		switch(type){
		case ID:{  waitForElementBy(By.id(element), ElementName); }break;
		case NAME: waitForElementBy(By.name(element), ElementName);; break;
		case XPATH: waitForElementBy(By.xpath(element), ElementName); break;
		case CSS: waitForElementBy(By.cssSelector(element), ElementName);; break;
		}
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}
	
	
	
	
	
}
