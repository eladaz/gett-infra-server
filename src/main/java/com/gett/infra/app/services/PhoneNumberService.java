package com.gett.infra.app.services;

import com.gett.infra.hibernate.dao.PhoneNumberDao;
import com.gett.infra.hibernate.pojo.datagenerator.PhoneNumber;
import org.apache.log4j.Logger;

import java.util.List;

public class PhoneNumberService {

    private static PhoneNumberDao phoneNumberDao;
    private final static Logger logger = Logger.getLogger(PhoneNumberService.class);

    public PhoneNumberService() {
        phoneNumberDao = new PhoneNumberDao();
    }

    public void persist(PhoneNumber entity) {
        logger.info("*** Persist PhoneNumber - start ***");
        phoneNumberDao.openCurrentSessionwithTransaction();
        phoneNumberDao.persist(entity);
        phoneNumberDao.closeCurrentSessionwithTransaction();
        logger.info("*** Persist PhoneNumber - end ***");
    }

    public void update(PhoneNumber entity) {
        phoneNumberDao.openCurrentSessionwithTransaction();
        phoneNumberDao.update(entity);
        phoneNumberDao.closeCurrentSessionwithTransaction();
    }

    public PhoneNumber findById(String id) {
        phoneNumberDao.openCurrentSession();
        PhoneNumber phoneNumber = phoneNumberDao.findById(id);
        phoneNumberDao.closeCurrentSession();
        return phoneNumber;
    }

    public void delete(String id) {
        phoneNumberDao.openCurrentSessionwithTransaction();
        PhoneNumber phoneNumber = phoneNumberDao.findById(id);
        phoneNumberDao.delete(phoneNumber);
        phoneNumberDao.closeCurrentSessionwithTransaction();
    }

    public List<PhoneNumber> findAll() {
        logger.info("*** Find All Persisted PhoneNumber - start ***");
        phoneNumberDao.openCurrentSession();
        List<PhoneNumber> phoneNumbers = phoneNumberDao.findAll();
        phoneNumberDao.closeCurrentSession();
        logger.info("Find " + phoneNumbers.size() + " Persisted PhoneNumber!");
        logger.info("*** Find All Persisted PhoneNumber - end ***");
        return phoneNumbers;
    }

    public void deleteAll() {
        phoneNumberDao.openCurrentSessionwithTransaction();
        phoneNumberDao.deleteAll();
        phoneNumberDao.closeCurrentSessionwithTransaction();
    }

    public PhoneNumberDao creditCardDao() {
        return phoneNumberDao;
    }

}
