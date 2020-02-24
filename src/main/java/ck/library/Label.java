package ck.library;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * this class provides methods used for Labels those are supported by selenium. 
 * You just have to create an object for your element like public static Label elem1 = new Label(<xpath>, Type.xpath)
 *All the supporting methods can be called like elem1.getText, elem1.waitForElement, elem1.getElement, elem1.setElement
 *@author ChennnakesavaRao
 *
 */

public class Label extends SimpleLib{
	private WebDriver driver;
	private Type type;
	private String element;
	
	public Label(String element, Type type){
		this.type = type;
		this.element = element;
		this.driver = FrameLib.driver;
	}

	public String getText(){

		switch(type){
		case ID: driver.findElement(By.id(element)).getText(); break;
		case NAME: driver.findElement(By.name(element)).getText(); break;
		case XPATH: driver.findElement(By.xpath(element)).getText(); break;
		case CSS: driver.findElement(By.cssSelector(element)).getText(); break;
		}
		return getText();
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
