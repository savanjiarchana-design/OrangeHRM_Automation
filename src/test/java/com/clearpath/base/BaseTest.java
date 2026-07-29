package com.clearpath.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.clearpath.utils.ExtentManager;

import org.testng.ITestResult;
import com.clearpath.utils.ScreenshotUtility;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseTest {

    public WebDriver driver;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeMethod
    public void setup() {

        extent = ExtentManager.getReport();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Current URL: "+driver.getCurrentUrl()+" | Title: "+driver.getTitle());
       }

    public void verifyValue(String actualRes, String expectedRes){
        Assert.assertEquals(actualRes, expectedRes, "Validation failed");
    }

    @BeforeSuite
    public void cleanScreenshotFolder() {

        File folder = new File(System.getProperty("user.dir") + "/screenshots");

        if (folder.exists()) {

            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
        }
    }
        @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

                String path = ScreenshotUtility.captureScreenshot(driver, result.getName());
                test.addScreenCaptureFromPath(path);
                test.info("Screenshot path: "+path);
                test.fail("Screenshot: ", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
                test.fail(result.getThrowable());
            }

        extent.flush();
        if (driver != null) {
            driver.quit();
        }
    }
}