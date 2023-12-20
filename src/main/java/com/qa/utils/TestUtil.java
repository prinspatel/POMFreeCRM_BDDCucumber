package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class TestUtil extends TestBase {

	public TestUtil() throws InterruptedException {
		super();
	}
	
	
	
	static String DRIVER_PATH = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
	static String PROPERTIES_PATH = System.getProperty("user.dir") + "\\src\\main\\java\\config\\cofig.properties";
	static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\data\\FreeCRM_Data.xlsx";

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	static Workbook book;
	static Sheet sheet;

	public void swithToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

}
