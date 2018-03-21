package com.gett.infra.app.controllers;

import com.gett.infra.hibernate.HibernateUtil;
import com.gett.infra.hibernate.dao.BaseDao;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.stereotype.Component;

import javax.persistence.metamodel.EntityType;
import java.util.*;

@Component
public class DatabaseController extends BaseDao {

    private static final SessionFactory sessionFactory = getSessionFactory();
    private final static Logger logger = Logger.getLogger(DatabaseController.class);


    public static Set<String> getAllMappedEntities() {
        logger.info("*** Get All Mapped Entities - start ***");
        Set<String> entityList = new HashSet<>();

        Set<EntityType<?>> entities = sessionFactory.getMetamodel().getEntities();

        entities.forEach((entity) -> {
            entityList.add(entity.getName());
        });


//        Map<String, ClassMetadata>  map = (Map<String, ClassMetadata>) sessionFactory.getAllClassMetadata();
//        for(String entityName : map.keySet()){
//            SessionFactoryImpl sfImpl = (SessionFactoryImpl) sessionFactory;
//            String tableName = ((AbstractEntityPersister)sfImpl.getEntityPersister(entityName)).getTableName();
//            entities.put(entityName, tableName);
//        }
        logger.info("*** Get All Mapped Entities - end ***");
        return entityList;
    }



//            logger.info("*** Persist CreditCard - start ***");
//        creditCardDao.openCurrentSessionwithTransaction();
//        creditCardDao.persist(entity);
//        creditCardDao.closeCurrentSessionwithTransaction();
//        logger.info("*** Persist CreditCard - end ***");

//    private static CreditCardDao creditCardDao;
//
//    public DatabaseService() {
//        creditCardDao = new CreditCardDao();
//    }

//    public void persist(Class<T> typeParameterClass) {
//        creditCardDao.openCurrentSessionwithTransaction();
//        creditCardDao.persist(typeParameterClass);
//        creditCardDao.closeCurrentSessionwithTransaction();
//    }


//    public <T>List getEntityList(T typeParameterClass) {
//        Transaction tx;
//        String entityName = null;
//        Session session = null;
//        List<T> entityList = new ArrayList();
//
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            tx = session.beginTransaction();
//            entityName = ((Class) typeParameterClass).getSimpleName();
//            entityList = (List) session.createQuery("From " + entityName).list();
//            tx.commit();
//        } catch (HibernateException e) {
//            logger.error("Failed to fetch List of entity " + entityName);
//            e.printStackTrace();
//        } finally {
//            logger.info("Fetching " + entityList.size() + " items of entity " + entityName);
//            session.close();
//        }
//
//        return entityList;
//    }

//    private String getTableName(String name) {
//        SessionImpl sessionImpl = (SessionImpl) HibernateUtil.getSessionFactory().openSession();
//        try {
//            Connection connection = sessionImpl.connection();
//            DatabaseMetaData databaseMetaData = connection.getMetaData();
//            ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[] {"TABLE"});
//            while(resultSet.next()) {
//                if (resultSet.getString(3).replace("_", "").equalsIgnoreCase(name)) {
//                    return resultSet.getString(3);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }



//    private static void beginTransaction() {
//        session = HibernateUtil.getSession();
//        session.beginTransaction();
//    }
//
//    public <T> T featchData(T typeParameterClass, String key) {
//        return session.get((Class<T>) typeParameterClass, key);
//    }
//
//    public static void a() {
//        beginTransaction();
////
////
//// User user = new User();
////
////        user.setUserId(1);
////        user.setUsername("root");
////        user.setCreatedBy("A361561y");
////        user.setCreatedDate(new Date());
////
////        session.save(user);
////        session.getTransaction().commit();
//
//    }






}
