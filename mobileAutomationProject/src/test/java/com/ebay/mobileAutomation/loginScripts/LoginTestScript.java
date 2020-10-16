package com.ebay.mobileAutomation.loginScripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.ebay.mobileAutomation.Pages.LoginPage;
import com.ebay.mobileAutomation.commonJavaFunctions.ReadExcelData;
import com.ebay.mobileAutomation.setUp.TestBase;
import com.ebay.mobileAutomation.webGeneralFunctions.GeneralFunctions;


public class LoginTestScript extends TestBase{
	
	ExtentTest logger;
	
	@Test(priority=0)
	public void existingUserPage()throws Exception{
		
		logger = extent.createTest("Login to the application");
		
		
		LoginPage login = new LoginPage();
		GeneralFunctions gn = new GeneralFunctions();
		
		//press the already user has account button
		gn.click(login.exitingUserButton(driver), logger, driver);
		Thread.sleep(5000);
		
		
	}
	
	@Test(priority=1)
	public void enterUserName() throws Exception{
		
		ReadExcelData data = new ReadExcelData();
		LoginPage login = new LoginPage();
		GeneralFunctions gn = new GeneralFunctions();
		
		String[] loginDetails = data.readLoginDetails();
		String username = loginDetails[0];
		String password = loginDetails[1];
		
		LoginPage.changeDriverContextToWeb(driver);
		Thread.sleep(1000);
		
		//enter email id or mobile number
		gn.sendKeys(username, login.userNameTextField(driver), logger, driver);
		Thread.sleep(2000);
		
		LoginPage.switchToNative(driver);
		Thread.sleep(1000);
		
		//press the continue button
		gn.click(login.continueButton(driver), logger, driver);
		Thread.sleep(5000);
		
		LoginPage.changeDriverContextToWeb(driver);
		Thread.sleep(1000);
		
		gn.sendKeys(password, login.passwordTextField(driver), logger, driver);
		Thread.sleep(1000);
		
		
		//press the sign in button
		gn.click(login.signInButton(driver), logger, driver);
		Thread.sleep(5000);
		
	}
	
	
	
	
	

}
