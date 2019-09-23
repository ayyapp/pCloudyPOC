package com.cashe.mobile.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestSetUp {

	AppiumDriver driver=null;

	@BeforeTest
	public void launchApp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("pCloudy_Username", "swapnamadhari@dbs.com");
		capabilities.setCapability("pCloudy_ApiKey", "dm43xk4bvq3kkvj5d2zp7nh4");
		//capabilities.setCapability("pCloudy_ApplicationName", "pCloudyAppiumDemo.apk");
		capabilities.setCapability("pCloudy_DurationInMinutes", 10);
		capabilities.setCapability("pCloudy_DeviceManafacturer", "Samsung");
		//capabilities.setCapability("pCloudy_DeviceVersion", "8.0.0");
		//capabilities.setCapability("pCloudy_DeviceFullName", "Samsung_GalaxyTabA_Android_7.1.1");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("newCommandTimeout", 600);
		capabilities.setCapability("launchTimeout", 90000);
		capabilities.setCapability("appPackage", "com.dbs.in.digibank");
		capabilities.setCapability("appActivity", "com.dbs.in.digitalbank.ui.splash.SplashActivity");
		driver = new AndroidDriver(new URL("https://dbs.pcloudy.com/appiumcloud/wd/hub"), capabilities);
	}

	@AfterTest
	public void tearDown() {
		if(driver != null){
			driver.quit();
		}
	}

}
