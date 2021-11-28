package ru.khorolskii.level_3.lesson_5;

import org.hibernate.Session;

import java.util.List;
import java.util.Optional;


public class ProductDaoImpl implements ProductDao {
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Optional <Product> findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
           Optional <Product> p =Optional.ofNullable(session.get(Product.class, id));
            session.getTransaction().commit();
            return p;
        }
    }

    @Override
    public Product findByName(String title) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product p = session.createQuery("select product from Product product where product.title = :title", Product.class)
                    .setParameter("title", title)
                    .getSingleResult();
            session.getTransaction().commit();
            return p;
        }
    }


    @Override
    public List<Product> allProduct() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> listProduct = session.createQuery("select product from Product product").getResultList();
            session.getTransaction().commit();
            return listProduct;
        }
    }

    @Override
    public void saveOrUpdate(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createQuery("delete from Product p where p.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }
}

