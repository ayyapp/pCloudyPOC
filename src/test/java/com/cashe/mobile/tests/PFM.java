package com.cashe.mobile.tests;

import java.net.MalformedURLException;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cash.utilities.DataBaseConnection;
import com.cash.utilities.MB_Actions;
import com.cash.utilities.Randomizer;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;



public class PFM {

	AppiumDriver driver=null;
	MB_Actions action=null;
	
	public PFM(AppiumDriver<WebElement> driver,String platFormNm) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		action=new MB_Actions(driver,platFormNm);
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void pfm() throws MalformedURLException, InterruptedException {
		try {
	
	driver.findElement(By.xpath(DataBaseConnection.getObject("txt_Username","LoginPage"))).sendKeys("testnts");
	driver.findElement(By.xpath(DataBaseConnection.getObject("txt_Password","LoginPage"))).sendKeys("dbs123");
	driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Login","LoginPage"))).click();
	driver.findElement(By.xpath(DataBaseConnection.getObject("btn_HamburgerMenu","DashBoardPage"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Accept","DashBoardPage"))).click();
	action.swipeBasedOnDirection("UP",5);
	action.captureScreenShot("DashBoardPage");
	driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Spendings","DashBoardPage"))).click();
	driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","SpendingsScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("list_Budget","SpendingsScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("listItem_Bills&Utilities","SpendingsScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("listItem_Bills&Utilities","SpendingsScreen"))).click();
	driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","BudgetBarGraphScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Edit","BudgetBarGraphScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Edit","BudgetBarGraphScreen"))).click();
	driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","BudgetDetailsScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_BdtgtCategory","BudgetDetailsScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_MaxAmount","BudgetDetailsScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Frequency","BudgetDetailsScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Notify","BudgetDetailsScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditMaxAmount","BudgetDetailsScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditFrequency","BudgetDetailsScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditNotify","BudgetDetailsScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditMaxAmount","BudgetDetailsScreen"))).click();
	driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","SetBudgeLimitScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).click();
	driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).getText();//Need to check this
	driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).sendKeys("100000");
	driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Save","SetBudgeLimitScreen"))).click();
	driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","BudgetDetailsScreen"))).isDisplayed();
	driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditMaxAmount","BudgetDetailsScreen"))).isDisplayed();
	//Need  to insert screenshot method after each isDisplayed
	
	}catch (Exception e) {
		e.printStackTrace();
	}
	driver.quit();
}
}

