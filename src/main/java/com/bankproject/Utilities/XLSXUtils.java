package com.bankproject.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXUtils 
{
   public static XSSFWorkbook workbook;
   public static XSSFSheet    sheet;
   public static XSSFRow      row;
   public static XSSFCell     cell;
   public static FileInputStream fis;
   public static FileOutputStream fos;
   
   public static int getRowCount(String xlfile,String xlsheet) throws IOException
   {
	fis=new FileInputStream(xlfile);
	workbook=new XSSFWorkbook(fis);
	sheet=workbook.getSheet(xlsheet);
	int rowcount = sheet.getLastRowNum();
	workbook.close();
	fis.close();
	return rowcount;   
   }
   
   public static int getCellCount(String xlfile,String xlsheet,int rowno) throws IOException
   {
	   fis=new FileInputStream(xlfile);
	   workbook=new XSSFWorkbook(fis);
	   sheet=workbook.getSheet(xlsheet);
	   row=sheet.getRow(rowno);
	   int cellcount=row.getLastCellNum();
	   workbook.close();
	   fis.close();
	return cellcount; 
   }
   
   public static String getCellData(String xlfile,String xlsheet,int rowno,int cellno) throws IOException
   {
	fis=new FileInputStream(xlfile);
	workbook=new XSSFWorkbook(fis);
	sheet=workbook.getSheet(xlsheet);
	row=sheet.getRow(rowno);
	cell=row.getCell(cellno);
	String data;
	try {
		DataFormatter formatter=new DataFormatter();
	String cellData=formatter.formatCellValue(cell);
	return cellData;
	} catch (Exception e) {
		// TODO: handle exception
		data="";
	}
	workbook.close();
	fis.close();
	return data;   
   }
   
   public static void setCellData(String xlfile,String xlsheet,int rowno,int cellno,String data) throws IOException
   {
	   fis=new FileInputStream(xlfile);
	   workbook=new XSSFWorkbook(fis);
	   sheet=workbook.getSheet(xlsheet);
	   row=sheet.getRow(rowno);
	   cell=row.getCell(cellno);
	   cell.setCellValue(data);
	   fos=new FileOutputStream(xlfile);
	   workbook.write(fos);
	   workbook.close();
	   fis.close();
	   fos.close();
   }
     
}
