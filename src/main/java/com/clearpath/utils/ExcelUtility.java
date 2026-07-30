package com.clearpath.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtility(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    public int getColumnCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    public String getCellData(int row, int col) {
        return sheet.getRow(row).getCell(col).toString();
    }

    public void closeWorkbook() throws IOException {
        workbook.close();
    }
}