package com.gett.infra.app.utils;

import java.util.Properties;

import static com.gett.infra.app.utils.DBConfig.HBM2DDL;

public class AppSettings {

    private static Properties properties;

    public static void setProperties(Properties properties) {
        AppSettings.properties = properties;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getHbm2ddl() {
        return properties.getProperty(HBM2DDL);
    }

}
