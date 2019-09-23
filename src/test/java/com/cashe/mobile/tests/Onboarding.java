package com.cashe.mobile.tests;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;



public class Onboarding extends TestSetUp{


	@Test
	public void onboarding() throws MalformedURLException, InterruptedException {
			driver.findElement(By.xpath("//*[@text='SignUp']")).click();
			Thread.sleep(10000);
			//driver.findElement(By.xpath("//*[@text='']")).isDisplayed();
			//driver.findElement(By.xpath("//*[@text='Password']")).click();
			//driver.findElement(By.xpath("//*[@text='']")).isDisplayed();
			//driver.findElement(By.xpath("//*[@xpath='//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).isDisplayed();
			//Thread.sleep(30000);

	}

}