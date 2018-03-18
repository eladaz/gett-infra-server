package com.gett.infra.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;

public class HibernateUtil {

    private static Session session;
    private static Configuration configuration;
    private static ServiceRegistry serviceRegistry;
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            configuration = new Configuration();
            configuration.configure("hibernate/hibernate.cfg.xml");
            addMappingFiles("hibernate/datagenerator");

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            // Create the SessionFactory from hibernate.cfg.xml
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new HibernateException(ex);
        }
    }

    private static void addMappingFiles(String dir) {
        File[] files = new File(HibernateUtil.class.getClassLoader().getResource(dir).getPath()).listFiles();

        for(File file : files) {
            if(file.toString().endsWith("hbm.xml"))
                configuration.addResource(dir + String.valueOf(file).split(dir)[1]);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

    public static Session getSession() {
        if (session == null) {
            session =  getSessionFactory().openSession();
        }
        return session;
    }

}
