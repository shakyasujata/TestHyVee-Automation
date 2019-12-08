package com.hyvee.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hyvee.base.DriverScript;
import com.hyvee.helper.Utils;

public class HomePage extends DriverScript {

	
	//****************************** Objects Identification ***************************************************//	
	
			@FindBy(xpath="//a[@class='login-button']") WebElement loginBtn;
			
		//****************************** Page/Object Initialization ********************************************* //
			
			public HomePage()
			{
				PageFactory.initElements(driver, this);
			}
			
		//********************************* Actions / Methods *************************************************** //
		
			public void sujataIsCLickingLoginButtonInHomePage(){
				System.out.println("I am inside sujataIsCLickingLoginButtonInHomePage : Title is " + driver.getTitle());
				//Utils.highLightElement(loginBtn);
				//loginBtn.click();
				
			}
}
