package com.gett.infra.hibernate.dao;

import com.gett.infra.hibernate.pojo.datagenerator.PhoneNumber;

import java.util.List;

public class PhoneNumberDao extends BaseDao implements EntityDaoInterface<PhoneNumber, String> {

    private static final String entityName = "PhoneNumber";

    @Override
    public void persist(PhoneNumber entity) {
        getCurrentSession().save(entity);

    }

    @Override
    public void update(PhoneNumber entity) {
        getCurrentSession().update(entity);

    }

    @Override
    public PhoneNumber findById(String id) {
        PhoneNumber phoneNumber = (PhoneNumber) getCurrentSession().get(PhoneNumber.class, id);
        return phoneNumber;
    }

    @Override
    public void delete(PhoneNumber entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<PhoneNumber> findAll() {
        List<PhoneNumber> phoneNumbers = (List<PhoneNumber>) getCurrentSession().createQuery(String.format("From %s", entityName)).list();
        return phoneNumbers;

    }

    @Override
    public void deleteAll() {
        List<PhoneNumber> entityList = findAll();
        for (PhoneNumber entity : entityList) {
            delete(entity);
        }

    }
}
