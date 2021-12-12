package ru.khorolskii.level_3.lesson_5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtils {

    public SessionFactory factory;
    public void init(){
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public void shutdown(){
        if(factory != null){
            factory.close();
        }
    }

    public Session getSession(){
        return factory.getCurrentSession();
    }
}
