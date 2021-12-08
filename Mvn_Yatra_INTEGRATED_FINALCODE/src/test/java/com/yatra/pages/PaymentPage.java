package com.yatra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
	
	
	@FindBy(xpath = "//*[contains(text(),'You Pay :')]")
	WebElement youPayText;
	
	private WebDriver driver;
	public PaymentPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkStatus() throws InterruptedException
	{
		//checking for flight confirmation and price hike condition
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'You Pay :')]")));
		Thread.sleep(3000);
		
		boolean continueButton = driver.findElement(By.xpath("//*[@id=\"checkoutBase\"]/div[6]/div[2]/div/div[2]/div[6]/button[2]")).isDisplayed();
		if(continueButton)
		{
			driver.findElement(By.xpath("//*[@id=\"checkoutBase\"]/div[6]/div[2]/div/div[2]/div[6]/button[2]")).click();
		}
		
	}
	

}
