package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class ExcelUtility extends BaseClass {
	
	FileInputStream fis=null;
	Workbook wb=null;
	Sheet sh=null;
	public String getCellData(String name,int rownum,int column){
		DataFormatter df =new DataFormatter();
		try {
			fis = new FileInputStream(pu.readProperty("ExcelFilePath"));
			 wb = WorkbookFactory.create(fis);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		sh=wb.getSheet(name);
		Cell c =sh.getRow(rownum).getCell(column);
		return df.formatCellValue(c);
	}
	@Test
	public void test(){
		String poipath=System.getProperty("user.dir")+"/src/test/resources/Hybrid.xlsx";
		System.out.println(getCellData(poipath, 0, 0));
	}
}
