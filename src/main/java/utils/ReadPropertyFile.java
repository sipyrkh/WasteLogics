package utils;

import logger.LoggerApp;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ReadPropertyFile {

    private static Properties properties;

    static {
        properties = new Properties();
        URL propsConfig = ClassLoader.getSystemResource("config.properties");
        URL propsTestData = ClassLoader.getSystemResource("testData.xml");
        try {
            properties.load(propsConfig.openStream());
            properties.loadFromXML(propsTestData.openStream());
            LoggerApp.info("User data was read from XML-file");
        } catch (IOException e) {
            e.printStackTrace();
            LoggerApp.fatal("User data wasn't read from XML-file");
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    public static String getTestData(String key){
        return properties.getProperty(key);
    }

    public static String getLocalizationData(String key){
        return properties.getProperty(key);
    }
}