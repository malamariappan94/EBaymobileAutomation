//$Id$
package com.ebay.mobileAutomation.homeScript;



import java.util.List;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.ebay.mobileAutomation.Pages.HomePage;
import com.ebay.mobileAutomation.Pages.LoginPage;
import com.ebay.mobileAutomation.setUp.TestBase;
import com.ebay.mobileAutomation.webGeneralFunctions.GeneralFunctions;

import io.appium.java_client.MobileElement;

public class HomeTestScript extends TestBase{
	
	ExtentTest logger;
	
	@Test(priority=2)
	public void searchItems()throws Exception{
		
		//String search = "65 inches tv";
		logger = extent.createTest("Search the item");
		
		HomePage hp = new HomePage();
		GeneralFunctions gn = new GeneralFunctions();
		
		LoginPage.switchToNative(driver);
		Thread.sleep(1000);
		
		
		
		gn.click(hp.searchBar(driver), logger, driver);
		Thread.sleep(2000);
		
		//search items
		gn.sendKeys(searchData, hp.searchBar(driver), logger, driver);
		Thread.sleep(2000);
		
		LoginPage.switchToNative(driver);
		Thread.sleep(1000);
		
		//select anny one of the item from the list
		gn.click(hp.selectElementFromDropDown(driver), logger, driver);
		Thread.sleep(2000);
		
		
		
	}
	
	@Test(priority=3)
	public void chooseOneItem() throws Exception{
		
		logger = extent.createTest("Select the searched item");
		
		HomePage hp = new HomePage();
		GeneralFunctions gn = new GeneralFunctions();
		
		LoginPage.switchToNative(driver);
		Thread.sleep(1000);
		
		String text = gn.getText(hp.selectOneProduct(driver), logger, driver);
		Thread.sleep(1000);
		
		System.out.println(text);
		
		gn.click(hp.selectOneProduct(driver), logger, driver);
		Thread.sleep(3000);
		
		String productName = gn.getText(hp.productDetail(driver), logger, driver);
		Thread.sleep(1000);
		
		//System.out.println("product name : "+productName);
	}
	
	

}
