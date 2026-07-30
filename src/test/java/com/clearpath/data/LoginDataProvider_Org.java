package com.clearpath.data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider_Org {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][]{
                {"Verify login with valid credentials","Admin", "admin123", "Dashboard", "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']","smoke"},

                {"Verify login with invalid password","Admin", "pwd123", "Invalid credentials", "//p[text()='Invalid credentials']","regression"},

                {"Verify login with invalid username","user1", "admin123", "Invalid credentials", "//p[text()='Invalid credentials']","regression"},

                {"Verify login with invalid credentials for username and password","user2", "pwd123", "Invalid credentials", "//p[text()='Invalid credentials']","regression"},

                {"Verify login with empty inputs","", "", "Required", "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']","regression"},

                {"Test to check proper screenshot is captured when test failed","Admin", "admin123", "Dashboard123", "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']","negative"}
        };
    }
}