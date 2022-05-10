package Utils;

public class ExcelReadDataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String projPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projPath +"/Excel/data.xlsx","Sheet1");
		excel.getRowCount();
		excel.getCellString(0,0);
		excel.getCellNumericValue(1,1);
	}

}
