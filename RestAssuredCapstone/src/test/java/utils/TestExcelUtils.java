package utils;

import io.restassured.RestAssured;
import org.apache.log4j.LogManager;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class TestExcelUtils {



    @Test

    public static void  testExcelUtils() {

// specify base url

        String excelPath = "C:/Excel Files/TestData.xlsx";
        String sheet = "Sheet1";
        ExcelUtils excel = new ExcelUtils(excelPath, sheet);

        excel.getRowCount();
        excel.getCellData(1, 0);
        excel.getCellData(2, 0);
        excel.getCellData(3, 0);
    }
}
