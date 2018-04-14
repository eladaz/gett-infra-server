package com.gett.infra.app.utils;

import org.apache.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import static com.gett.infra.app.utils.Paths.*;

public class DBConfig {

    private static Properties properties;
    private static InputStream inputStream;
    private final static Logger logger = Logger.getLogger(DBConfig.class);

    public static final String TYPE = "db.type";
    public static final String HBM2DDL = "hibernate.hbm2ddl.auto";
    public static final String SHOWSQL = "hibernate.show_sql";
    public static final String CONNECTION_URL = "hibernate.connection.url";
    public static final String CONNECTION_DRIVER = "hibernate.connection.driver_class";
    public static final String DB_HOST_NAME = "hibernate.db.host";
    public static final String PORT = "hibernate.db.port";
    public static final String DB_TABLE = "hibernate.db.table";
    public static final String SSL = "hibernate.db.use.ssl";
    public static final String USER_NAME = "hibernate.connection.username";
    public static final String PASSWORD = "hibernate.connection.password";

    private static String jdbc = "jdbc:<type>://<host_name>:<port>/<table>?useSSL=<ssl>&autoReconnect=true";

    private void getProperties() throws IOException {
        try {
            properties = new Properties();

            inputStream = getClass().getClassLoader().getResourceAsStream(DB_PROPERTIES_PATH);

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + DB_PROPERTIES_PATH + "' not found in the classpath");
            }

            // get the property value and print it out
            String user = properties.getProperty("user");

            Date time = new Date(System.currentTimeMillis());
            logger.debug("[" + user + "] " + time + " Load properties configuration...");

        } catch (Exception e) {
            logger.error("Exception: " + e);
            throw new RuntimeException("failed to read " + DB_PROPERTIES_PATH, e);
        } finally {
            inputStream.close();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String DB_TYPE = System.getProperty(TYPE,
            readStringProperty(TYPE,"mysql")
    );

    public String DB_CONNECTION_DRIVER = System.getProperty(CONNECTION_DRIVER,
            readStringProperty(CONNECTION_DRIVER,"com.mysql.cj.jdbc.Driver")
    );

    public String DB_HOST = System.getProperty(DB_HOST_NAME,
            readStringProperty(DB_HOST_NAME, "localhost")
    );

    public String DB_PORT = System.getProperty(PORT,
            readStringProperty(PORT, "8080")
    );

    public String DB_TABLE_NAME = System.getProperty(DB_TABLE,
            readStringProperty(DB_TABLE, "rest_service")
    );

    public String USE_SSL = System.getProperty(SSL,
            readStringProperty(SSL, "false")
    );

    public String DB_USER_NAME = System.getProperty(USER_NAME,
            readStringProperty(USER_NAME, "root")
    );

    public String DB_PASSWORD = System.getProperty(PASSWORD,
            readStringProperty(PASSWORD, "A361561y")
    );

    public String HBM2_DDL = System.getProperty(HBM2DDL,
            readStringProperty(HBM2DDL, "update")
    );

    public String SHOW_SQL = System.getProperty(SHOWSQL,
            readStringProperty(SHOWSQL, "false")
    );

    public String JDBC_CONNECTION = buildURL();

    private String readStringProperty(String name, String defaultValue) {
        if (properties == null) {
            try {
                getProperties();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("Exception: " + e);
                throw new RuntimeException("failed to read " + DB_PROPERTIES_PATH, e);
            }
        }

        String property = properties.getProperty(name);

        if (property == null || property.isEmpty()) {
            property = defaultValue;
        }
        return property;
    }

    private String buildURL() {
        return jdbc.replace("<type>", DB_TYPE)
                   .replace("<host_name>", DB_HOST)
                   .replace("<port>", DB_PORT)
                   .replace("<table>", DB_TABLE_NAME)
                   .replace("<ssl>", USE_SSL);
    }

}
