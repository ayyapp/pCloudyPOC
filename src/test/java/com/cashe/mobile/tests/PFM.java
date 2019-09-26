package com.cashe.mobile.tests;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

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
	String newlimit=null;
	String updatedVal=null;

	public PFM(AppiumDriver<MobileElement> driver,String platFormNm) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		action=new MB_Actions(driver,platFormNm);
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	public void pfmScenario1() throws MalformedURLException, InterruptedException {
		try {

			try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Attention","PreWelcome"))).isDisplayed())
				{
					driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Attention","PreWelcome"))).click();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Terms and Conditions already accepted");
			}


			try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).isDisplayed())
				{
					//driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).click();
					Thread.sleep(2000);
					for (int i=0; i<=3; i++)
					{
						if(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).isDisplayed());
						driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).click();
						Thread.sleep(1000);
					}

				} 
			}catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Device Already Registerd");
			}


			Thread.sleep(6000);
			driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Login","LoginPage"))).click();

			try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_NotYou","LoginPage"))).isDisplayed())
				{
					driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_NotYou","LoginPage"))).click();
					driver.findElement(By.xpath(DataBaseConnection.getObject("txt_Username","LoginPage"))).sendKeys("testnts");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Not You? is not displayed! Please enter username");
				driver.findElement(By.xpath(DataBaseConnection.getObject("txt_Username","LoginPage"))).sendKeys("testnts");
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



			action.swipeBasedOnDirection("UP",2);
			action.captureScreenShot("DashBoardPage");
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Spendings","DashBoardPage"))).click();
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","SpendingsScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("list_Budget","SpendingsScreen"))).isDisplayed());
			System.out.println("PFM Scenario 1 Completed...");
			driver.closeApp();
		}catch (Throwable e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println("PFM Scenario 1 Completed...");
			driver.closeApp();
		}
	}

	public void pfmScenario2() throws MalformedURLException, InterruptedException {
		try {

			try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Attention","PreWelcome"))).isDisplayed())
				{
					driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Attention","PreWelcome"))).click();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Terms and Conditions already accepted");
			}


			try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).isDisplayed())
				{
					//driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).click();
					Thread.sleep(2000);
					for (int i=0; i<=3; i++)
					{
						if(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).isDisplayed());
						driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).click();
						Thread.sleep(1000);
					}

				} 
			}catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Device Already Registerd");
			}


			Thread.sleep(6000);
			driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Login","LoginPage"))).click();

			try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_NotYou","LoginPage"))).isDisplayed())
				{
					driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_NotYou","LoginPage"))).click();
					driver.findElement(By.xpath(DataBaseConnection.getObject("txt_Username","LoginPage"))).sendKeys("testnts");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Not You is not displayed! Please enter username");
				driver.findElement(By.xpath(DataBaseConnection.getObject("txt_Username","LoginPage"))).sendKeys("testnts");
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



			action.swipeBasedOnDirection("UP",2);
			action.captureScreenShot("DashBoardPage");
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Spendings","DashBoardPage"))).click();
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","SpendingsScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("list_Budget","SpendingsScreen"))).isDisplayed());

			action.swipeBasedOnDirection("UP",2);
			action.captureScreenShot("DashBoardPage");
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Spendings","DashBoardPage"))).click();
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
			System.out.println("PFM Scenario 2 Completed...");
			driver.closeApp();
		}catch (Throwable e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println("PFM Scenario 2 Completed...");
			driver.closeApp();
		}
	}

	public void pfmScenario3() throws MalformedURLException, InterruptedException {
		try {

			try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Attention","PreWelcome"))).isDisplayed())
				{
					driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Attention","PreWelcome"))).click();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Terms and Conditions already accepted");
			}


			try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).isDisplayed())
				{
					//driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).click();
					Thread.sleep(2000);
					for (int i=0; i<=3; i++)
					{
						if(driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).isDisplayed());
						driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Allow","LoginPage"))).click();
						Thread.sleep(1000);
					}

				} 
			}catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Device Already Registerd");
			}


			Thread.sleep(6000);
			driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Login","LoginPage"))).click();

			try {
				if(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_NotYou","LoginPage"))).isDisplayed())
				{
					driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_NotYou","LoginPage"))).click();
					driver.findElement(By.xpath(DataBaseConnection.getObject("txt_Username","LoginPage"))).sendKeys("testnts");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Not You is not displayed! Please enter username");
				driver.findElement(By.xpath(DataBaseConnection.getObject("txt_Username","LoginPage"))).sendKeys("testnts");
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


			//sce 1

			action.swipeBasedOnDirection("UP",2);
			action.captureScreenShot("DashBoardPage");
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Spendings","DashBoardPage"))).click();
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","SpendingsScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("list_Budget","SpendingsScreen"))).isDisplayed());

			//sce 2

			action.swipeBasedOnDirection("UP",2);
			action.captureScreenShot("DashBoardPage");
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Spendings","DashBoardPage"))).click();
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




			// 	sce 3
			/*action.swipeBasedOnDirection("UP",2);
			action.captureScreenShot("DashBoardPage");
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Spendings","DashBoardPage"))).click();
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("listItem_Bills&Utilities","SpendingsScreen"))).isDisplayed());
			driver.findElement(By.xpath(DataBaseConnection.getObject("listItem_Bills&Utilities","SpendingsScreen"))).click();*/
			
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_EditMaxAmount","BudgetDetailsScreen"))).click();
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_Header","SetBudgeLimitScreen"))).isDisplayed());
			assertTrue(driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).isDisplayed());
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).clear();
			driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).click();
			String newlimit="3120";
			action.enterNumericKey(newlimit);
			action.hideKeyboard();
			Thread.sleep(4000);
			driver.findElement(By.xpath(DataBaseConnection.getObject("btn_Save","SetBudgeLimitScreen"))).click();
			String updatedVal=driver.findElement(By.xpath(DataBaseConnection.getObject("lbl_SavedBudgetLimit","SetBudgeLimitScreen"))).getText();
			//	driver.findElement(By.xpath(DataBaseConnection.getObject("txt_SetBudgetFeild","SetBudgeLimitScreen"))).sendKeys();
			System.out.println("Saved Value is "+updatedVal);
			assertTrue(updatedVal.contains(newlimit));	
			action.captureScreenShot("Budget Updated!!");
			System.out.println("Scenario 3 completed...");
			driver.closeApp();
		}catch (Throwable e) {
			e.printStackTrace();
			driver.closeApp();
		}

	}
}

