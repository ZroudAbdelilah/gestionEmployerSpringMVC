package com.exemple.gestion_employer1.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HSessionFactory {
    // modification session factory
    public SessionFactory getSession(){
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public static HSessionFactory getInstance(){
        return new HSessionFactory();
    }
}
