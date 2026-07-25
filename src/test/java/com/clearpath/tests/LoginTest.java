package com.clearpath.tests;


import com.clearpath.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Reporter;

public class LoginTest extends BaseTest {
    @Test
    public void verifyLogin() {

        test = extent.createTest("OrangeHRM Login Test");

        test.info("Launching Browser");

        LoginPage loginPage = new LoginPage(driver);

        test.info("Entering Username and password");

        String actualRes = loginPage.login("Admin","admin123");

        test.info("Dashboard Loaded");

        verifyValue(actualRes,"Dashboard");

        test.pass("Login Successful");
    }
}