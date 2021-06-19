/**
 * 
 */
package com.simplogics.base;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.simplogics.utilities.ExcelReader;



/**
 * @author Aswathy
 *
 */
public class BaseData extends Email {
	// again test2
	/*
	 * WebDriver - done Properties - done Logs - log4j jar, .log, log4j.properties,
	 * Logger ExtentReports DB Excel Mail ReportNG, ExtentReports Jenkins
	 *
	 */
	public static WebDriver driver;
	public static ChromeOptions options;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/Files/excel/testdata.xlsx");
	public static WebDriverWait wait;
	// public ExtentReports rep = ExtentManager.getInstance();
	// public static ExtentTest test;
	public static String browser;
	public WebElement cell;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	

	@BeforeMethod(alwaysRun = true)
	public void setReport() throws EmailException {
		// System.out.println("running before test.....");

		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/target/surefire-reports/html/TestResult.html");
		htmlReporter.setAppendExisting(true);// works only for aventstack 3.1.5 dependency and relevantcodes 2.41.2
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Minni S Thottumkal");
		extent.setSystemInfo("Orgainzation", "Simplogics");
		//extent = new ExtentReports(filepath,true, DisplayOrder.OLDEST_FIRST, NetworkMode.ONLINE);

	}

	@BeforeMethod
	// @BeforeSuite
	public void setUp() {
		//BasicConfigurator.configure();
		
		if (driver == null) {
			try {
				// test = new ExtentTest("Demo", "");
				fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				 log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.setProperty("webdriver.chrome.logfile",
					"/home/appus/eclipse-workspace/Test_New/Atidee/target/surefire-reports/html/ResultLog.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			//String log4jConfPath = "/home/appus/eclipse-workspace/Atidee/src/test/resources/log4j.properties";
			//PropertyConfigurator.configure("log4j.properties");
			
			//System.setProperty("org.freemarker.loggerLibrary", "none");
			//PropertyConfigurator.configure(BaseData.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "log4j.properties");
			
			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");
			} else {

				browser = config.getProperty("browser");

			}

			config.setProperty("browser", browser);

			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/src/test/Files/executables/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/test/Files/executables/chromedriver");
				options = new ChromeOptions();
				options.setHeadless(true);
				driver = new ChromeDriver(options);
				//driver=new ChromeDriver();
				log.debug("Chrome Launched !!!");
			} else if (config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "/src/test/Files/executables/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.get(config.getProperty("testsiteurl"));
			 log.debug("Navigated to : " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);
		}
	}

	public void click(String locator) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_linkText")) {
			driver.findElement(By.linkText(OR.getProperty(locator))).click();
		}
		// test.log(Status.INFO, "Clicking on : " + locator);
	}

	public void type(String locator, String value) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
		test.log(Status.INFO, "Typing in : " + locator + " entered value as " + value);
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void verifyEquals(String expected, String actual) throws IOException {

		assertEquals(expected, actual);

	}

	public static void verifypageurl(String expectedurl) {
		String currenturl = driver.getCurrentUrl();
		assertEquals(currenturl, expectedurl);

	}

	
	public static void Asserttoast(String expectedtoast, String locator) {
		if (locator.endsWith("_CSS")) {
			String appearedtoast = driver.findElement(By.cssSelector(OR.getProperty(locator))).getText();
			assertEquals(appearedtoast, expectedtoast);
		} else if (locator.endsWith("_XPATH")) {
			String appearedtoast = driver.findElement(By.xpath(OR.getProperty(locator))).getText();
			assertEquals(appearedtoast, expectedtoast);
		} else if (locator.endsWith("_ID")) {
			String appearedtoast = driver.findElement(By.id(OR.getProperty(locator))).getText();
			assertEquals(appearedtoast, expectedtoast);
		} else if (locator.endsWith("_linkText")) {
			String appearedtoast = driver.findElement(By.linkText(OR.getProperty(locator))).getText();
			assertEquals(appearedtoast, expectedtoast);
		}

	}

	public void clearthetextboxfield(String locator) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).clear();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).clear();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).clear();
		}
	}

	public WebElement searchcompany() throws InterruptedException {

		Thread.sleep(5000);
		WebElement table = driver.findElement(By.cssSelector(OR.getProperty("Table_CSS")));
		List<WebElement> allRows = table.findElements(By.cssSelector(OR.getProperty("All_Rows_CSS")));
		for (int i = 0; i < allRows.size(); i++) {
			WebElement row;
			row = allRows.get(i);
			// System.out.println(row.getText());
			List<WebElement> cells = row.findElements(By.cssSelector(OR.getProperty("All_coloumns_CSS")));// header
			for (int j = 0; j < cells.size();) {
				cell = cells.get(j);
				//System.out.println(cell.getText());
				return cell;
				

			}
	
		}
		return null;
	}

	public WebElement searchuser() throws InterruptedException {
		Thread.sleep(5000);
		WebElement table = driver.findElement(By.cssSelector(OR.getProperty("Tableuser_CSS")));
		List<WebElement> allRows = table.findElements(By.cssSelector(OR.getProperty("All_Rows_CSS")));
		for (int i = 0; i < allRows.size(); i++) {
			WebElement row;
			row = allRows.get(i);
			// System.out.println(row.getText());
			List<WebElement> cells = row.findElements(By.cssSelector(OR.getProperty("All_coloumns_CSS")));// header
			for (int j = 0; j < cells.size();) {
				cell = cells.get(j);
				return cell;

			}
		}
		return null;
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		if (test != null) {

			if (result.getStatus() == ITestResult.FAILURE) {
				test.log(Status.FAIL, "Testcase failed : " + result.getName());

				test.log(Status.FAIL, "Testcase failed : " + result.getThrowable());
				test.fail("Please check the below Screenshot :",
						MediaEntityBuilder.createScreenCaptureFromBase64String(getbase64()).build());

			} else if (result.getStatus() == ITestResult.SKIP) {
				test.log(Status.SKIP, "Testcase skipped :" + result.getName());
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(Status.PASS, "Testcase success : " + result.getName());
			

			}
		}
		extent.flush();

	}

	public String getbase64() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

	}

	@AfterTest
	public static void Emailsend() throws EmailException {
		email();
		File f= new File("/home/appus/eclipse-workspace/Test_New/Atidee/target/surefire-reports/html/TestResult.html");
		f.delete();
		 log.debug("test execution completed !!!");
	}

}
