package com.clearpath.data;

import com.clearpath.utils.ConfigReader;
import com.clearpath.utils.ExcelUtility;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")

    public Object[][] getLoginData() throws Exception {

        String filePath = ConfigReader.getProperty("TestDataSheetPath");

        ExcelUtility excel = new ExcelUtility(filePath, ConfigReader.getProperty("TestDataSheet"));

        int rows = excel.getRowCount();
        int cols = excel.getColumnCount();

        Object[][] data = new Object[rows][cols];

        System.out.println("Data File : " + filePath+ConfigReader.getProperty("TestDataSheet"));
        for (int i = 1; i <= rows; i++) {
            System.out.println("Reading Row = " + i);

            for (int j = 0; j < cols; j++) {
                System.out.println("Row=" + i + " Col=" + j);
                data[i - 1][j] = excel.getCellData(i, j);
            }
        }

        excel.closeWorkbook();

        return data;
    }
}