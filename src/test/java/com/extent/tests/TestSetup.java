package com.extent.tests;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class TestSetup {
	AppiumDriver<WebElement> driver=null;
	
	public AppiumDriver LaunchApp(URL url,DesiredCapabilities des,String platFormNm)
	{
		if(platFormNm.equalsIgnoreCase("Android"))
		{
			driver= new AndroidDriver<>(url,des);
		}
		else
			driver= new IOSDriver<>(url,des);
		
		return driver;
	}
	

}
