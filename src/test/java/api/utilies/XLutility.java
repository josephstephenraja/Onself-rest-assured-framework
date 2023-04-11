package api.utilies;

import java.io.FileInputStream;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class XLutility {
	
	public static Map<String, HashMap<String, String>> readExcelData(String sheetName) {
	    HashMap<String, HashMap<String, String>> completeSheetData = new HashMap<>();
	    String s3 = null;
	    try (FileInputStream file = new FileInputStream("C:\\Users\\josephstephenraja.p\\OneDrive - Optisol Business Solutions Private Limited\\Desktop\\my project\\RestAPIFrameWork\\TestData\\EndPoints.xlsx")) {
	        
	        DataFormatter formatter = new DataFormatter();
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        Row headerow = sheet.getRow(0);
	        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
	            Row currentRow = sheet.getRow(i);
	            HashMap<String, String> currentHash = new HashMap<String, String>();



	           for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
	                Cell currentCell1 = currentRow.getCell(0);
	                s3 = currentCell1.getStringCellValue();



	               Cell currentCell = currentRow.getCell(j);
	                currentHash.put(formatter.formatCellValue(headerow.getCell(j)),
	                        formatter.formatCellValue(currentCell));
	            }



	           completeSheetData.put(s3, currentHash);
	        }



	   } catch (Exception e) {
	       System.out.println(e);



	   } 



	   return completeSheetData;
	}

}
