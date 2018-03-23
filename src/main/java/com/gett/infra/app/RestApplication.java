package com.gett.infra.app;

import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;

public class RestApplication implements WebApplicationInitializer {

    private final static Logger logger = Logger.getLogger(RestApplication.class);

    @Override
    public void onStartup(ServletContext container) {
        logger.info("Gett Automation Infra REST service is up and running");
    }

}
