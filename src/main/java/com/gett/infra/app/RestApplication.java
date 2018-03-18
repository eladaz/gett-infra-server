package com.gett.infra.app;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;

public class RestApplication implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        System.out.println("Infra App REST service is up and running");
    }

}
