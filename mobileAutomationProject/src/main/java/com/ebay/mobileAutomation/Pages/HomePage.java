//$Id$
package com.ebay.mobileAutomation.Pages;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage {
	
	public MobileElement searchBar(AppiumDriver<MobileElement> driver)throws Exception{
		
		MobileElement element = (MobileElement) driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text"));
		return element;
	}
	
	public MobileElement selectElementFromDropDown(AppiumDriver<MobileElement> driver)throws Exception{
		
		//com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text_layout
		List<MobileElement> list = driver.findElements(By.id("com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text_layout"));
		Random r = new Random();
		int n = r.nextInt(list.size());
		MobileElement element = list.get(0);
		return element;
	}
	
	public MobileElement selectOneProduct(AppiumDriver<MobileElement> driver)throws Exception{
		
		List<MobileElement> list = driver.findElements(By.id("com.amazon.mShop.android.shopping:id/item_title"));
		System.out.println(list.size());
		Random r = new Random();
		int n = r.nextInt(list.size());
		MobileElement element = list.get(n);
		return element;
		
	}
	
	public MobileElement productDetail(AppiumDriver<MobileElement> driver)throws Exception{
		
		List<MobileElement> elements = driver.findElements(By.className("android.view.View"));
		MobileElement element = elements.get(0);
		return element;
	}
	
	
	

}
