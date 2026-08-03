package com.clearpath.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static void loadProperties(String fileName) {
        try {
            FileInputStream fis =
                    new FileInputStream("src/main/resources/" + fileName);

            properties = new Properties();
            properties.load(fis);
            fis.close();

        } catch (IOException e) {
            throw new RuntimeException("Unable to load " + fileName, e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}