package com.gett.infra.app.utils;

import java.io.File;

import static com.gett.infra.app.utils.Paths.*;

public class ConfigProperties {

    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String TARGET_DIRECTORY = USER_DIR + File.separator + "target";

    public static final String MY_PROPERTIES_FILE_PATH = File.separator + MY_PROPERTIES_FILE;
    public static final String LOG4J_OUTPUT_FILE_PATH = TARGET_DIRECTORY + File.separator + LOG4J_OUTPUT_FILE;


    //GITHUB
    public static final String GITHUB_REPO = "https://github.com/eladaz/gett-infra-server";

    //DATABASE
//    public static final String DATABASE_NAME = "localhost";
//    public static final String DATABASE_PORT = "3306/rest_service";
//    public static final String DATABASE_SERVICE_NAME = "rest_service";
//    public static final String DATABASE_USER_NAME = "root";
//    public static final String DATABASE_PASSWORD = "A361561y";

}
