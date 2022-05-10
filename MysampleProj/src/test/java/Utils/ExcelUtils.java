package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String projPath,String sheetName) {

		try {
			
			workbook = new XSSFWorkbook(projPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public int getRowCount() {
          
		int rowCount = 0;
		
          try {

		    rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of Rows is " + rowCount);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
         
          return rowCount;
	}

	
	public int getColCount() {

		int colCount=0;
		try {

			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of Cols is " + colCount);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

		return colCount;
	}

	public String getCellString(int rowNum,int colNum) {

		String cellData= null;
		try {

			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(cellData);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cellData;

	}

	public double getCellNumericValue(int rowNum,int colNum) {

		double cellData =0.0;
		try {

		   cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//System.out.println(cellData);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cellData;

	}
	
	public Object getCellValue(int rowNum,int colNum) {

		Object cellData = null;
		try {

			DataFormatter formatter = new DataFormatter();
			
		   cellData = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			//System.out.println(cellData);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cellData;

	}
	
	
}
