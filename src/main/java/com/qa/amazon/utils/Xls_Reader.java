package com.qa.amazon.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Xls_Reader {
	
	
	
	public  String ExcelPath=null;
	public static FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
	private static XSSFCell cell = null;

	
	//Constructor to load the excel file
	public Xls_Reader(String ExcelPath) {

		try {
			File src = new File(ExcelPath);
			fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
			
		}  catch (Exception e) {
			
			System.out.println(e.getMessage());

		}
		
	}
	
		

//Method to read data from excell
 public String getData(String sheetName,int row, int column) 
 {
	sheet = workbook.getSheet(sheetName);
	
	String read_data = sheet.getRow(row).getCell(column).getStringCellValue();
	return read_data;
 }

// Method to write data in excel file
 public  boolean setCellData(String sheetName, int colNum, int rowNum, String value, String ExcelPath) 
 {
	 try
	 {
	   sheet = workbook.getSheet(sheetName);
	   row = sheet.getRow(rowNum);
	   if (row==null) 
	   {
		   row = sheet.createRow(rowNum);
	   }
	   
	   cell = row.getCell(colNum);
	   
	   if (cell==null) 
	   {
		   cell = row.createCell(colNum);
	   }
	   
	   cell.setCellValue(value);
	   
	   fileOut = new FileOutputStream(ExcelPath);
	   workbook.write(fileOut);
	   fileOut.close();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
		 return false;
	 }
	 return true;
 }  


 //Method to count number of row
 public int getRowCount(String sheetName) 
 {
	 
	 
	sheet = workbook.getSheet(sheetName);
	int rowCount = sheet.getLastRowNum();

	return rowCount;
 }
 
	public  int getCellCount(String xlfilePath,String xlSheetName,int rowNum) throws IOException {
		fis=new FileInputStream(xlfilePath);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xlSheetName);
		row=sheet.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		//workbook.close();
		fis.close();
		return cellCount;
	}
 
 
 
 
 
 
 
 
 
	
}