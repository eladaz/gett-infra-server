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
        perfectoDeviceDao.openCurrentSessionWithTransaction();
        perfectoDeviceDao.persist(entity);
        perfectoDeviceDao.closeCurrentSessionWithTransaction();
        logger.info("*** Persist PerfectoDevice - end ***");
    }

    public void update(PerfectoDevice entity) {
        perfectoDeviceDao.openCurrentSessionWithTransaction();
        perfectoDeviceDao.update(entity);
        perfectoDeviceDao.closeCurrentSessionWithTransaction();
    }

    public PerfectoDevice findById(String id) {
        perfectoDeviceDao.openCurrentSession();
        PerfectoDevice perfectoDevice = perfectoDeviceDao.findById(id);
        perfectoDeviceDao.closeCurrentSession();
        return perfectoDevice;
    }

    public void delete(String id) {
        perfectoDeviceDao.openCurrentSessionWithTransaction();
        PerfectoDevice perfectoDevice = perfectoDeviceDao.findById(id);
        perfectoDeviceDao.delete(perfectoDevice);
        perfectoDeviceDao.closeCurrentSessionWithTransaction();
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
        perfectoDeviceDao.openCurrentSessionWithTransaction();
        perfectoDeviceDao.deleteAll();
        perfectoDeviceDao.closeCurrentSessionWithTransaction();
    }

    public PerfectoDeviceDao creditCardDao() {
        return perfectoDeviceDao;
    }

}
