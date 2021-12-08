package com.booking.test;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.yatra.pages.SelectFlight;
import com.yatra.utils.ReadExcel;
import com.yatra.utils.ReadObject;
import com.yatra.ExtentReportListener.CustomListener;
import com.yatra.base.TestBase;
import com.yatra.utils.UIOperation;

@Listeners(CustomListener.class)  // to make this listen to lsiterner , it is static
public class OneWayTripTest extends TestBase {  

	SelectFlight selectFlight;

	TestBase testBase;

	@Test(dataProvider = "hybridData")
	public void OneWayTripSearchTest(String testcaseName, String keyword, String objectName, String indexValue,
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
			initialization();// since we are extending testbase no need for object creation
			
		}
		UIOperation operation = new UIOperation(driver);
		// Call perform function to perform operation on UI
		operation.perform(allObjects, keyword, objectName, indexValue, objectType, value);
		Thread.sleep(1000);

	}

	@DataProvider(name = "hybridData")
	public Object[][] getDataFromDataprovider() throws IOException {
		ReadExcel read = new ReadExcel();
		Object[][] objects = read.getData("TestCaseOneWay.xlsx", "KeywordFramework");
		return objects;
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
	}
}
