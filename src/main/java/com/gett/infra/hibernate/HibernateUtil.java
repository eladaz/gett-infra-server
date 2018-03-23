package com.gett.infra.hibernate;

import com.gett.infra.app.utils.DBConfig;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import java.io.File;

import static com.gett.infra.app.utils.DBConfig.*;
import static com.gett.infra.app.utils.Paths.*;

@Component
public class HibernateUtil {

    private static Session session;
    private static Configuration configuration;
    private static ServiceRegistry serviceRegistry;
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        DBConfig dbConfig = new DBConfig();
        try {
            configuration = new Configuration();
            configuration.configure(HIBERNATE_CONF_FILE);

            configuration.setProperty(CONNECTION_DRIVER, dbConfig.DB_CONNECTION_DRIVER);
            configuration.setProperty(CONNECTION_URL, dbConfig.JDBC_CONNECTION);
            configuration.setProperty(USER_NAME, dbConfig.DB_USER_NAME);
            configuration.setProperty(PASSWORD, dbConfig.DB_PASSWORD);
            configuration.setProperty(HBM2DDL, dbConfig.HBM2_DDL);

            addMappingFiles(HIBERNATE_MAPPING_DIR);

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
            if(file.toString().endsWith(HBM_EXTENSION))
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
