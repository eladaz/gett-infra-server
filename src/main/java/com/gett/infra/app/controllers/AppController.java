package com.gett.infra.app.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static com.gett.infra.app.utils.Paths.*;

@Component
public class AppController {

    private final static Logger logger = Logger.getLogger(AppController.class);

    private static final String NO_VERSION_FOUND = "NO_VERSION_FOUND";
    private static final String NO_LOG_FOUND = "NO_LOG_FOUND";

    public String getVersion() {
        return loadVersion();
    }

    public String getLogs() {
        return loadLogs();
    }

    //PRIVATE METHODS
    private String loadVersion() {
        String version = null;
        try (InputStream stream = AppController.class.getResourceAsStream(MY_PROPERTIES_FILE_PATH)) {
            if (stream == null) {
                logger.warn("Could not find version file, the version api will return null");
                return NO_VERSION_FOUND;
            }

            Scanner scanner = new Scanner(stream, "UTF-8").useDelimiter("\\A");
            while(scanner.hasNext()) {
                version = scanner.nextLine();
                if (version.contains("app.version")) {
                    break;
                }
            }

            return version.split("=")[1];
        } catch (Exception e) {
            logger.warn("Could not read version file, the version api will return null", e);
            return NO_VERSION_FOUND;
        }
    }

    private String loadLogs() {
        try (InputStream stream = new FileInputStream(new File(LOG4J_OUTPUT_FILE_PATH))) {
            return new Scanner(stream, "UTF-8").useDelimiter("\\A").next();
        } catch (Exception e) {
            logger.warn("Could not read log file, the log api will return null", e);
            return NO_LOG_FOUND;
        }
    }



}
