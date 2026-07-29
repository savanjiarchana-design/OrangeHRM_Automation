package com.clearpath.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtility {

    public static String captureScreenshot(WebDriver driver, String testName) {

        System.out.println("Screenshot method called");
        String fileName = testName + "_" + System.currentTimeMillis() + ".png";

        String destination = System.getProperty("user.dir") + "/screenshots/" + fileName;

        File folder = new File(System.getProperty("user.dir") + "/screenshots");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(source, new File(destination));
            System.out.println("Screenshot saved : " + destination);
            System.out.println("File exists : " + new File(destination).exists());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "screenshots/" + fileName;
       // return destination;
    }
}