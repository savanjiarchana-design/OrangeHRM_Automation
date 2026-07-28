package com.clearpath.tests;
import com.clearpath.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Reporter;

public class LoginTest extends BaseTest {
    String xpath_error = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']";
    String xpath_dashboard = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']";
    String xpath_invalidCredentials = "//p[text()='Invalid credentials']";

    @Test
    public void verifyLoginValidCredentials() {

        test = extent.createTest("OrangeHRM Login Test with valid username and password");
        test.assignAuthor("Archana Pawar");
        test.assignCategory("Smoke");

        test.info("Launching Browser");

        LoginPage loginPage = new LoginPage(driver);

        test.info("Entering valid Username and password");

        String actualRes = loginPage.login("Admin","admin123",xpath_dashboard);

        test.info("Dashboard Loaded");

        verifyValue(actualRes,"Dashboard");

        test.pass("Login Successful");
    }
    @Test
    public void verifyLoginInvalidCredentials() {
        test.assignAuthor("Archana Pawar");
        test.assignCategory("Smoke");
        test = extent.createTest("OrangeHRM Login Test with invalid username and password");

        test.info("Launching Browser");

        LoginPage loginPage = new LoginPage(driver);

        test.info("Entering invalid Username <user1> and password <pwd123>");

        String actualRes = loginPage.login("user1","pwd123",xpath_invalidCredentials);

        test.info("Incorrect username and password - Error message displayed");

        verifyValue(actualRes,"Invalid credentials");

        test.pass("Test Successful");
    }
    @Test
    public void verifyLoginInvalidUserName() {

        test = extent.createTest("OrangeHRM Login Test with invalid username and correct password");
        test.assignAuthor("Archana Pawar");
        test.assignCategory("Smoke");
        test.info("Launching Browser");

        LoginPage loginPage = new LoginPage(driver);

        test.info("Entering invalid Username <user1> and password <admin123>");

        String actualRes = loginPage.login("user1","admin123",xpath_invalidCredentials);

        test.info("Incorrect username and password - Error message displayed");

        verifyValue(actualRes,"Invalid credentials");

        test.info("Expected: Invalid credentials message should be displayed");
        test.info("Actual: Invalid credentials message displayed");
        test.pass("Validation successful");
    }

    @Test
    public void verifyLoginInvalidPassword() {

        test = extent.createTest("OrangeHRM Login Test with invalid password");
        test.assignAuthor("Archana Pawar");
        test.assignCategory("Smoke");

        test.info("Launching Browser");

        LoginPage loginPage = new LoginPage(driver);

        test.info("Entering invalid Username <Admin> and password <pwd123>");

        String actualRes = loginPage.login("Admin","pwd123",xpath_invalidCredentials);

        test.info("Incorrect username and password - Error message displayed");

        verifyValue(actualRes,"Invalid credentials");

        test.info("Expected: Invalid credentials message should be displayed");
        test.info("Actual: Invalid credentials message displayed");
        test.pass("Validation successful");
    }

    @Test
    public void verifyEmptyCredentials() {

        test = extent.createTest("OrangeHRM Login Test with empty credentials");
        test.assignAuthor("Archana Pawar");
        test.assignCategory("Smoke");

        test.info("Launching Browser");

        LoginPage loginPage = new LoginPage(driver);

        test.info("Keep Username and password empty");

        String actualRes = loginPage.login("","",xpath_error);

        verifyValue(actualRes,"Required");

        test.info("Expected: Required message displayed below username and password input box");
        test.info("Actual: Required message displayed below username and password input box");
        test.pass("Validation successful");
    }
}