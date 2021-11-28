package ru.khorolskii.level_3.lesson_5;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    Optional <Product> findById(Long id);
    Product findByName(String name);
    List <Product> allProduct();
    void saveOrUpdate(Product product);
    void deleteById(Long id);
}
