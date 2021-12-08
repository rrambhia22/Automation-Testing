package com.yatra.pages;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yatra.utils.PageScroller;
import com.yatra.utils.ReadObject;

public class SelectFlight {
	private WebDriver driver;
	PageScroller pageScroller;

	@FindBy(xpath = "//*[@class = 'rangeslider__handle-label']")
	WebElement priceSlider;

	public SelectFlight(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void multiCity() throws IOException, InterruptedException {
		// price slider functionality on the more filters page
		ReadObject object = new ReadObject();
		Properties objects = object.getObjectRepository();

		// Thread.sleep(3000);
		// moreFilters.click();
		Thread.sleep(1000);

		Dimension sliderSize = priceSlider.getSize();
		int sliderWidth = sliderSize.getWidth();
		// System.out.println(sliderWidth);
		Thread.sleep(1000);
		int xCoord = priceSlider.getLocation().getX();
		// int xCoord = priceSlider.getLocation().getY();
		// System.out.println(xCoord);
		// System.out.println(yCoord);
		// minimum -214
		Actions builder = new Actions(this.driver);
		builder.moveToElement(priceSlider).click().dragAndDropBy(priceSlider, -60, 0).build().perform();

		Thread.sleep(2000);

	}

}
