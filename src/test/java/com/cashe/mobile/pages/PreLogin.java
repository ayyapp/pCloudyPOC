/*package com.cashe.mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cash.utilities.MB_Actions;

import io.appium.java_client.AppiumDriver;

public class PreLogin {

	public	AppiumDriver driver;
	MB_Actions mb = new MB_Actions();
	
	public PreLogin(AppiumDriver<WebElement> driver) {
		this.driver = driver;
	}

	public WebElement getSubmitButton(String platformName) {
		return getLocator("SignUp", platformName);
	}

	
	
	
	public WebElement getLocator(String objectName, String platformName) {
		return driver.findElement(By.xpath(MB_Actions.getLocator(this.getClass().getSimpleName(), objectName, platformName)));
	}

}
*/