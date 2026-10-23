package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	// Helper class for taking screenshots, alert, frame,multiple windows, Sync issues, Javascript executor

	

	public static String captureScreenhot(WebDriver driver) {
		
		File src = 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenPath = System.getProperty("user.dir") + "/Screenshots/Login.png"
				+ getCurrentDateTime();		
		
		try {
			FileHandler.copy(src, new File(screenPath));
			System.out.println("Screenshot captured");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot "+ e.getMessage());
		}
		
		return screenPath;
	}
	
	public static String getCurrentDateTime() {
		
		DateFormat customFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
		
	}

//	public void handleFrame() {
//		
//		 
//		
//	}
//
//	public void HandleAlerts() {
//	
//	
//	
//}

}
