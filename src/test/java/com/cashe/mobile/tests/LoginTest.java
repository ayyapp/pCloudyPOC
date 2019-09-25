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
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class LoginTest {

	AppiumDriver<MobileElement> driver=null;
	MB_Actions action=null;
	String platFormName=null;
	
	
	String mobile;
	
	public LoginTest(AppiumDriver<MobileElement> driver,String platFormNm) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		action=new MB_Actions(driver,platFormNm);
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.platFormName=platFormNm;
	}

	public void loginMb() throws MalformedURLException, InterruptedException {
		try {
			/*PreLogin plogin = new PreLogin(driver);*/
			//plogin.getSubmitButton("Android").click();
//			launchApp();
//			Thread.sleep(30000);
//			driver.findElement(By.xpath("//*[@text='Login']")).click();
			
			try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Attention","PreWelcome"))).isDisplayed())
				{
				driver.findElement(By.xpath(DataBaseConnection.getObject("btn_OK","PreWelcome"))).click();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Terms and Conditions already accepted");
			}
			
			
			/*try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).isDisplayed())
				{
				//driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).click();
				Thread.sleep(2000);
				for (int i=0; i<=3; i++)
				{
					if(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","WelcomePage"))).isDisplayed());
					driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","WelcomePage"))).click();
					Thread.sleep(1000);
				}
				
			} 
			}catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Device Already Registerd");
			}*/
						
			
			//Click Action performed
			action.captureScreenShot("Pre Login Page");
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Signup","WelcomePage"))).click();
	
			action.captureScreenShot("Pre Login Page");

			//Assertion for element present
			
			Assert.assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","TellUsAbout"))).isDisplayed());
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Continue","TellUsAbout"))).click();
			action.captureScreenShot("TellUs About Page");
			Assert.assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","PersonalDetails"))).isDisplayed());
			
			//Radio button selection
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Ms","PersonalDetails"))).click();
			//driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_UserName","PersonalDetails"))).click();

			//Enter text
			
			String fullname = "S" +Randomizer.getRandomString(5);
			//driver.findElement(By.xpath("//*[@resource-id='com.dbs.in.digibank:id/et_full_name']/TextInputLayout/android.widget.FrameLayout/android.widget.EditText")).sendKeys(fullname);
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_FullName","PersonalDetails"))).sendKeys(fullname);
			
			//Date picker
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_DOB","PersonalDetails"))).click();
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_OK","PersonalDetails"))).click();
			
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Next","PersonalDetails"))).click();
			action.captureScreenShot("How to Reach You Page");
			
			Assert.assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","HowToReachYou"))).isDisplayed());
			//driver.findElement(By.xpath(DataBaseConnection.getObject("txt_MobileNumer","HowToReachYou"))).click();
			//Generate Random Numbers
			mobile = Randomizer.getRandomNumber();	
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_MobileNumer","HowToReachYou"))).click();
			if(platFormName.equalsIgnoreCase("Android"))
			{
			action.enterNumericKey(mobile);
			}
			else if(platFormName.equalsIgnoreCase("iOS"))
			{
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_MobileNumer","HowToReachYou"))).sendKeys(mobile);
			}
			//driver.findElement(By.xpath(DataBaseConnection.getObject("txt_MobileNumer","HowToReachYou"))).hideKeyboard());
			action.hideKeyboard();
			
			String emailOB = "auto4" +Randomizer.getRandomString(5)  + "@dbs.com";
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_EmailAddress","HowToReachYou"))).sendKeys(emailOB);
			//driver.findElement(By.xpath(DataBaseConnection.getObject("txt_EmailAddress","HowToReachYou")).hideKeyboard());
			action.hideKeyboard();
			
	
			
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_ReEnterEmailAddress","HowToReachYou"))).sendKeys(emailOB);
			action.hideKeyboard();
			
			//Assert.assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Taphere","HowToReachYou"))).isDisplayed());
			//driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Promocode","HowToReachYou"))).click();
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_Promocode","HowToReachYou"))).sendKeys("234321");
			action.hideKeyboard();
			action.captureScreenShot("How To Reach You");
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Next","PersonalDetails"))).click();
			Assert.assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","SignupOtp"))).isDisplayed());
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_OTP","SignupOtp"))).sendKeys("123456");
			action.hideKeyboard();
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Next","PersonalDetails"))).click();
			action.captureScreenShot("Sign Up Otp");
			
			String username= "N" + Randomizer.getRandomString(9);
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_UserName","SetUserPwd"))).sendKeys(username);
			action.hideKeyboard();
			
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_Pwd","SetUserPwd"))).sendKeys("dbs123");
			action.hideKeyboard();
			
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Submit","SetUserPwd"))).click();

			action.captureScreenShot("Login Page");
			
			//PFM Story:
			
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_Username","LoginPage"))).sendKeys("testnts");
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_Password","LoginPage"))).sendKeys("dbs123");
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Login","LoginPage"))).click();
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_HamburgerMenu","DashBoardPage"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Accept","DashBoardPage"))).click();
			action.swipeBasedOnDirection("UP",5);
			action.captureScreenShot("DashBoardPage");
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Spendings","DashBoardPage"))).click();
			action.captureScreenShot("DashBoardPage");
			driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","SpendingsScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("list_Budget","SpendingsScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("listItem_Bills&Utilities","SpendingsScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("listItem_Bills&Utilities","SpendingsScreen"))).click();
			action.captureScreenShot("DashBoardPage");
			
			driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","BudgetBarGraphScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Edit","BudgetBarGraphScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Edit","BudgetBarGraphScreen"))).click();
			action.captureScreenShot("DashBoardPage");
			
			driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","BudgetDetailsScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_BdtgtCategory","BudgetDetailsScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_MaxAmount","BudgetDetailsScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Frequency","BudgetDetailsScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Notify","BudgetDetailsScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditMaxAmount","BudgetDetailsScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditFrequency","BudgetDetailsScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditNotify","BudgetDetailsScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditMaxAmount","BudgetDetailsScreen"))).click();
			action.captureScreenShot("DashBoardPage");
			
			
			driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","SetBudgeLimitScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).click();
			
			action.captureScreenShot("DashBoardPage");
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).getText();//Need to check this
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).sendKeys("100000");
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Save","SetBudgeLimitScreen"))).click();
			
			action.captureScreenShot("DashBoardPage");
			driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","BudgetDetailsScreen"))).isDisplayed();
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditMaxAmount","BudgetDetailsScreen"))).isDisplayed();
			
			
			/*Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@text='Username']")).sendKeys("ibautoreg3793");
			driver.findElement(By.xpath("//*[@text='Password']")).sendKeys("dbs123");
			driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
			driver.findElement(By.xpath("//*[@xpath='//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).isDisplayed();
			Thread.sleep(30000);*/
		}catch (Exception e) {
			e.printStackTrace();
		}
		driver.quit();

	}

}