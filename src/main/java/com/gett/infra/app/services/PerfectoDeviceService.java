package com.gett.infra.app.services;

import com.gett.infra.hibernate.dao.PerfectoDeviceDao;
import com.gett.infra.hibernate.pojo.datagenerator.PerfectoDevice;
import org.apache.log4j.Logger;

import java.util.List;

public class PerfectoDeviceService {

    private static PerfectoDeviceDao perfectoDeviceDao;
    private final static Logger logger = Logger.getLogger(PerfectoDeviceService.class);

    public PerfectoDeviceService() {
        perfectoDeviceDao = new PerfectoDeviceDao();
    }

    public void persist(PerfectoDevice entity) {
        logger.info("*** Persist PerfectoDevice - start ***");
        perfectoDeviceDao.openCurrentSessionwithTransaction();
        perfectoDeviceDao.persist(entity);
        perfectoDeviceDao.closeCurrentSessionwithTransaction();
        logger.info("*** Persist PerfectoDevice - end ***");
    }

    public void update(PerfectoDevice entity) {
        perfectoDeviceDao.openCurrentSessionwithTransaction();
        perfectoDeviceDao.update(entity);
        perfectoDeviceDao.closeCurrentSessionwithTransaction();
    }

    public PerfectoDevice findById(String id) {
        perfectoDeviceDao.openCurrentSession();
        PerfectoDevice perfectoDevice = perfectoDeviceDao.findById(id);
        perfectoDeviceDao.closeCurrentSession();
        return perfectoDevice;
    }

    public void delete(String id) {
        perfectoDeviceDao.openCurrentSessionwithTransaction();
        PerfectoDevice perfectoDevice = perfectoDeviceDao.findById(id);
        perfectoDeviceDao.delete(perfectoDevice);
        perfectoDeviceDao.closeCurrentSessionwithTransaction();
    }

    public List<PerfectoDevice> findAll() {
        logger.info("*** Find All Persisted PerfectoDevice - start ***");
        perfectoDeviceDao.openCurrentSession();
        List<PerfectoDevice> perfectoDevices = perfectoDeviceDao.findAll();
        perfectoDeviceDao.closeCurrentSession();
        logger.info("Find " + perfectoDevices.size() + " Persisted PerfectoDevice!");
        logger.info("*** Find All Persisted PerfectoDevice - end ***");
        return perfectoDevices;
    }

    public void deleteAll() {
        perfectoDeviceDao.openCurrentSessionwithTransaction();
        perfectoDeviceDao.deleteAll();
        perfectoDeviceDao.closeCurrentSessionwithTransaction();
    }

    public PerfectoDeviceDao creditCardDao() {
        return perfectoDeviceDao;
    }

}
