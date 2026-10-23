package com.learnautomation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		
		this.driver = ldriver;
		
	}
	
	@FindBy(id = "user-name") WebElement uname;
	@FindBy(id = "password") WebElement pass;
	@FindBy(xpath = "//input[@id='login-button']") WebElement loginButton;
	
	public void logintoSwag(String usernameForApplication, String passwordForApplication) {
		
		
		try {
			Thread.sleep(Duration.ofSeconds(2));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		uname.sendKeys(usernameForApplication);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		pass.sendKeys(passwordForApplication);
		loginButton.click();
	}

}
