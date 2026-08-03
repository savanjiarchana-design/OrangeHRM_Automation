package com.clearpath.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

    private Workbook workbook;
    private Sheet sheet;
    private FileInputStream fis;

    public ExcelUtility(String filePath, String sheetName) throws IOException {
        fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);

    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    public int getColumnCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    /*
    public String getCellData(int row, int col) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(row).getCell(col));
    }
    */

    public String getCellData(int row, int col) {

        DataFormatter formatter = new DataFormatter();

        Row currentRow = sheet.getRow(row);

        if(currentRow == null){
            System.out.println("Row is NULL : " + row);
            return "";
        }

        Cell cell = currentRow.getCell(col);

        if(cell == null){
            System.out.println("Cell is NULL : Row=" + row + " Col=" + col);
            return "";
        }

        return formatter.formatCellValue(cell);
    }

    public void closeWorkbook() throws IOException {
        workbook.close();
        fis.close();
    }
}