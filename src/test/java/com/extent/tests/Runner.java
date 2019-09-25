package com.extent.tests;

import static com.cash.utilities.DataBaseConnection.connection;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.cash.utilities.DataBaseConnection;
import com.cashe.mobile.tests.Config;

import io.appium.java_client.remote.MobileBrowserType;


public class Runner {

	public static String BROWSER = MobileBrowserType.CHROME;
	public static DesiredCapabilities capabilities;
	
	//public static URL apiEndpoint=;

	public static int REPEATITION = 1;
	public static int BOOKINGDURATION = 6 * REPEATITION;

	public static String PLATFORM = "android";
	public static File WORKING_DIRECTORY = new File("Reports");

	public static void main(String[] arr) throws Exception {
		System.out.println("Inside Main Method of Runner");
		Boolean use_pCloudy = true;
		Config.getDeviceData();
		if (use_pCloudy) {
			init_pCloudyAppiumDriver();

		} else {
			throw new OperationNotSupportedException();
		}

	}

	private static void init_pCloudyAppiumDriver() throws Exception {

	

		List<Thread> threadPools = new ArrayList<Thread>();

		for (int i = 0; i < Config.deviceList.size(); i++) {
			
			HashMap<String, String> deviceData=Config.deviceList.get(i);
			System.out.println("Considering Desired Capabillities...");

			capabilities = new DesiredCapabilities();

		
			capabilities.setCapability("pCloudy_Username", "swapnamadhari@dbs.com");
			capabilities.setCapability("pCloudy_ApiKey", "dm43xk4bvq3kkvj5d2zp7nh4");
			capabilities.setCapability("pCloudy_DurationInMinutes",10);
			capabilities.setCapability("pCloudy_DeviceFullName", deviceData.get("Device Name"));
			capabilities.setCapability("automationName", "uiautomator2");
			//capabilities.setCapability("platformVersion", deviceData.get("Platform version"));
			capabilities.setCapability("noReset", true);
			capabilities.setCapability("fullReset", false);
			capabilities.setCapability("newCommandTimeout", 1000);
			capabilities.setCapability("launchTimeout", 100000);
			capabilities.setCapability("appPackage", "com.dbs.in.digibank");
			capabilities.setCapability("appActivity", "com.dbs.in.digitalbank.ui.splash.SplashActivity");
			capabilities.setCapability("sendKeyStrategy", "setValue");

			/*if (PLATFORM.equalsIgnoreCase("ios")) {
				if (aDevice.getVersion().compareTo(new Version("9.3")) >= 0)
					capabilities.setCapability("automationName", "XCUITest");
				else
					throw new Exception("IosSafari automation based on Instruments is not supported. Please run on newer devices with XCUITest.");

				capabilities.setCapability("usePrebuiltWDA", true);
				capabilities.setCapability("acceptAlerts", true);
			}*/

			
			connection();
			new DataBaseConnection(deviceData.get("Platform Name"));
			TestSuite TC = new TestSuite(new URL("https://dbs.pcloudy.com/appiumcloud/wd/hub"),capabilities,deviceData.get("Platform Name"));
			
			Thread t = new Thread(TC);
			t.setName(deviceData.get("Device Name"));
			System.out.println("Thread started: " + deviceData.get("Device Name"));
			threadPools.add(t);
			t.start();

			System.out.println();
		}
		

		for (Thread t : threadPools) {
			t.join();
			System.out.println("Thread Ended: " + t.getName());
		}

	}

}




