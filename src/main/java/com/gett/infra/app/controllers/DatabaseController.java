package com.gett.infra.app.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gett.infra.app.services.CreditCardService;
import com.gett.infra.hibernate.dao.BaseDao;
import com.gett.infra.hibernate.pojo.datagenerator.CreditCard;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.metamodel.EntityType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static com.gett.infra.app.utils.Paths.CREDIT_CARDS_STATIC_DATA;

@Component
public class DatabaseController extends BaseDao {

    private static CreditCardService creditCardService = new CreditCardService();

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final SessionFactory sessionFactory = getSessionFactory();
    private final static Logger logger = Logger.getLogger(DatabaseController.class);

    //////////////////////////// ENTITIES /////////////////////////////
    public Set<String> getAllMappedEntities() {
        logger.info("*** Get All Mapped Entities - start ***");
        Set<String> entityList = new HashSet<>();

        Set<EntityType<?>> entities = sessionFactory.getMetamodel().getEntities();

        entities.forEach((entity) -> {
            entityList.add(entity.getName());
        });

        logger.info("*** Get All Mapped Entities - end ***");
        return entityList;
    }

    //////////////////////////// CREDIT CARDS /////////////////////////////

    //GET
    public CreditCard getCreditCard(String id) {
        return creditCardService.findById(id);
    }

    public List<CreditCard> getCreditCards(String property, String value) {
        return creditCardService.findBySpecificProperty(property, value);
    }

    public List<CreditCard> getAllCreditCards() {
        return creditCardService.findAll();
    }

    //ADD
    public void addCreditCard(CreditCard creditCard) {
        creditCardService.persist(creditCard);
    }

    public void addAllCreditCards(List<CreditCard> creditCards) {
        creditCardService.batchProcessing(creditCards);
    }

    public void addAllStaticCreditCards() {
        List<CreditCard> creditCards = new ArrayList<>();
        File[] files = new File(Objects.requireNonNull(DatabaseController.class
                        .getClassLoader()
                        .getResource(CREDIT_CARDS_STATIC_DATA)).getPath()).listFiles();

        for (File file : Objects.requireNonNull(files)) {
            if (file.isFile()) {
                try {
                    List<CreditCard> cards = objectMapper.readValue(new FileInputStream(file),
                            new TypeReference<List<CreditCard>>() {});
                    creditCards.addAll(cards);
                } catch (IOException e) {
                    logger.error("Failed to add all credit cards: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        creditCardService.batchProcessing(creditCards);
    }


    // DELETE
    public void deleteCreditCard(String id) {
        creditCardService.delete(id);
    }

    public void deleteAllCreditCards() {
        creditCardService.deleteAll();
    }

}
