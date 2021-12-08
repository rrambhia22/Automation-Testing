package com.yatra.utils;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

public class ResultCompare {
	public ResultCompare(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;

	public void verifyResults(String objectName, String objectType, String indexValue, String value) throws Exception {

		// verifying city search result
		if (objectName.equals("citySearch")) {
			int s = driver.findElements(this.getObject(objectName, objectType, indexValue, value)).size();
			if (s == 1) {
				Assert.assertTrue(false);
			}
		}
		// verifying search button functionality
		else if (objectName.equals("selectSearch")) {
			Thread.sleep(2000);
			// System.out.println(driver.getCurrentUrl().toString());
			Assert.assertNotEquals(driver.getCurrentUrl().toString(), "https://www.yatra.com/");
		}

		// testing for no flights found
		else if (objectName.equals("noFlights")) {
			Thread.sleep(3000);
			Assert.assertFalse(
					driver.findElement(this.getObject(objectName, objectType, indexValue, value)).isDisplayed());
		}
		// checking if apply filters button is enabled or not
		else if (objectName.equals("applyFiltersButtonCheck")) {
			Assert.assertFalse(
					driver.findElement(this.getObject(objectName, objectType, indexValue, value)).isDisplayed());
		}
		// proceed to payment button check
		else if (objectName.equals("proceedToPaymentButtonCheck")) {
			Thread.sleep(3000);
			Assert.assertEquals(driver.getCurrentUrl().toString(), "https://secure.yatra.com/PaySwift/payment");
		}
		// validating login process
		else if (objectName.equals("searchFlight")) {

			Assert.assertTrue(
					driver.findElement(this.getObject(objectName, objectType, indexValue, value)).isDisplayed());
		}
		// invalid login validation
		else if (objectName.equals("errorMsg")) {
			Assert.assertFalse(
					driver.findElement(this.getObject(objectName, objectType, indexValue, value)).isDisplayed());
		}
		// invalid login using 0TP test
		else if (objectName.equals("invalid_OTP_Msg")) {

			Assert.assertFalse(
					driver.findElement(this.getObject(objectName, objectType, indexValue, value)).isDisplayed());
		}
		// Invalid Mobile Number test
		else if (objectName.equals("invalid_MobMsg")) {
			Assert.assertFalse(
					driver.findElement(this.getObject(objectName, objectType, indexValue, value)).isDisplayed());

		}
		// password error message test
		else if (objectName.equals("invalid_PassMsg"))// Password must be atleast 8 char message
		{
			Assert.assertFalse(
					driver.findElement(this.getObject(objectName, objectType, indexValue, value)).isDisplayed());
		}

	}

	public By getObject(String objectName, String objectType, String indexValue, String value) throws Exception {
		Method testMethod = LocatorFetcher.class.getMethod(objectName, String.class, String.class);

		String result = testMethod.invoke(new LocatorFetcher(), indexValue, value).toString();
		if (objectType.equalsIgnoreCase("XPATH")) {
			// Find by xpath
			return By.xpath(result);
		}
		// find by class
		else if (objectType.equalsIgnoreCase("CLASSNAME")) {
			return By.className(result);
		}
		// find by name
		else if (objectType.equalsIgnoreCase("NAME")) {
			return By.name(result);
		}
		// Find by css
		else if (objectType.equalsIgnoreCase("CSS")) {

			return By.cssSelector(result);

		}
		// find by link
		else if (objectType.equalsIgnoreCase("LINK")) {

			return By.linkText(result);
		}
		// find by partial link
		else if (objectType.equalsIgnoreCase("PARTIALLINK")) {

			return By.partialLinkText(result);

		} else {
			throw new Exception("Wrong object type");
		}
	}
}
