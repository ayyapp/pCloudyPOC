package com.cash.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MB_Actions {

	static Dimension size;
	WebDriverWait wait;
    MobileElement element;
	AppiumDriver<MobileElement> driver=null;
	String platFormNm=null;
	
	
	
	public MB_Actions(AppiumDriver<MobileElement> driver,String platFormNm) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.platFormNm=platFormNm;
	}
	
	

  @SuppressWarnings("rawtypes")
public void swipeBasedOnDirection(String direction,int iteration)
  {
	  size=driver.manage().window().getSize();
	  int startX,startY,endX,endY;
	  while(iteration>0)
	  {
		  switch(direction.toUpperCase())
	  
	  {
	  
      case "LEFT":
          startY = (int) (size.height / 2);
          startX = (int) (size.width * 0.90);
          endX = (int) (size.width * 0.10);
          new TouchAction(driver)
          .press(PointOption.point(startX, startY))
          .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
          .moveTo(PointOption.point(endX, startY))
          .release()
          .perform();
                  
          break;

      case "RIGHT":
          startY = (int) (size.height / 2);
          startX = (int) (size.width * 0.20);
          endX = (int) (size.width * 0.90);
          new TouchAction(driver)
          .press(PointOption.point(startX,startY))
          .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
          .moveTo(PointOption.point(endX, startY))
          .release()
          .perform();
          break;

      case "DOWN":
          endY = (int) (size.height * 0.90);
          startY = (int) (size.height * 0.20);
          startX = (size.width / 2);
          new TouchAction(driver)
          .press(PointOption.point(startX,startY))
          .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
          .moveTo(PointOption.point(startX, endY))
          .release()
          .perform();
          break;


      case "UP":
          startY = (int) (size.height * 0.70);
          endY = (int) (size.height * 0.20);
          startX = (size.width / 2);
          new TouchAction(driver)
          .press(PointOption.point(startX,startY))
          .waitAction(WaitOptions.waitOptions(Duration.ofMillis(750)))
          .moveTo(PointOption.point(startX, endY))
          .release()
          .perform();

          break;
	  }
	  iteration--;
	  }
  }
  
  
  public void hideKeyboard()
	{
		driver.hideKeyboard();
	}
  
  public void captureScreenShot(String screenShotName){
	// Take screenshot and store as a file format             
	 File src=((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);           
	try {
	// now copy the  screenshot to desired location using copyFile method
	 
	FileUtils.copyFile(src, 
			new File(System.getProperty("user.dir")+
					File.separator+"Screenshots_Folder"+File.separator+
					screenShotName+System.currentTimeMillis()+".png"));                      
	} catch (Exception e)
	 {
	  System.out.println(e.getMessage());
	 }
	  }
  
  
  public void enterNumericKey(String number)
  {
	  char[] numKeys=number.toCharArray();
	  for(char numPad:numKeys)
	  {  switch (numPad) {
	  case '0':
		  ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent(AndroidKey.NUMPAD_0));
		  break;
	  case '1':
		  ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
		  break;
	  case '2':
		  ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent(AndroidKey.NUMPAD_2));
		  break;
	  case '3':
		  ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent(AndroidKey.NUMPAD_3));
		  break;
	  case '4':
		  ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent(AndroidKey.NUMPAD_4));
		  break;	
		  
	  case '5':
		  ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent(AndroidKey.NUMPAD_5));
		  break;
		  
	  case '6':
		  ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent(AndroidKey.NUMPAD_6));
		  break;
		  
	  case '7':
		  ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent(AndroidKey.NUMPAD_7));
		  break;
		  
	  case '8':
		  ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent(AndroidKey.NUMPAD_8));
		  break;
		  
	  case '9':
		  ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent(AndroidKey.NUMPAD_9));
		  break;
	  }

	  }
  }

  
  


	
 

	
	
}
