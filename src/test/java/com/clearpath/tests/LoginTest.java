package com.clearpath.tests;
import com.clearpath.base.BaseTest;
import com.clearpath.pages.LoginPage;
import org.testng.annotations.Test;
import com.clearpath.data.LoginDataProvider;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)

    public void verifyLogin(String testName,
                            String username,
                            String password,
                            String expectedResult,
                            String locator,
                            String testType) {

        test = extent.createTest(
                testName +
                        " | Username: " + username +
                        " | Password: " + password
        );

        test.assignAuthor("Archana Pawar");
        test.assignCategory(testType);
        test.info("Browser: Chrome");

        test.info("launching browser - OrangeHRM" );
        LoginPage loginPage = new LoginPage(driver);
        test.pass("Current URL: "+driver.getCurrentUrl()+" | Title: "+driver.getTitle());
        test.info("Entering Username : " + username);
        test.info("Entering Password: ********");

        String actualResult = loginPage.login(username, password, locator);

        test.info("Verify expected Result : " + expectedResult);
        test.info("Verify actual Result : " + actualResult);
        verifyValue(actualResult, expectedResult);

        test.pass("Validation successful");
    }
}