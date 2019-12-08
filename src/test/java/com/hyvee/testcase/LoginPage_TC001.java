package com.hyvee.testcase;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginPage_TC001 extends BaseTestCase {
	
	@Test
	public void testLoginWithValidUsernameAndPassword(){
		logger=extent.createTest("Test our hyvee Login page");
		logger.log(Status.INFO, "Browser Launched");
		logger.log(Status.INFO, "Navigated to the URL");
		logger.log(Status.INFO, "Input username and password and hit login button");
		loginPage.validateLogin("bajracharya.surendra@gmail.com", "hN@rendr1");
		//we can check if "Hi SURENDRA welcome message is displayed or NOT
		logger.log(Status.PASS, "Login Successfully");
		logger.log(Status.INFO, "Closed the Browser");
	}
	
	@Test
	public void testInvalidLogin(){
		logger=extent.createTest("Test our hyvee Login page with INVALID credentials");
		logger.log(Status.INFO, "Browser Launched");
		logger.log(Status.INFO, "Navigated to the URL");
		logger.log(Status.INFO, "Input INVALID username and password and hit login button");
		loginPage.validateLogin("jpt", "jpt");
		
		
		String errorMsg = loginPage.getErrorMessge();
		
		if(errorMsg.contains("The username/password you have entered is incorrect. If you already have an account, try resetting your password")){
			logger.log(Status.PASS, "Error message displayed Successfully");
			logger.log(Status.INFO, "Closed the Browser");
		}
		else{
			
			//if this code is HIT, this is good candidate to be a bug and OPEN a JIRA BUG TICKET
			//U CAN TAKE A SCREENSHOT OF THIS as well - thru SELENIUM TAKESCREEN shot code
			logger.log(Status.FAIL, "Error Message text is not correct as per requirement");
			logger.log(Status.INFO, "Closed the Browser");
		}		
	}
}
