package com.yatra.utils;

import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.yatra.base.TestBase;
import com.yatra.pages.PaymentPage;
import com.yatra.pages.SelectFlight;

public class UIOperation extends TestBase{

	WebDriver driver;
	SelectFlight selectFlight;
	ScreenShotUtility screenShotUtility;
	PaymentPage paymentPage;
	PageScroller pageScroller;
	ResultCompare resultCompare;

	public UIOperation(WebDriver driver) {
		this.driver = driver;
	}

	public void perform(Properties p, String operation, String objectName, String indexValue, String objectType,
			String value) throws Exception {
			// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("");
			switch (operation.toUpperCase()) {
			case "CLICK":
				// Perform click
				Assert.assertTrue(
						driver.findElement(this.getObject(objectName, objectType, indexValue, value)).isEnabled());
				driver.findElement(this.getObject(objectName, objectType, indexValue, value)).click();
				// Thread.sleep(1000);
				break;
			case "SETTEXT":
				// Set text on control
				driver.findElement(this.getObject(objectName, objectType, indexValue, value)).sendKeys(value);
				// Thread.sleep(1000);
				break;

			case "GOTOURL":
				// Get url of application
				driver.get(p.getProperty(value));
				// Thread.sleep(1000);
				break;
			case "GETTEXT":
				// Get text of an element
				driver.findElement(this.getObject(objectName, objectType, indexValue, value)).getText();
				// Thread.sleep(1000);
				break;

			case "ARROWDOWN":
				// Get text of an element
				driver.findElement(this.getObject(objectName, objectType, indexValue, value)).sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(1000);
				break;

			case "ENTER":
				// Get text of an element
				driver.findElement(this.getObject(objectName, objectType, indexValue, value)).sendKeys(Keys.ENTER);
				// Thread.sleep(1000);
				break;

			case "DATE":
				// Perform click
				objectName = "//*[@id = '" + value + "']";
				driver.findElement(By.xpath(objectName)).click();
				// Thread.sleep(1000);
				break;

			case "SELECTFLIGHT":
				selectFlight = new SelectFlight(driver);
				selectFlight.multiCity();
				break;

			case "PAYMENTPAGE":
				paymentPage = new PaymentPage(driver);
				paymentPage.checkStatus();
				break;

			case "SLEEP":
				Thread.sleep(2000);
				break;

			case "PAGESCROLLER":
				pageScroller = new PageScroller(driver);
				pageScroller.scrollPage(indexValue);
				break;

			case "CHECKELEMENT":
				// Check if element is displayed
				WebElement msg = driver.findElement(this.getObject(objectName, objectType, indexValue, value));
				Assert.assertTrue(msg.isDisplayed());
				System.out.println(msg.getText());
				break;

			case "ACCEPT":
				// To Accept OTP
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the OTP: ");
				String otp = sc.next();
				driver.switchTo().activeElement();
				driver.findElement(this.getObject(objectName, objectType, indexValue, value)).sendKeys(otp);
				break;

			case "RESULTCOMPARE":
				resultCompare = new ResultCompare(driver);
				resultCompare.verifyResults(objectName, objectType, indexValue, value);
				break;

			case "CLOSE":
				driver.close();
				break;
			default:
				break;
			}
	}

	/**
	 * Find element BY using object type and value
	 * 
	 * @param p
	 * @param objectName
	 * @param objectType
	 * @return
	 * @throws Exception
	 */
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
