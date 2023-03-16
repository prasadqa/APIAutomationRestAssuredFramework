package com.qa1.api.gorest.utill;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtills {

	public static Workbook book;
	public static Sheet sheet;
	public static String TEST_DATDA_SHEET_PATH = "/Users/challaprasad/Documents/Java-Selenium/RestAssuredAutomationAPI/src/main/java/com/qa1/api/gorest/testdata/CreateUserData.xlsx";
	
	public static Object[][] getTestData(String sheetName) {
		
		try {
			FileInputStream file = new FileInputStream(TEST_DATDA_SHEET_PATH);
			book =  WorkbookFactory.create(file);
			sheet = book.getSheet(sheetName);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
		
	}
	
	
	
}
