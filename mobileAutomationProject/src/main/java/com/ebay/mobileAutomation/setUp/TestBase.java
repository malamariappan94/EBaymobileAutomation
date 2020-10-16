package com.ebay.mobileAutomation.setUp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ebay.mobileAutomation.commonJavaFunctions.ReadConfigFile;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	
	public static AppiumDriver<MobileElement> driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static String searchData = "";
	    //ExtentTest test;
	
	@BeforeSuite
	public static void setUp() throws MalformedURLException, InterruptedException {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        ReadConfigFile config = new ReadConfigFile();
        searchData = config.getSearchData();
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
		cap.setCapability("noReset", "true");
		cap.setCapability("fullReset", "false");
		cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		
		File file = new File(System.getProperty("user.dir"));
		File appDir = new File(file,"/apk");
		File app = new File(appDir,"/Amazon_shopping.apk");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		
		
		driver =  new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		
		Thread.sleep(5000);
	}
	

	
	@AfterSuite
	public static void tearDown() throws Exception{
		extent.flush();
		driver.quit();
		
	}

}
