package com.clearpath.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {
        System.out.println("Extent Report Initialized...");
        if (extent == null) {

            ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentReport.html");

            spark.config().setReportName("OrangeHRM Automation Report");
            spark.config().setDocumentTitle("Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
}