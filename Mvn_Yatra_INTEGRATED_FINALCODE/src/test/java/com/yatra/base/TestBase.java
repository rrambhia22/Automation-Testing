package com.yatra.base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.yatra.utils.ScreenShotUtility;

public class TestBase {

	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static void initialization() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\chromedriver.exe");
	
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		driver = new ChromeDriver(ops); 
		driver.manage().window().maximize();
	}

	public void failed() throws IOException
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String dateName = formatter.format(date).replace(" ", "").replace("/", "").replace(":", "");

		ScreenShotUtility screenShotUtility = new ScreenShotUtility();
		//System.out.println(dateName);
		screenShotUtility.takeScreenShot(driver,
				(System.getProperty("user.dir") + "\\test-output\\Screenshots\\") + dateName + ".png");
	}
}
