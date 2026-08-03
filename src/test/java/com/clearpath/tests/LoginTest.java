package com.clearpath.tests;
import com.clearpath.base.BaseTest;
import com.clearpath.data.LoginDataProvider;
import com.clearpath.pages.LoginPage;
import com.clearpath.utils.ConfigReader;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)

    public void verifyLogin(String TestCaseID,
                            String TestCaseName,
                            String TestCategory,
                            String UserName,
                            String Password,
                            String ExpectedResult,
                            String Locator) {

        test = extent.createTest(TestCaseID+ " - " + TestCaseName);
        test.assignAuthor(ConfigReader.getProperty("Author"));
        test.assignCategory(TestCategory);

        test.info("Launching OrangeHRM application in "+ConfigReader.getProperty("browser")+" browser");
        LoginPage loginPage = new LoginPage(driver);
        test.pass("Application URL: "+driver.getCurrentUrl()+" | Title: "+driver.getTitle());

        test.info("Entering Username : " + UserName);
        test.info("Entering Password: ********");

        String actualResult = loginPage.login(UserName, Password, Locator);

        test.info("Verify expected Result : " + ExpectedResult);
        test.info("Verify actual Result : " + actualResult);
        verifyValue(actualResult, ExpectedResult);

        test.pass("Validation successful");
    }
}