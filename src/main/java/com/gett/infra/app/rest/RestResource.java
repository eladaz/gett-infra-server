package com.gett.infra.app.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gett.infra.app.controllers.AppController;
import com.gett.infra.app.controllers.DatabaseController;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

import static com.gett.infra.app.rest.Constants.Rest.*;
import static com.gett.infra.app.rest.Constants.Rest.HOME;
import static java.lang.String.format;

@Controller
@RequestMapping(API)
public class RestResource {

    @Autowired
    AppController appController;

    @Autowired
    DatabaseController databaseController;

    private final static Logger logger = Logger.getLogger(RestResource.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    //GET HOME PAGE
    @RequestMapping(value = {INDEX, HOME}, method = RequestMethod.GET)
    public ModelAndView index() {
        logger.info(format("Calling %s request, Resource: %s\n", RequestMethod.GET, getMethodName()));
        ModelAndView mvc = new ModelAndView("index");
        return mvc;
    }

    //GET RESOURCES
    @RequestMapping(value = VERSION, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getVersion() {
        logger.info(format("Calling %s request, Resource: %s\n", RequestMethod.GET, getMethodName()));
        String version = appController.getVersion();
        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(version);
    }

    @RequestMapping(value = LOGS, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getLogs() {
        logger.info(format("Calling %s request, Resource: %s\n", RequestMethod.GET, getMethodName()));
        String logs = appController.getLogs();
        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(logs);
    }

    @RequestMapping(value = ENTITIES, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getAllEntities() {
        logger.info(format("Calling %s request, Resource: %s\n", RequestMethod.GET, getMethodName()));
        Set<String> logs = databaseController.getAllMappedEntities();
        String json = new Gson().toJson(logs);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(json);
    }

}
