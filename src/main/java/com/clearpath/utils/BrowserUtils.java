package com.clearpath.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtils {

    WebDriver driver;

    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement waitForElement(String xpath) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }


}
