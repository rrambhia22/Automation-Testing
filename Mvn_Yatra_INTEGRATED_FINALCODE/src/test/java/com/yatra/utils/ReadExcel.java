package com.yatra.utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadExcel {
	public Object[][] getData(String fileName, String sheetName) throws IOException {
		Object[][] object = null;
		ExcelFile file = new ExcelFile();

		// Read sheet
		Sheet Sheet = file.readExcel(System.getProperty("user.dir") + "\\src\\test\\resources", fileName, sheetName);

		// Find number of rows in excel file
		int rowCount = Sheet.getLastRowNum() - Sheet.getFirstRowNum();
		object = new Object[rowCount][6];
		for (int i = 0; i < rowCount; i++) {
			// Loop over all the rows
			Row row = Sheet.getRow(i + 1);
			// Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// Print excel data in console
				object[i][j] = row.getCell(j).toString();
			}

		}
		System.out.println("");
		return object;
	}
}
