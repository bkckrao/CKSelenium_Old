package ck.library;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;


//import com.thoughtworks.selenium.SeleniumException;
//import org.testng.Reporter;
import ck.report.Reporter;

public class FrameLib extends BaseTest {
	/*
	 * @BeforeClass public static void beforeclass(){
	 * System.out.println("Testing before class"); }
	 */
//	BaseTest baseTest = new BaseTest();
//	protected WebDriver driver = BaseTest.driver;
	
	
//	Actions builder = new Actions(driver);

	protected enum Type {
		ID, XPATH, NAME, CSS

	}

	/**
	 * Waits for page to load until Title of page appears
	 * 
	 * @param Title
	 */
	public void waitfortitleandvalidate(String Title) {
//	public String waitfortitleandvalidate(String Title){
		for (int second = 0;; second++) {

			if (second >= Timeout / 1000)
				try {
					throw new Exception("timedout");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			// If results have been returned.
			if ((!driver.getTitle().isEmpty()) && driver.getTitle().equals(Title)) {
//				Reporter.log("Title : "+driver.getTitle()+"     Displayed successfully");
				Reporter.report(driver, driver.getTitle(), Title);
				System.out.println("Title displayed successfully");
				break;
			} else {
				try {
					Thread.sleep(1000);
					System.out.println(
							"System is waiting for the Expected Title :" + Title + " from " + second + "seconds");
					// System.out.println("Title seems to be changed, Actual Title :
					// "+driver.getTitle());
					System.out.println("Actual Title : " + driver.getTitle());
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					Reporter.report(driver, driver.getTitle(), Title);
					System.out.println("Title seems to be changed, Actual Title : " + driver.getTitle());
				}

			}
		}

//		return "just passing";
	}

	/**
	 * Waits for Text field to appear --> Clears the TextField --> Enters given text
	 * "TextValue" in the Text field --> Get the value from Text field and validate
	 * the same with the entered text.
	 * 
	 * @param by
	 * @param ElementName
	 * @param TextValue
	 */
	public void TextFieldTypeNValidate2(By by, String ElementName, String TextValue) {
		waitforelemby(by, ElementName);
//		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(TextValue);
		// System.out.println("Entered value
		// :"+driver.findElement(by).getAttribute("value"));
		if (driver.findElement(by).getAttribute("value").contains(TextValue)) {
//			Reporter.log("Value = " +TextValue+ " is entered successfully in Textfield : "+ElementName);
			Reporter.report(TextValue + " is entered successfully into " + ElementName);
		} else {
//			System.out.println("Value = " +TextValue+" is not entered properly in Textfield : "+ElementName);
			Reporter.report(TextValue + " is not entered properly into " + ElementName);
		}
	}

	public void waitforelemby(By by, String ElementName) {

		for (int second = 0;; second++) {

			if (second >= Timeout / 1000)
				throw new NoSuchElementException("timedout");

			// If results have been returned.
			if (isElementPresent(by)) {
				System.out.println("Element :" + ElementName + " found with in the Time");
				break;
			} else {
				try {
					Thread.sleep(1000);
					System.out.println(
							"System is waiting for the element :" + ElementName + " from " + second + "seconds");
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}

	// To verify the element presence
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void maximizethewindow() {
		driver.manage().window().maximize();
	}

	public void focustoframes(String OuterFrame, String InnerFrame) {
//		System.out.println("Focussing on two frames...");
		driver.switchTo().frame(OuterFrame).switchTo().frame(InnerFrame);
	}

	public void focustoframes(String Frame) {
//		System.out.println("Focussing on a frame...");
		driver.switchTo().frame(Frame);
	}

	public void mouseleftclick(int noofleftclicks) throws AWTException {
		for (int i = 0; i < noofleftclicks; i++) {
			new Robot().mousePress(InputEvent.BUTTON1_DOWN_MASK);
			new Robot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		}
	}

	public void MouseMove(int X_coord, int Y_coord) throws AWTException {
		new Robot().mouseMove(X_coord, Y_coord);
	}

	public void openAutoit() {
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec("C://Program Files//AutoIt3//AutoIt3.exe");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void crossingMultipleFrames() {
//		System.out.println("Focussing on Multiple Frames...");
		outofframes();
		focustoframes("servletBridgeIframe");

		// Assume driver is initialized properly.
		List<WebElement> ele = driver.findElements(By.tagName("iframe"));
		// System.out.println("Number of frames in a page :" + ele.size());

		int elementIndex = 6;
		WebElement matchedElement = null;
		for (int i = 1; i <= ele.size(); i++) {
			// Returns the Id of a frame.
			WebElement el = ele.get(i - 1);
			// System.out.println("Frame Id :" + el.getAttribute("id"));
			if (elementIndex == i) {
				matchedElement = el;
			}
		}

		// System.out.println("Matched Element :"+matchedElement);

		driver.switchTo().frame(matchedElement);

		focustoframes("webiViewFrame");

	}

	public void numberoftabs(int tabscount) throws AWTException {
		Robot preskey = new Robot();

		for (int i = 0; i < tabscount; i++) {
			preskey.keyPress(KeyEvent.VK_TAB);
			preskey.keyRelease(KeyEvent.VK_TAB);

		}
	}

	public void hitenter() throws AWTException {
		Robot preskey = new Robot();
		preskey.keyPress(KeyEvent.VK_ENTER);
		preskey.keyRelease(KeyEvent.VK_ENTER);
	}

	public void TextFieldTypeNValidate(By by, String ElementName, String TextValue) {
		waitforelemby(by, ElementName);
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(TextValue);
//		System.out.println("Entered value :"+driver.findElement(by).getAttribute("value"));
		if (driver.findElement(by).getAttribute("value").contains(TextValue)) {
			System.out.println("Value = " + TextValue + " is entered successfully in Textfield : " + ElementName);
		} else {
			System.out.println("Value = " + TextValue + " is not entered properly in Textfield : " + ElementName);
		}
	}

	public void highlightElement(WebElement element) {
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: yellow; border: 2px solid blue;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	}

	// To double click on an element
	public void doubleClick(WebElement Element) {
		Actions action = new Actions(driver);
		action.doubleClick(Element);
		action.perform();
	}

	
//	  public void hover(By by){
//	  
//	  builder.moveToElement(driver.findElement(by)).build().perform(); }
//	  
//	  public void hovernclick(By hoverelement, By clickelement) {
//	  hover(hoverelement);
//	  builder.moveToElement(driver.findElement(clickelement)).click().build().
//	  perform();
//	  
//	  }
	 

	protected void Maximizethewindow() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(java.awt.event.KeyEvent.VK_ALT);
		rb.keyPress(java.awt.event.KeyEvent.VK_SPACE);
		rb.keyPress(java.awt.event.KeyEvent.VK_X);

		rb.keyRelease(java.awt.event.KeyEvent.VK_X);
		rb.keyRelease(java.awt.event.KeyEvent.VK_SPACE);
		rb.keyRelease(java.awt.event.KeyEvent.VK_ALT);
	}

	public void windowhandle() throws AWTException {
		System.out.println("Count of windows : " + driver.getWindowHandles().size());
		String master = driver.getWindowHandle();
		System.out.println("Master value : " + master);
		Set<String> strlist = driver.getWindowHandles();

		for (String handle : strlist) {
			System.out.println("handle :" + handle);
			if (!handle.equals(master)) {
				driver.switchTo().window(handle);
				Maximizethewindow();
			}
		}
	}

	public void outofframes() {
//		System.out.println("Moving out of Frames...");
		driver.switchTo().defaultContent();
	}

	public void waitForElementBy(By by, String ElementName) {

		for (int second = 0;; second++) {

			if (second >= Timeout / 1000)
				throw new NoSuchElementException("timedout");

			// If results have been returned.
			if (isElementPresent(by)) {
				System.out.println("Element :" + ElementName + " found with in the Time");
				break;
			} else {
				try {
					Thread.sleep(1000);
					System.out.println(
							"System is waiting for the element :" + ElementName + " from " + second + "seconds");
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}

	public static String getCurrentDatenTime(String format) {
		Calendar cal = Calendar.getInstance();
//	cc = cal;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(cal.getTime());
	}

	/*
	 * // To verify the element presence public boolean isElementPresent(By by) {
	 * try { driver.findElement(by); return true; } catch (NoSuchElementException e)
	 * { return false; }
	 * 
	 * }
	 */

}
