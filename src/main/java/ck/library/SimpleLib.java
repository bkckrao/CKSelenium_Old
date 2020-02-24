package ck.library;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SimpleLib {

	
	
	int Timeout = 50000; 
	public enum Type{
		ID,
		XPATH,
		NAME,
		CSS
	/*	LINKTEXT,
		VALUE,
		IFRAME */
	}
	
	
public void waitForElementBy(By by, String ElementName) throws Exception{
		
		for (int second = 0;; second++) {

			if (second >= Timeout/1000)
				throw new Exception("timedout");

			// If results have been returned.
			if (isElementPresent(by)) {
				System.out.println("Element :"+ElementName+" found with in the Time");
				break;
			}else{			
				try {
					Thread.sleep(1000);
					System.out.println("System is waiting for the element :"+ElementName+" from "+second+"seconds");
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
				FrameLib.driver.findElement(by);
				return true;
			} catch (NoSuchElementException e) {
				return false;
			}

		}

}
