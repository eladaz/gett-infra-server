package com.gett.infra.hibernate.dao;

import com.gett.infra.hibernate.pojo.datagenerator.CreditCard;
import org.hibernate.Session;

import java.util.List;

public class CreditCardDao extends BaseDao implements EntityDaoInterface<CreditCard, String> {

    private static final String entityName = "CreditCard";

    @Override
    public void persist(CreditCard entity) {
        getCurrentSession().save(entity);

    }

    @Override
    public void batchProcessing(List<CreditCard> entities) {
        final int[] count = {0};
        Session currentSession = getCurrentSession();
        entities.forEach((entity) -> {
            currentSession.save(entity);
            if( count[0] % 50 == 0 ) {
                //flush a batch of inserts and release memory:
                currentSession.flush();
                currentSession.clear();
            }
            count[0]++;
        });
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
