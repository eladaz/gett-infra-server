package com.gett.infra.app.utils;

import java.io.File;

public class Paths {

    public static final String TARGET = "target";
    public static final String STATIC_DATA = "staticdata";
    public static final String HIBERNATE_DIR = "hibernate";
    public static final String CREDIT_CARD_DIR = "creditcard";
    public static final String DATAGENERATOR = "datagenerator";
    public static final String HBM_EXTENSION = "hbm.xml";
    public static final String HIBERNATE_CFG = "hibernate.cfg.xml";
    public static final String DB_PROPERTIES_FILE = "db.properties";
    public static final String MY_PROPERTIES_FILE = "my.properties";
    public static final String LOG4J_OUTPUT_FILE = "log4j-application.log";


    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String TARGET_DIRECTORY = USER_DIR + File.separator + TARGET;
    public static final String MY_PROPERTIES_FILE_PATH = File.separator + MY_PROPERTIES_FILE;
    public static final String DB_PROPERTIES_PATH = HIBERNATE_DIR + File.separator + DB_PROPERTIES_FILE;
    public static final String HIBERNATE_CONF_FILE = HIBERNATE_DIR + File.separator + HIBERNATE_CFG;
    public static final String HIBERNATE_MAPPING_DIR = HIBERNATE_DIR + File.separator + DATAGENERATOR;
    public static final String HIBERNATE_STATIC_DATA_DIR = HIBERNATE_DIR + File.separator + STATIC_DATA;
    public static final String LOG4J_OUTPUT_FILE_PATH = TARGET_DIRECTORY + File.separator + LOG4J_OUTPUT_FILE;
    public static final String CREDIT_CARDS_STATIC_DATA = HIBERNATE_STATIC_DATA_DIR + File.separator + CREDIT_CARD_DIR;


    //GITHUB
    public static final String GITHUB_REPO = "https://github.com/eladaz/gett-infra-server";



}
