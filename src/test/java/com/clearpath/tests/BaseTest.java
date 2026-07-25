package com.clearpath.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.clearpath.utils.ExtentManager;

public class BaseTest {

    public WebDriver driver;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeMethod
    public void setup() {

        extent = ExtentManager.getReport();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "OrangeHRM");
    }

    public void verifyValue(String actualRes, String expectedRes){
        Assert.assertEquals(actualRes, expectedRes, "Validation failed");
    }

    @AfterMethod
    public void tearDown() {
        extent.flush();
        if (driver != null) {
            driver.quit();
        }
    }
}