//$Id$
package com.ebay.mobileAutomation.commonJavaFunctions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	 private Properties properties;
	 private final String propertyFilePath= "dataFramework//Config.properties";
	 
	 public ReadConfigFile(){
		 BufferedReader reader;
		 try {
		 reader = new BufferedReader(new FileReader(propertyFilePath));
		 properties = new Properties();
		 try {
		 properties.load(reader);
		 reader.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		 }
	 }
	 
	 public String getSearchData(){
		 String search = properties.getProperty("search");
		 if(search!= null) return search;
		 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
		 }
		 
		 
}
