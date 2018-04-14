package com.gett.infra.app.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gett.infra.app.controllers.DatabaseController;
import com.gett.infra.hibernate.pojo.datagenerator.CreditCard;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.gett.infra.app.rest.Constants.Rest.*;
import static java.lang.String.format;

@Controller
@RequestMapping(API)
public class CreditCardResource {

    @Autowired
    DatabaseController databaseController;

    private final static Logger logger = Logger.getLogger(CreditCardResource.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    //GET RESOURCES
    @RequestMapping(value = CREDIT_CARD + ENTITY_ID, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getCreditCardById(@PathVariable(ID) String id) {
        logger.info(format("Calling %s request, Resource: %s\n", RequestMethod.GET, getMethodName()));
        CreditCard creditCard = databaseController.getCreditCard(id);
        String response = new Gson().toJson(creditCard);
        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(response);
    }

    // POST RESOURCES
    @RequestMapping(value = CREDIT_CARD, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> addCreditCard(@RequestBody String jsonString) {
        logger.info(format("Calling %s request, Resource: %s\n", RequestMethod.POST, getMethodName()));
        try {
            List<CreditCard> dto = new ArrayList<>();
            JSONArray creditCardArray = new JSONArray(jsonString);
            if (creditCardArray.length() == 1) {
                CreditCard card = objectMapper.readValue(creditCardArray.getString(0), CreditCard.class);
                databaseController.addCreditCard(card);
            } else {
                for (int i = 0; i < creditCardArray.length(); i++) {
                    dto.add(objectMapper.readValue(creditCardArray.getString(i), CreditCard.class));
                }
                databaseController.addAllCreditCards(dto);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Failed to add credit card/s: " + e.getMessage());
        }

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(jsonString);
    }

}
