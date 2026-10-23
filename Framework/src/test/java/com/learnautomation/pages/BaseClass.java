package com.learnautomation.pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.aventstack.chaintest.service.ChainPluginService;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;


@Listeners(ChainTestListener.class)
public class BaseClass {
	

	
	public WebDriver driver; 
	public ExcelDataProvider data;
	public ConfigProvider config;
	
	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log(" Test Started >>");
		
		data = new ExcelDataProvider();
		config = new ConfigProvider();
	}
	@BeforeClass
	public void setup() {
		
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
	}
	
	
	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(driver);
		
		
	}
	
	
	
	@AfterMethod
	public void teardownMethod(ITestResult result, String message) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
				
			//Helper.captureScreenhot(driver); 
	        
	        // Embed directly to ChainTest
//			
//			ChainTestListener.embed(Helper.captureScreenhot(driver),"image/png");
//	        ChainTestListener.log(message);
			if (!result.isSuccess()) {
	            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            ChainTestListener.embed(screenshotBytes, "image/png");
	            ChainTestListener.log(message);
	        }
		}
		
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
//			ChainTestListener.embed(Helper.captureScreenhot(driver),"image/png");
//	        ChainTestListener.log(message);
			
			if (result.isSuccess()) {
	            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            ChainTestListener.embed(screenshotBytes, "image/png");
	            ChainTestListener.log(message);
	        }
		}
		
	}
	
//	@AfterMethod
//	public void logStep(String message) {
//		ChainTestListener.log(message);
//    }

}
