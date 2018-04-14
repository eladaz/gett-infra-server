package com.gett.infra.app.controllers;

import com.gett.infra.app.utils.AppSettings;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.gett.infra.app.constants.Schema.CREATE;

@Component
public class BaseLine {

    @Autowired
    DatabaseController databaseController;

    private final static Logger logger = Logger.getLogger(BaseLine.class);

//    @EventListener(ContextRefreshedEvent.class)
    @PostConstruct
    public void init() {
        dbDataInitialization();
    }

    private void dbDataInitialization() {
        if (AppSettings.getHbm2ddl().contains(CREATE.getKey())) {
            logger.info("*** BaseLine DataBase instantiate - start ***");
            databaseController.addAllStaticCreditCards();
            logger.info("*** BaseLine DataBase instantiate - end ***");
        }
    }

}
