package TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ReadExcel {

    public String[][] readData() throws IOException, InvalidFormatException {
        File myExcel = new File(".\\TestData\\LUMA_credentials.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(myExcel);
        XSSFSheet mySheet = wb.getSheet("Sheet1");

        int numberOfRows = mySheet.getPhysicalNumberOfRows();
        int numberOfCols = mySheet.getRow(0).getLastCellNum();
        String[][] myArray = new String[numberOfRows - 1][numberOfCols];

        for (int x = 1; x < numberOfRows; x++) {
            XSSFRow row = mySheet.getRow(x);
            for (int y = 0; y < numberOfCols; y++) {
                myArray[x - 1][y] = row.getCell(y).getStringCellValue();
            }
        }
        return myArray;
    }

}
