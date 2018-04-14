package com.gett.infra.hibernate.dao;

import com.gett.infra.hibernate.pojo.datagenerator.PerfectoDevice;

import java.util.List;

public class PerfectoDeviceDao extends BaseDao implements EntityDaoInterface<PerfectoDevice, String> {

    private static final String entityName = "PerfectoDevice";

    @Override
    public void persist(PerfectoDevice entity) {
        getCurrentSession().save(entity);

    }

    @Override
    public void batchProcessing(List<PerfectoDevice> entities) {

    }

    @Override
    public void update(PerfectoDevice entity) {
        getCurrentSession().update(entity);

    }

    @Override
    public PerfectoDevice findById(String id) {
        PerfectoDevice perfectoDevice = (PerfectoDevice) getCurrentSession().get(PerfectoDevice.class, id);
        return perfectoDevice;
    }

    @Override
    public List<PerfectoDevice> findByProperty(String property, String value) {
        return null;
    }

    @Override
    public void delete(PerfectoDevice entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<PerfectoDevice> findAll() {
        List<PerfectoDevice> perfectoDevices = (List<PerfectoDevice>) getCurrentSession().createQuery(String.format("From %s", entityName)).list();
        return perfectoDevices;

    }

    @Override
    public void deleteAll() {
        List<PerfectoDevice> entityList = findAll();
        for (PerfectoDevice entity : entityList) {
            delete(entity);
        }

    }
}
