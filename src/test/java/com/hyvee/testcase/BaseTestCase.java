package com.hyvee.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hyvee.base.DriverScript;
import com.hyvee.pages.LoginPage;

public class BaseTestCase extends DriverScript {
	public ExtentReports extent;
	public ExtentTest logger;
	LoginPage loginPage;
	
	public BaseTestCase(){
		super();
	}
	
	@BeforeClass
	public void reportSetup()
	{
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("./Hy-vee.Reports/AutomationReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
	}
	
	@BeforeMethod
	public void setUp(){
		
		initBrowser();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
		extent.flush();
	}
}
