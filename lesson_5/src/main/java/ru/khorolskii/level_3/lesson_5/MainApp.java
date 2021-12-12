package ru.khorolskii.level_3.lesson_5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {


    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDaoImpl productDao = new ProductDaoImpl(sessionFactoryUtils);
            System.out.println(productDao.allProduct());
            productDao.deleteById(2L);
            System.out.println(productDao.allProduct());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }

    }



}
