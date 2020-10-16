package com.ebay.mobileAutomation.commonJavaFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	public String[] readLoginDetails()throws Exception{
		
		String path = System.getProperty("user.dir");
		System.out.println("dir : "+path);
		path+="/exceldata/data.xlsx";
		File file = new File(path);
		
		FileInputStream excelFile = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String[] login = new String[3];
		
		Iterator<Row> iter = sheet.iterator();
		iter.next();
		iter.next();
		 while (iter.hasNext()) { 
             Row row = iter.next(); 
             // For each row, iterate through all the columns 
             Iterator<Cell> cellIterator = row.cellIterator(); 
            
            // login[0] = cellIterator.getStringCellValue();
             Cell cell = row.getCell(0);
             //Integer num = (int) cell.getNumericCellValue();
             login[0] = cell.getStringCellValue();
             cell = row.getCell(1);
             login[1] = cell.getStringCellValue();

            
		 }
            // System.out.println("login array : "+login); 
             excelFile.close();
		
		return login;
	}
	
	

}
