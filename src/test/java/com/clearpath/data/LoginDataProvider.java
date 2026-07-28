package com.clearpath.data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][]{
                {"Verify login with valid credentials","Admin", "admin123", "Dashboard", "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"},

                {"Verify login with invalid password","Admin", "pwd123", "Invalid credentials", "//p[text()='Invalid credentials']"},

                {"Verify login with invalid username","user1", "admin123", "Invalid credentials", "//p[text()='Invalid credentials']"},

                {"Verify login with invalid credentials for username and password","user2", "pwd123", "Invalid credentials", "//p[text()='Invalid credentials']"},

                {"Verify login with empty inputs","", "", "Required", "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"}
        };
    }
}