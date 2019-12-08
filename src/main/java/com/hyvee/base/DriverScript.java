package com.hyvee.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/*
 * Name:Sujata Shakya
 * Date Created: 12/08/2019
 * Verified By: Sujata Shakya
*/

public class DriverScript {
	static Properties prop;
	public static WebDriver driver;
	
	public DriverScript() {
		try
		{
			prop = new Properties();
			File src = new File("./Hy-vee.Configuration/config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("File Not Found "+e.getMessage());
		}
	}

	
	public static void initBrowser()
	{
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Hy-vee.BrowserExe/chromedriver");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Hy-vee.BrowserExe/geckodriver");
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("No Proper Browser Specified : Please check the Properties file");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String url = prop.getProperty("qaurl");
		driver.get(url);
	}
}
