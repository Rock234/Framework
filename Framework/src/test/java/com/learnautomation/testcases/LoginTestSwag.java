package com.learnautomation.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;

public class LoginTestSwag extends BaseClass{
	

	
	@Test
	public void loginApp() {
		
		
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage.logintoSwag(data.getStringData("Login", 0, 0), data.getStringData("Login", 0, 1));
		
		
		
	}

}
