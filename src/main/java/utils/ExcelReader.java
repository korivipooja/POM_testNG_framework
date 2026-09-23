package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public static Object[][] getExcelData(String filePath,String sheetName) throws IOException {
        FileInputStream fileInputStream= new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet= workbook.getSheet(sheetName);
        int rowCount= sheet.getPhysicalNumberOfRows();
        int columnCount= sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data= new Object[rowCount-1][columnCount];
        for(int i=1;i<rowCount;i++){
            Row row= sheet.getRow(i);
            for(int j=0;j<columnCount;j++){
                Cell cell= row.getCell(j);
                data[i-1][j]= cell.getStringCellValue();
            }
        }
workbook.close();
        fileInputStream.close();
        return data;


    }
}
