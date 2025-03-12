package com.SwagLabs.Utilites.DataDriven;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesFile {


    public static String CONFIG_PATH = "src/main/resources/PropertiesFiles/";

    public static String getConfigValue(String fileName, String key) {
        try {
            Properties properties = new Properties();


            try (InputStreamReader reader = new InputStreamReader(
                    Files.newInputStream(Paths.get(CONFIG_PATH + fileName + ".properties")), StandardCharsets.UTF_8)) {
                properties.load(reader);

            }

            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
