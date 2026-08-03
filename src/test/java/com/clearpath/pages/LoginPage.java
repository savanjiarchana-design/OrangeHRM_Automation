package com.clearpath.pages;

import com.clearpath.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {

    WebDriver driver;
    BrowserUtils browserUtils;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.browserUtils = new BrowserUtils(driver);
    }

    By txtUsername = By.name("username");
    By txtPassword = By.name("password");
    By btnLogin = By.xpath("//button[@type='submit']");

    public void enterUsername(String username) {
        browserUtils.waitForVisibility(txtUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        browserUtils.waitForVisibility(txtPassword).sendKeys(password);
    }

    public void clickLogin() {
        browserUtils.waitForClickable(btnLogin).click();
    }

    public String login(String username, String password, String xpathStr) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();

        return browserUtils.waitForElement(xpathStr).getText();

    }

}