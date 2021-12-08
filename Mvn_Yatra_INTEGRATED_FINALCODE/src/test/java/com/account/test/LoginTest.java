package com.account.test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.yatra.pages.SelectFlight;
import com.yatra.utils.ReadExcel;
import com.yatra.utils.ReadObject;
import com.yatra.ExtentReportListener.CustomListener;
import com.yatra.base.TestBase;
import com.yatra.utils.UIOperation;
@Listeners(CustomListener.class)
public class LoginTest extends TestBase{

	SelectFlight selectFlight;

	TestBase testBase;
	
	@Test(dataProvider = "hybridData")
	public void multiCitySearchTest(String testcaseName, String keyword, String objectName, String indexValue,
		String objectType, String value) throws Exception {
		ReadObject object = new ReadObject();
		Properties allObjects = object.getObjectRepository();
		
		
		if (indexValue != null && indexValue.length() != 0) {
			String indexValue2 = Integer.toString((int) Double.parseDouble(indexValue));
			indexValue = indexValue2;
		}

		if (testcaseName != null && testcaseName.length() != 0) {
			if (driver != null) {
				driver.close();
			}
			initialization();
		}
			UIOperation operation = new UIOperation(driver);
			// Call perform function to perform operation on UI
			operation.perform(allObjects, keyword, objectName, indexValue, objectType, value);
			Thread.sleep(1000);
		
	}

	@DataProvider(name = "hybridData")
	public Object[][] getDataFromDataprovider() throws IOException {
		ReadExcel read = new ReadExcel();
		Object[][] objects = read.getData("Login&SignUp_TestCase.xlsx", "Login");
		return objects;
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(4000);
			driver.close();
	}
  

  
}
