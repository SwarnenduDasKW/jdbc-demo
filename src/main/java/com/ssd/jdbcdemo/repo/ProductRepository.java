package com.ssd.jdbcdemo.repo;

import com.ssd.jdbcdemo.entity.Product;

import java.util.List;

public interface ProductRepository {

    int save(Product product);

    int update(Product product);

    Product findById(int id);

    int deleteById(int id);

    List<Product> findAll();

    List<Product> findByName(String name);


}
