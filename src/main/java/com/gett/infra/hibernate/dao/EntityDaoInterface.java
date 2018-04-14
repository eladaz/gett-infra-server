package com.gett.infra.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface EntityDaoInterface<T, Id extends Serializable> {

    void persist(T entity);

    void batchProcessing(List<T> entities);

    void update(T entity);

    T findById(Id id);

    List<T> findByProperty(String property, String value);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();

}

