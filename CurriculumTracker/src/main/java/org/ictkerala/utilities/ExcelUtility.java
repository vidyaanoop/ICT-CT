package org.ictkerala.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.ictkerala.constants.AutomationConstants;

public class ExcelUtility {
	public static XSSFWorkbook excelWorkBook;
	public static XSSFSheet excelSheet;
		
	public static String readExcel(int row, int col, String string) throws IOException {
		FileInputStream excelFile = new FileInputStream(System.getProperty("user.dir")+ AutomationConstants.EXCEL_FILE);
		excelWorkBook = new XSSFWorkbook(excelFile);
		excelSheet = excelWorkBook.getSheetAt(0);
		return excelSheet.getRow(row).getCell(col).getStringCellValue();
	}

}



