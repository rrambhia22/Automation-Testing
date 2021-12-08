package com.yatra.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtility {
	// Convert web driver object to TakeScreenshot
	private WebDriver driver;

	public void takeScreenShot(WebDriver driver, String fileWithPath) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		
		System.out.println("====================================================");
		System.out.println("!!!!!!!!ERROR!!!!!!!!");
		System.out.println("Screenshot Path: "+fileWithPath);
		System.out.println("====================================================");
		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);
	}

}
