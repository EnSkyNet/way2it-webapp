package com.way2it.yk.web.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionConfiguration {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();

            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
            sessionFactory = meta.buildSessionFactory();
        }

        return sessionFactory;
    }
}
