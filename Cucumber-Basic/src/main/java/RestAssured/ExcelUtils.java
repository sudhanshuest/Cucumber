package RestAssured;

public class ExcelUtils {
	
	XSSFWorkbook workbook = new XSSFWorkbook(excelPath);

	XSSFSheet sheet = workbook.getSheet(sheetName);
	
	public static Object getCellData(int rowNum, int colNum) {

		DataFormatter formatter = new DataFormatter();

		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));

		return value;

		}

}
