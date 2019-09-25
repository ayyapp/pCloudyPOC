package com.cashe.mobile.tests;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.cash.utilities.DataBaseConnection;
import com.cash.utilities.MB_Actions;
import com.cash.utilities.Randomizer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



public class PFM {

	AppiumDriver<MobileElement> driver=null;
	MB_Actions action=null;

	public PFM(AppiumDriver<MobileElement> driver,String platFormNm) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		action=new MB_Actions(driver,platFormNm);
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void pfm() throws MalformedURLException, InterruptedException {
		try {
			Thread.sleep(6000);
			driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Login","LoginPage"))).click();
		
			try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_NotYou","LoginPage"))).isDisplayed())
				{
					driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_NotYou","LoginPage"))).click();
				}
				else
				{
					driver.findElement(By.xpath(DataBaseConnection.getObject("txt_Username","LoginPage"))).sendKeys("testnts");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Not You is displayed please enter password");
			}
			
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_Password","LoginPage"))).sendKeys("dbs123");
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Login","LoginPage"))).click();
			Thread.sleep(6000);
			
			try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_LetsGo","LoginPage"))).isDisplayed())
				{
				driver.findElement(By.xpath(DataBaseConnection.getObject("btn_LetsGo","LoginPage"))).click();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Device linking already Done!!");
			}
			
			Thread.sleep(6000);
			
			try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).isDisplayed())
				{
				driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).click();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Device Already Registerd");
			}
			
			Thread.sleep(6000);
			
			try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Accept","DashBoardPage"))).isDisplayed())
				{
				driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Accept","DashBoardPage"))).click();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Terms and Conditions already accepted");
			}
			
			
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_HamburgerMenu","DashBoardPage"))).isDisplayed());
			
			
			
			action.swipeBasedOnDirection("UP",5);
			action.captureScreenShot("DashBoardPage");
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Spendings","DashBoardPage"))).click();
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","SpendingsScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("list_Budget","SpendingsScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("listItem_Bills&Utilities","SpendingsScreen"))).isDisplayed());
			driver.findElement(By.xpath(DataBaseConnection.getObject("listItem_Bills&Utilities","SpendingsScreen"))).click();
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","BudgetBarGraphScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Edit","BudgetBarGraphScreen"))).isDisplayed());
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Edit","BudgetBarGraphScreen"))).click();
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","BudgetDetailsScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_BdtgtCategory","BudgetDetailsScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_MaxAmount","BudgetDetailsScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Frequency","BudgetDetailsScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Notify","BudgetDetailsScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditMaxAmount","BudgetDetailsScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditFrequency","BudgetDetailsScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditNotify","BudgetDetailsScreen"))).isDisplayed());
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditMaxAmount","BudgetDetailsScreen"))).click();
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","SetBudgeLimitScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).isDisplayed());
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).clear();
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).click();
			action.enterNumericKey(Randomizer.getRandomNumber());
			
			String actualVal=driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).getText();//Need to check this
		//	driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).sendKeys();
			System.out.println("Saved Value is "+actualVal);
			action.hideKeyboard();
			Thread.sleep(4000);
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Save","SetBudgeLimitScreen"))).click();
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","BudgetDetailsScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditMaxAmount","BudgetDetailsScreen"))).isDisplayed());
			//Need  to insert screenshot method after each isDisplayed

		}catch (Exception e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}

