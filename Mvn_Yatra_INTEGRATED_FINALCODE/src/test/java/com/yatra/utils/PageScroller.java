package com.yatra.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageScroller {
	private WebDriver driver;

	public PageScroller(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollPage(String yCord) {
		JavascriptExecutor js = (JavascriptExecutor) this.driver;

		if (yCord.equals("2000")) {
			js.executeScript("window.scrollBy(0,2000)");
		} else if (yCord.equals("1000")) {
			js.executeScript("window.scrollBy(0,1000)");
		} else if (yCord.equals("500")) {
			js.executeScript("window.scrollBy(0,500)");
		} 
		 else if (yCord.equals("250")) {
				js.executeScript("window.scrollBy(0,250)");
		 }else {
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}

	}

}
