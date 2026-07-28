package com.clearpath.tests;
import com.clearpath.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Reporter;
import com.clearpath.data.LoginDataProvider;

public class LoginTest extends BaseTest {
    String xpath_error = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']";
    String xpath_dashboard = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']";
    String xpath_invalidCredentials = "//p[text()='Invalid credentials']";

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)

    public void verifyLogin(String testName,
                            String username,
                            String password,
                            String expectedResult,
                            String locator) {

        test = extent.createTest(
                testName +
                        " | Username: " + username +
                        " | Password: " + password
        );

        test.assignAuthor("Archana Pawar");
        test.assignCategory("Smoke");

        test.info("launching browser - OrangeHRM" );
        LoginPage loginPage = new LoginPage(driver);

        test.info("Entering Username : " + username);
        test.info("Entering Password: " + password);

        String actualResult = loginPage.login(username, password, locator);

        test.info("Verify expected Result : " + expectedResult);
        test.info("Verify actual Result : " + actualResult);
        verifyValue(actualResult, expectedResult);

        test.pass("Validation successful");
    }
}