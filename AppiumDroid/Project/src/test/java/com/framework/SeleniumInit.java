package com.framework;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.demo.CalculatorApp;
import com.pages.IndexPage;
import com.verification.VerificationPage;


/**
 * Selenium class Initialization
 * 
 * 
 */

// @Listeners(ATUReportsListener.class)
public class SeleniumInit {

	/* Minimum requirement for test configuration */

	//protected static Logger logger = Logger.getLogger("testing");

	protected WebDriver driver;

	Common common = new Common(driver);
	
	protected String platformName; // Platform Name : Android (default)
	protected String deviceName; // Device Name : Appium (default)


	/* Page's declaration */

	protected CalculatorApp calcApp;
	protected IndexPage indexpage;
	protected VerificationPage verifictionpage;
	
	
	// new code====

	/**
	 * WebDriver initialization
	 * 
	 * @return WebDriver object
	 * @throws MalformedURLException 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@BeforeClass(alwaysRun = true)
	 public void setup(ITestContext testContext) throws MalformedURLException {
		
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		
		  platformName = testContext.getCurrentXmlTest().getParameter("platform.Name");
		  deviceName = testContext.getCurrentXmlTest().getParameter("device.Name");
		  
		
	     
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  
		  System.out.println("=====================  Android Starting..  =====================");
		  
		  capabilities.setCapability("device","Android");  //Selected Device : Android
		  capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android"); //Browser Name : Empty
		  capabilities.setCapability(CapabilityType.VERSION, "4.2.2"); // Browser Version : Android Version
		  capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS"); // Platform : Windows
		  capabilities.setCapability("platformName",platformName);
		  capabilities.setCapability("deviceName", deviceName);
		  
		  //capabilities.setCapability("app", "hgs"); 
		  capabilities.setCapability("app-package", "com.android.calculator2"); // This is package name of your app (you can get it from apk info app)
		  capabilities.setCapability("app-activity", "com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
		 
		  //capabilities.setCapability("app-wait-activity","LoginActivity,NewAccountActivity");
		  //capabilities.setCapability("app", app.getAbsolutePath()); 
		  
		  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); 
		  // IP : 127.0.0.1 Port : 4723
		  
		  driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);  
		 
		  
		//calcApp = new CalculatorApp(driver);
		  indexpage = new IndexPage(driver);
		  verifictionpage = new VerificationPage(driver);
		
	  

	         }

	/**
	 * After Method
	 * 
	 * @param testResult
	 */
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		

			//driver.manage().deleteAllCookies();
			driver.quit();

	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg
	 *            Message/Log to be reported.
	 */
	public static void logMessage(String msg) {
		Reporter.log(msg + "<br/>");
	}

	public static void log(String msg, final int logger_status) {

		switch (logger_status) {

		case ILoggerStatus.NORMAL:
			Reporter.log("<br>" + msg + "</br>");
			break;

		case ILoggerStatus.ITALIC:
			log("<i>" + msg + "</i>");
			break;

		case ILoggerStatus.STRONG:
			Reporter.log("<strong>" + msg + "</br>");
			break;
		}
	}

	public static void logStatus(final int test_status) {

		switch (test_status) {

		case ITestStatus.PASSED:
			log("<font color=238E23>--Passed</font>");
			break;

		case ITestStatus.FAILED:
			log("<font color=#FF0000>--Failed</font>");
			break;

		case ITestStatus.SKIPPED:
			log("<font color=#FFFF00>--Skipped</font>");
			break;

		default:
			break;
		}

	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg
	 *            Message/Log to be reported.
	 */
	public static void log(String msg) {
		System.out
				.println("-----------------------------------------------typed in log"
						+ msg);
		Reporter.log(msg);
	}

}
