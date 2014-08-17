package com.sunset.framework;

import java.io.InputStream;
import java.util.Properties;

public class DriverConfiguration {

    private static final String PROPERTIES_FILE_PATH = "/default.properties";

    static {
        props = new Properties();
        loadPropertiesFromFile();
    }

    private static void loadPropertiesFromFile() {

        InputStream propsStream;
        try {
            propsStream = DriverConfiguration.class.getResourceAsStream(PROPERTIES_FILE_PATH);
            props.load(propsStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Properties props;

    private static String getProp(String key) {
        String s = props.getProperty(key);
        return (s != null) ? s.trim() : s;
    }

    public static String getBaseUrl() {
        return getProp("url");
    }
}
