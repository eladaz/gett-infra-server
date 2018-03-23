package com.gett.infra.app.services;

import com.gett.infra.hibernate.dao.CreditCardDao;
import com.gett.infra.hibernate.pojo.datagenerator.CreditCard;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreditCardService {

    private static CreditCardDao creditCardDao;
    private final static Logger logger = Logger.getLogger(CreditCardService.class);

    public CreditCardService() {
        creditCardDao = new CreditCardDao();
    }

    public void persist(CreditCard entity) {
        logger.info("*** Persist CreditCard - start ***");
        creditCardDao.openCurrentSessionWithTransaction();
        creditCardDao.persist(entity);
        creditCardDao.closeCurrentSessionWithTransaction();
        logger.info("*** Persist CreditCard - end ***");
    }

    public void batchProcessing(List<CreditCard> entities) {
        logger.info("*** Batch Processing CreditCards - start ***");
        creditCardDao.openCurrentSessionWithTransaction();
        creditCardDao.batchProcessing(entities);
        creditCardDao.closeCurrentSessionWithTransaction();
        logger.info("*** Batch Processing CreditCards - end ***");
    }

    public void update(CreditCard entity) {
        creditCardDao.openCurrentSessionWithTransaction();
        creditCardDao.update(entity);
        creditCardDao.closeCurrentSessionWithTransaction();
    }

    public CreditCard findById(String id) {
        creditCardDao.openCurrentSession();
        CreditCard creditCard = creditCardDao.findById(id);
        creditCardDao.closeCurrentSession();
        return creditCard;
    }

    public void delete(String id) {
        creditCardDao.openCurrentSessionWithTransaction();
        CreditCard creditCard = creditCardDao.findById(id);
        creditCardDao.delete(creditCard);
        creditCardDao.closeCurrentSessionWithTransaction();
    }

    public List<CreditCard> findAll() {
        logger.info("*** Find All Persisted CreditCards - start ***");
        creditCardDao.openCurrentSession();
        List<CreditCard> creditCards = creditCardDao.findAll();
        creditCardDao.closeCurrentSession();
        logger.info("Find " + creditCards.size() + " Persisted CreditCards!");
        logger.info("*** Find All Persisted CreditCards - end ***");
        return creditCards;
    }

    public void deleteAll() {
        creditCardDao.openCurrentSessionWithTransaction();
        creditCardDao.deleteAll();
        creditCardDao.closeCurrentSessionWithTransaction();
    }

    public CreditCardDao creditCardDao() {
        return creditCardDao;
    }

}
