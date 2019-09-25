package com.extent.tests;

import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cashe.mobile.tests.LoginTest;
import com.cashe.mobile.tests.PFM;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class TestSuite implements Runnable {

	URL endpoint = null;
	DesiredCapabilities capabilities = null;
	String platFormNm=null;
	AppiumDriver<MobileElement> driver=null;


	public TestSuite(URL endpoint,DesiredCapabilities capabilities,String platFormName) {
		this.endpoint = endpoint;
		this.platFormNm=platFormName;
		this.capabilities = capabilities;

	}
	@Override
	public void run() {
		try {
			try {
				//driver = new TestSetup().LaunchApp(endpoint, capabilities, platFormNm);
				//LoginTest loginTest = new LoginTest(driver,platFormNm);
				//loginTest.loginMb();
				
				//driver.quit();

				driver = new TestSetup().LaunchApp(endpoint, capabilities, platFormNm);
				PFM pfm = new PFM(driver,platFormNm);
				pfm.pfm();			
				
				
			} catch (Exception e) {
				System.err.println(Thread.currentThread().getName() + " -> " + e.getMessage());
			}

		} finally {
			
		}

	}



}


