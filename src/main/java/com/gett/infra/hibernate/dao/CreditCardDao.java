package com.gett.infra.hibernate.dao;

import com.gett.infra.hibernate.pojo.datagenerator.CreditCard;

import java.util.List;

public class CreditCardDao extends BaseDao implements EntityDaoInterface<CreditCard, String> {

    private static final String entityName = "CreditCard";

    @Override
    public void persist(CreditCard entity) {
        getCurrentSession().save(entity);

    }

    @Override
    public void update(CreditCard entity) {
        getCurrentSession().update(entity);

    }

    @Override
    public CreditCard findById(String id) {
        CreditCard creditCard = (CreditCard) getCurrentSession().get(CreditCard.class, id);
        return creditCard;
    }

    @Override
    public void delete(CreditCard entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CreditCard> findAll() {
        List<CreditCard> creditCard = (List<CreditCard>) getCurrentSession().createQuery(String.format("From %s", entityName)).list();
        return creditCard;

    }

    @Override
    public void deleteAll() {
        List<CreditCard> entityList = findAll();
        for (CreditCard entity : entityList) {
            delete(entity);
        }

    }
}
