package com.clearpath.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By txtUsername = By.name("username");
    By txtPassword = By.name("password");
    By btnLogin = By.xpath("//button[@type='submit']");

    public void enterUsername(String username) {
        driver.findElement(txtUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(btnLogin).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public String smartWait(String xpathString) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String actualRes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathString))).getText();
        return actualRes;
    }

    public WebElement waitForElement(String xpath) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public String login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        String actualRes = waitForElement("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']").getText();
        return actualRes;

    }

}