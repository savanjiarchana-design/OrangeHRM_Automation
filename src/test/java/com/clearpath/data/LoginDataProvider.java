package com.clearpath.data;

import com.clearpath.utils.ExcelUtility;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws Exception {

        String filePath = "src/main/resources/testdata/LoginData.xlsx";

        ExcelUtility excel = new ExcelUtility(filePath, "LoginData");

        int rows = excel.getRowCount();
        int cols = excel.getColumnCount();

        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = excel.getCellData(i, j);
            }
        }

        excel.closeWorkbook();

        return data;
    }
}