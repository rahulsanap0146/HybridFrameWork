package com.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertiesUtility;
import com.utility.WaitUtility;

public class BaseClass {
	public static Logger log=Logger.getLogger(BaseClass.class);
	public PropertiesUtility pu=null;
	public WaitUtility wu=null;
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	
	
	@BeforeSuite
	public void SetUp(){
		log.info("Initializing Browser");
		pu= new PropertiesUtility();
		String browser= pu.readProperty("brower");
		log.info(browser+" browswe is intitalized");
		wu= new WaitUtility();
		if(pu.readProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", pu.readProperty("chromeDriverPath"));
			driver= new ChromeDriver();
		}
		if(pu.readProperty("browser").equals("Firefox")){
			System.setProperty("webdriver.gecko.driver",pu.readProperty("geckoDriverPath"));
			driver= new FirefoxDriver();
		}
		log.info("maximising browser window");
		driver.manage().window().maximize();
		driver.get(pu.readProperty("url"));
		log.info("Applying common waits over a browser");
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(pu.readProperty("pageload")),TimeUnit.SECONDS);
	}
	
	public void reportInit(){
		spark= new ExtentSparkReporter(System.getProperty("user.dir")+"/target/Reports/ExtentReport.html");
		report= new ExtentReports();
		report.setSystemInfo("Host Name","Rahul Sanap");
		report.setSystemInfo("Platform","Windows");
		report.setSystemInfo("Enviorment","Test Automation");
		report.attachReporter(spark);
	}
	@AfterSuite
	public void tearDown(){
		driver.close();
	}
	
}
