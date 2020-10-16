package com.ebay.mobileAutomation.Pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
	
	public MobileElement exitingUserButton(AppiumDriver<MobileElement> driver)throws Exception{
		
		MobileElement element = (MobileElement) driver.findElement(By.id("com.amazon.mShop.android.shopping:id/sign_in_button"));
		return element;
	}
	
	public MobileElement userNameTextField(AppiumDriver<MobileElement> driver)throws Exception{
		
		MobileElement element =(MobileElement) driver.findElement(By.id("ap_email_login"));
		return element;
	}

	public MobileElement continueButton(AppiumDriver<MobileElement> driver)throws Exception{
	
		List<MobileElement> elements =  driver.findElements(By.className("android.widget.Button"));
		MobileElement element = elements.get(0);
		return element;
	}
	
	public MobileElement passwordTextField(AppiumDriver<MobileElement> driver)throws Exception{
		
		MobileElement element = (MobileElement) driver.findElement(By.id("ap_password"));
		return element;
	}
	
	public MobileElement signInButton(AppiumDriver<MobileElement> driver)throws Exception{
		
		MobileElement element = (MobileElement) driver.findElement(By.id("signInSubmit"));
		return element;
	}
	
	public static void changeDriverContextToWeb(AppiumDriver<MobileElement> driver) {
	    Set<String> allContext = driver.getContextHandles();
	  //  System.out.println("context : "+allContext);
	    for (String context : allContext) {
	        if (context.contains("WEBVIEW"))
	            driver.context(context);
	    }
	}
	
	public static void switchToNative(AppiumDriver<MobileElement> driver){
		driver.context("NATIVE_APP");
	}

	
	
	
	
}
