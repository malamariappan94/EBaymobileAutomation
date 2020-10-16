//$Id$
package com.ebay.mobileAutomation.webGeneralFunctions;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



public class GeneralFunctions {
	
	public void click(MobileElement element,ExtentTest test,AppiumDriver<MobileElement> driver)throws Exception{
		
		try{
			element.click();
			
		}catch(Exception e){
			screenShot(driver,"button_click_fails");
			test.log(Status.INFO, MarkupHelper.createLabel("Button click Fails", ExtentColor.RED));
			
		}
		
	}
	
	public void sendKeys(String value,MobileElement element,ExtentTest test,AppiumDriver<MobileElement> driver)throws Exception{
		
		try{
			//element.clear();
		
			element.sendKeys(value);
			
		}catch(Exception e){
			screenShot(driver,"button_click_fails");
			test.log(Status.INFO, MarkupHelper.createLabel("Entering data in text field Fails", ExtentColor.RED));
			
		}
		
	}
	
	public void sendKeysWithClickEvent(String value,MobileElement element,ExtentTest test,AppiumDriver<MobileElement> driver)throws Exception{
		
		try{
			//element.clear();
			Actions action = new Actions(driver);
			action.sendKeys(value).sendKeys(Keys.ENTER).build().perform();
			
		}catch(Exception e){
			screenShot(driver,"button_click_fails");
			test.log(Status.INFO, MarkupHelper.createLabel("Entering data in text field Fails", ExtentColor.RED));
			
		}
		
	}
	
	public String getText(MobileElement element,ExtentTest test,AppiumDriver<MobileElement> driver)throws Exception{
		
		String value= "";
		try{
			//element.clear();
		
			value=element.getText();
			
		}catch(Exception e){
			screenShot(driver,"button_click_fails");
			test.log(Status.INFO, MarkupHelper.createLabel("Entering data in text field Fails", ExtentColor.RED));
			
		}
		return value;
		
	}
	
	public void swipeDown(MobileElement element,ExtentTest test,AppiumDriver<MobileElement> driver)throws Exception{
		
		try{
			//element.click();
			Dimension size = new Dimension(10,10);
			TouchActions action = new TouchActions(driver);
			action.scroll(element, 10, 100);
			action.perform();
			element.click();
			
		}catch(Exception e){
			screenShot(driver,"button_click_fails");
			test.log(Status.INFO, MarkupHelper.createLabel("Button click Fails", ExtentColor.RED));
			
		}
		
	}
	
	
	public void changeScreenOrientationToLandScape(ExtentTest test,AppiumDriver<MobileElement> driver)throws Exception{
		
		try{
		
			driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		
			
		}catch(Exception e){
			screenShot(driver,"button_click_fails");
			test.log(Status.INFO, MarkupHelper.createLabel("Entering data in text field Fails", ExtentColor.RED));
			
		}
		
	}
	
	public void changeScreenOrientationToPortrait(ExtentTest test,AppiumDriver<MobileElement> driver)throws Exception{
		
		try{
		
			driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
		
			
		}catch(Exception e){
			screenShot(driver,"button_click_fails");
			test.log(Status.INFO, MarkupHelper.createLabel("Entering data in text field Fails", ExtentColor.RED));
			
		}
		
		
	}
	
	public static String screenShot(AppiumDriver<MobileElement> driver,String nameOfMethod)throws Exception{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"_"+nameOfMethod;
		File Dest = new File(path+".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}

}
