package com.gett.infra.app.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gett.infra.app.controllers.AppController;
import com.gett.infra.app.dto.CreditCardDTO;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.gett.infra.app.rest.Constants.Rest.*;
import static java.lang.String.format;

@Controller
@RequestMapping(API)
public class RestAPI {

    @Autowired
    AppController appController;

    private final static Logger logger = Logger.getLogger(RestAPI.class);
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

    // GET RESOURCES
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

    // POST RESOURCES
    @RequestMapping(value = CREDIT_CARD, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> addCreditCard(@RequestBody String jsonString) {
        try {
            List<CreditCardDTO> dtos = new ArrayList<>();
            JSONArray testsArray = new JSONArray(jsonString);
            for (int i = 0; i < testsArray.length(); i++) {
                dtos.add(objectMapper.readValue(testsArray.getString(i), CreditCardDTO.class));
            }

            logger.info(format("Calling %s request, Resource: %s\n", RequestMethod.POST, getMethodName()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("");
    }

}
