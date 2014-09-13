package com.linkedin.init;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.linkedin.cases.CreateNewAccount;
import com.linkedin.pages.CreateNewAccount_Verification;
import com.linkedin.pages.indexpages.CreateNewAccount_IndexPage;


/**
 * Selenium class Initialization
 * 
 * 
 */

// @Listeners(ATUReportsListener.class)
public class SeleniumInit implements ILoggerStatus {

	/* Minimum requirement for test configuration */

	protected String testUrl; // Test url
	protected String seleniumHub; // Selenium hub IP
	protected String seleniumHubPort; // Selenium hub port
	protected String targetBrowser; // Target browser
	protected static String test_data_folder_path = null;

	String userName = "";
	String password = "";
	// screen-shot folder
	protected static String screenshot_folder_path = null;
	public static String currentTest; // current running test

	protected static Logger logger = Logger.getLogger("testing");

	protected WebDriver driver;

	Common common = new Common(driver);

	/* Page's declaration */

	protected CreateNewAccount_IndexPage CreateNewAccount_IndexPage;
	protected CreateNewAccount_Verification CreateNewAccount_Verification;
	protected CreateNewAccount CreateNewAccount;

	/**
	 * Fetches suite-configuration from XML suite file.
	 * 
	 * @param testContext
	 */
	

	
	@BeforeTest(alwaysRun = true)
	public void fetchSuiteConfiguration(ITestContext testContext) {
		


		System.out
				.println("--------------------------in fetch config--------------------------");
		testUrl = testContext.getCurrentXmlTest().getParameter("selenium.url");

		System.out.println("=======================" + testUrl
				+ "=======================\n");

		seleniumHub = testContext.getCurrentXmlTest().getParameter(
				"selenium.host");

		seleniumHubPort = testContext.getCurrentXmlTest().getParameter(
				"selenium.port");

		targetBrowser = testContext.getCurrentXmlTest().getParameter(
				"selenium.browser");
		
		
			

	}
	

	// new code====

	/**
	 * WebDriver initialization
	 * 
	 * @return WebDriver object
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method) throws IOException, InterruptedException {

		/*
		 * Runtime runtime = Runtime.getRuntime(); runtime.exec(
		 * "java -jar V:\\testing\\selenium-java-2.40.0\\selenium-2.40.0\\selenium-server-standalone-2.33.0.jar -role hub"
		 * );
		 * System.out.println("==================Server started================="
		 * ); Thread.sleep(2000);
		 * 
		 * 
		 * Runtime runtime2 = Runtime.getRuntime(); runtime2.exec(
		 * "java -jar V:\\testing\\selenium-java-2.40.0\\selenium-2.40.0\\selenium-server-standalone-2.33.0.jar -role node -port 5554"
		 * ); System.out.println(
		 * "=======================Node started====================");
		 * Thread.sleep(2000);
		 */
		currentTest = method.getName(); // get Name of current test.

		
		
		 
		 
		URL remote_grid = new URL("http://" + seleniumHub + ":"
				+ seleniumHubPort + "/wd/hub");

		String SCREENSHOT_FOLDER_NAME = "screenshots";
		String TESTDATA_FOLDER_NAME = "test_data";

		test_data_folder_path = new File(TESTDATA_FOLDER_NAME)
				.getAbsolutePath();

		screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME)
				.getAbsolutePath();

		DesiredCapabilities capability = null;
		if (targetBrowser == null || targetBrowser.contains("firefox")) {

			FirefoxProfile profile = new FirefoxProfile();

//			Proxy proxy = new Proxy();
//			proxy.setNoProxy("ipms.ppadb.gov.in");
//			proxy.setNoProxy("127.0.0.1");
//			proxy.setNoProxy("localhost");
//			profile.setPreference("dom.max_chrome_script_run_time", "999");
//			profile.setPreference("dom.max_script_run_time", "999");
//			profile.setPreference("browser.download.folderList", 2);
//			profile.setPreference("browser.download.useDownloadDir", true);
//			profile.setPreference("browser.download.manager.showWhenStarting",
//					false);
			profile.setEnableNativeEvents(true);
			profile.setPreference("network.http.use-cache", false);
			
		/*	
		   	File file = new File("C:/Users/Viral/Downloads/firebug-1.8.4.xpi");
			  
			   profile.addExtension(file);
			   profile.setPreference("extensions.firebug.currentVersion", "1.8.4"); // Avoid startup screen
			*/
			
			capability = DesiredCapabilities.firefox();
			capability.setJavascriptEnabled(true);
			capability.setCapability(FirefoxDriver.PROFILE, profile);

			System.out.println("===========firefox browser===========");
		} else if (targetBrowser.contains("ie8")) {

			capability = DesiredCapabilities.internetExplorer();
			capability.setPlatform(Platform.ANY);
			capability.setBrowserName("internet explorer");
			// capability.setVersion("8.0");
			capability
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			capability.setCapability(
					CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
					true);
			capability.setJavascriptEnabled(true);
		} else if (targetBrowser.contains("chrome")) {

			capability = DesiredCapabilities.chrome();
			System.setProperty("webdriver.chrome.driver",
					"C:\\chromedriver.exe");
			// driver = new RemoteWebDriver(new
			// URL("http://localhost:4444/wd/hub"), capability);
			capability.setBrowserName("chrome");
			capability.setJavascriptEnabled(true);

		} else if (targetBrowser.contains("ie9")) {
			capability = DesiredCapabilities.internetExplorer();
			capability.setBrowserName("internet explorer");
			capability
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			capability.setCapability(
					CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
					true);
			capability.setJavascriptEnabled(true);
		} else if (targetBrowser.contains("safari")) {

			// System.setProperty("webdriver.safari.driver","/Users/jesus/Desktop/SafariDriver.safariextz");
			// driver = new SafariDriver();
			SafariDriver profile = new SafariDriver();

			capability = DesiredCapabilities.safari();

			capability.setJavascriptEnabled(true);
			capability.setBrowserName("safari");
			// //capability.setCapability(SafariDriver.CLEAN_SESSION_CAPABILITY,
			// profile);
			this.driver = new SafariDriver(capability);
		}else if (targetBrowser.contains("saucelab")) {
			
			System.out.println("===========sauceLab browser===========");
			   
			   FirefoxProfile profile = new FirefoxProfile();

			   //Proxy proxy = new Proxy();
			   //proxy.setNoProxy("ipms.ppadb.co.bw");

			   profile.setPreference("dom.max_chrome_script_run_time", "999");
			   profile.setPreference("dom.max_script_run_time", "999");
			   profile.setPreference("browser.download.folderList", 2);
			   profile.setPreference("browser.download.useDownloadDir", true);
			   profile.setPreference("browser.download.manager.showWhenStarting",false);
			   profile.setEnableNativeEvents(true);
			   profile.setPreference("network.http.use-cache", false);
			   //profile.setEnableNativeEvents(true);
			   
			/*
			   profile.setProxyPreferences(proxy);
			   
			*/
		        capability = DesiredCapabilities.firefox();
		        capability.setCapability("version", "31");
		        capability.setCapability("platform", Platform.WIN8);
		        
			  }


		
		
	
		
	//Saucelab URL: 	"http://rahul_0502:9639b07a-02f3-43cb-821a-d340d05f9fa2@ondemand.saucelabs.com:80/wd/hub"
			
		//driver = new RemoteWebDriver(
        //        new URL("http://rahul_0502:9639b07a-02f3-43cb-821a-d340d05f9fa2@ondemand.saucelabs.com:80/wd/hub"),
         //       capability);
			driver = new RemoteWebDriver(remote_grid,capability);

		driver.get(testUrl);
		driver.manage().window().maximize();
		

		// CreateNewAccount = new CreateNewAccount(driver);
		CreateNewAccount_IndexPage = new CreateNewAccount_IndexPage(driver);
		CreateNewAccount_Verification = new CreateNewAccount_Verification(
				driver);

	}

	/**
	 * After Method
	 * 
	 * @param testResult
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) {
		try {

			String testName = testResult.getName();
			

			if (!testResult.isSuccess()) {

				/* Print test result to Jenkins Console */
				System.out.println();
				System.out.println("TEST FAILED - " + testName);
				System.out.println();
				System.out.println("ERROR MESSAGE: "
						+ testResult.getThrowable());
				System.out.println("\n");
				Reporter.setCurrentTestResult(testResult);

				/* Make a screenshot for test that failed */
				String screenshotName = common.getCurrentTimeStampString()
						+ testName;
				Reporter.log("<br> <b>Please look to the screenshot - </b>");
				common.makeScreenshot(driver, screenshotName);

			} else {
				System.out.println("TEST PASSED - " + testName + "\n"); // Print
																		// test
																		// result
																		// to
																		// Jenkins
																		// Console

			}

			driver.manage().deleteAllCookies();
			driver.quit();

		} catch (Throwable throwable) {
			System.out.println("message from tear down"
					+ throwable.getMessage());
		}
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
