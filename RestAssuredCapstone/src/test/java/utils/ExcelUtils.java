package utils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;

public class ExcelUtils {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName) {
        try {
            InputStream file = new FileInputStream(excelPath);
//            workbook = new HSSFWorkbook(new POIFSFileSystem(file));
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);

        }catch(Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public static void getRowCount() {

        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("No of rows : "+rowCount);
    }

    public static void getCellData(int rowNum, int colNum) {

        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        System.out.println(value);

    }
}
