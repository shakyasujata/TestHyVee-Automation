package com.hyvee.testcase;

import org.testng.annotations.Test;

import com.hyvee.base.DriverScript;
import com.hyvee.pages.HomePage;

public class HomePage_TC001 extends DriverScript {
	
	public HomePage_TC001(){
		super();
	}
	
	HomePage hp = new HomePage();

	@Test(enabled=false)
	public void testHomePageLogin(){
		initBrowser();
		hp.sujataIsCLickingLoginButtonInHomePage();
	}
}
