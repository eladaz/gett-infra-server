package com.gett.infra.app.services;

import com.gett.infra.hibernate.dao.CreditCardDao;
import com.gett.infra.hibernate.pojo.datagenerator.CreditCard;
import org.apache.log4j.Logger;

import java.util.List;

public class CreditCardService {

    private static CreditCardDao creditCardDao;
    private final static Logger logger = Logger.getLogger(CreditCardService.class);

    public CreditCardService() {
        creditCardDao = new CreditCardDao();
    }

    public void persist(CreditCard entity) {
        logger.info("*** Persist CreditCard - start ***");
        creditCardDao.openCurrentSessionwithTransaction();
        creditCardDao.persist(entity);
        creditCardDao.closeCurrentSessionwithTransaction();
        logger.info("*** Persist CreditCard - end ***");
    }

    public void update(CreditCard entity) {
        creditCardDao.openCurrentSessionwithTransaction();
        creditCardDao.update(entity);
        creditCardDao.closeCurrentSessionwithTransaction();
    }

    public CreditCard findById(String id) {
        creditCardDao.openCurrentSession();
        CreditCard creditCard = creditCardDao.findById(id);
        creditCardDao.closeCurrentSession();
        return creditCard;
    }

    public void delete(String id) {
        creditCardDao.openCurrentSessionwithTransaction();
        CreditCard creditCard = creditCardDao.findById(id);
        creditCardDao.delete(creditCard);
        creditCardDao.closeCurrentSessionwithTransaction();
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
        creditCardDao.openCurrentSessionwithTransaction();
        creditCardDao.deleteAll();
        creditCardDao.closeCurrentSessionwithTransaction();
    }

    public CreditCardDao creditCardDao() {
        return creditCardDao;
    }

}
