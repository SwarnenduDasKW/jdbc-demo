package com.ssd.jdbcdemo;

import java.util.List;

public interface ProductRepository {

    int save(Product product);

    int update(Product product);

    Product findById(int id);

    int deleteById(int id);

    List<Product> findAll();

    List<Product> findByName(String name);


}
