package ck.library;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.internal.PropertiesFile;

import ck.report.Reporter;

public class BaseTest {

	public static WebDriver driver;
	
	public long Timeout = 50000;
	protected static String sUrl;
	protected static String sproject_path = System.getProperty("user.dir") ;
	protected static String sTestdata_Path;
	private static String sBrowser;
	private static String sChromeDriverPath;
	protected static String sAutoitScriptPath;
	protected static String sResumePath;
//	protected static String pathoftestdata;
	PropertiesFile pf;//  = new PropertiesFile("appp.properties");
	
//	FileReader reader = new FileReader("appp.properties");
	/*
	 * public static void testApp() throws IOException{ PropertiesFile pf = new
	 * PropertiesFile("appp.properties");
	 * 
	 * System.out.println("browser_ = "+
	 * pf.getProperties().getProperty("browser_")); }
	 */

	public BaseTest() {
		Reporter.initialize();
		try {
			pf = new PropertiesFile("app.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sUrl = pf.getProperties().getProperty("Url_");
		sBrowser = pf.getProperties().getProperty("browser_");
		sTestdata_Path = sproject_path + pf.getProperties().getProperty("testdata_Path_");
		sChromeDriverPath = sproject_path + pf.getProperties().getProperty("sChromeDriverPath_");
		sAutoitScriptPath = sproject_path + pf.getProperties().getProperty("sAutoitScriptPath_");
		sResumePath = sproject_path + pf.getProperties().getProperty("sResumePath_");
	}
	
	
	@BeforeSuite(alwaysRun = true)
	public void setupBeforeSuite(ITestContext context) throws IOException {
//		Url = context.getCurrentXmlTest().getParameter("selenium.url");
		
//		Reporter.initialize();
//		pf = new PropertiesFile("appp.properties");
//		sUrl = pf.getProperties().getProperty("Url_");
//		sBrowser = pf.getProperties().getProperty("browser_");
//		sproject_path = pf.getProperties().getProperty("sproject_path_");
//		sTestdata_Path = sproject_path + pf.getProperties().getProperty("testdata_Path_");
//		sChromeDriverPath = sproject_path + pf.getProperties().getProperty("sChromeDriverPath_");
//		sAutoitScriptPath = sproject_path + pf.getProperties().getProperty("sAutoitScriptPath_");
//		sResumePath = sproject_path + pf.getProperties().getProperty("sResumePath_");
//	  pathoftestdata = context.getCurrentXmlTest().getParameter("pathoftestdata");
		System.out.println("***before suite***");
		System.out.println("Url : " + sUrl);
		System.out.println("Browser : "+sBrowser);
		System.out.println("sChromeDriverPath : "+ sChromeDriverPath);
		System.out.println("======================");
		
		
	}

	
	
	public void openBrowser(Select_Browser browser) throws IOException {

		switch (browser) {
		case IE:
			iesetprop();
			break;
//		case IE: ieignoresecurityandsetprop(); break;
		case FF:
			openfirefoxdriver();
			break;
		case CHROME:
			Chromesetup();
			break;
		}
	}

	
	/*
	 * private static String getBrowsertag() throws IOException { pf = new
	 * PropertiesFile("appp.properties");
	 * 
	 * return pf.getProperties().getProperty("browser_");
	 * 
	 * }
	 */
	
	/**
	 * Opens the browser provided in the properties file. If not provided proper
	 * format, it will pick up the Chrome browser by default
	 */
	public void openBrowser() throws IOException {

		pf = new PropertiesFile("app.properties");

		sBrowser = pf.getProperties().getProperty("browser_");
		System.out.println("Browser : " + sBrowser);

		if(sBrowser.equalsIgnoreCase("Chrome") || sBrowser.equalsIgnoreCase("")) {
			Chromesetup();
		}else if(sBrowser.equalsIgnoreCase("ff") || sBrowser.equalsIgnoreCase("firefox")){
			openfirefoxdriver();
		}else if(sBrowser.equalsIgnoreCase("IE")) {
			iesetprop();
		}else {
			System.out.println("browser details are not properly updated in app.properties file. Browser value in Properties file is : "+ sBrowser );
		}

	}

	public enum Select_Browser {
		IE, FF, CHROME
	}

	public void iesetprop() {
		// File file = new File("C:\\softwares\\IEDriverServer\\IEDriverServer.exe");
//	File file = new File("C:\\Softwares\\IEDriverServer_Win32_2.38.0\\IEDriverServer.exe");
//	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		File file = new File("C:\\Softwares\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver(ieCapabilities);
	}

	public void ieignoresecurityandsetprop() {
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		File file = new File("C:\\Softwares\\IEDriverServer_x64_2.39.0\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver(ieCapabilities);
		sleepfor10sec();
	}

	public void openfirefoxdriver() {
		driver = new FirefoxDriver();
	}

	public void Chromesetup() {
		System.setProperty("webdriver.chrome.driver", sChromeDriverPath);
		
		driver = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-dev-shm-usage");
		options.setExperimentalOption("useAutomationExtension", false);
	}

	public void sleepfor10sec() {
		try {
			Thread.sleep(Timeout / 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void testApp() throws IOException {
		PropertiesFile pf = new PropertiesFile("app.properties");

		System.out.println("browser_ = " + pf.getProperties().getProperty("browser_"));
	}

}
