package com.hyvee.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hyvee.base.DriverScript;

public class LoginPage extends DriverScript{

	
	//****************************** Objects Identification ***************************************************//	
	
		@FindBy(id="username") WebElement usernameTb;
		@FindBy(id="password") WebElement passwordTb;
		@FindBy(xpath="//button[@class='button__BaseButton-sc-5cxqrk-0 button__StyledButton-sc-5cxqrk-1 kcfLfl ActionButton-sc-13bwskt-0 kaVLWM']") WebElement loginBtn;
		@FindBy(xpath="//span[contains(text(),'Show')]") WebElement showPwdBtn;
		@FindBy(xpath="//li[contains(text(),'The username/password you have entered is incorrec')]") WebElement errorMessage;
		
		
	//****************************** Page/Object Initialization ********************************************* //
		
		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		}
		
	//********************************* Actions / Methods *************************************************** //
		
		public void validateLogin(String username, String password){
			usernameTb.sendKeys(username);
			passwordTb.sendKeys(password);
			loginBtn.click();
			driver.get("https://www.hy-vee.com");
		}
		
		public void showPasswordWhenClicked(){
			
		}
		
		public void rememberMe(){
			
		}
		
		public void forgotPassword(){
			
		}
		
		public String getErrorMessge(){
			return errorMessage.getText();			
		}
}
