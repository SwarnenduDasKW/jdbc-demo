package com.ssd.jdbcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcProductRepository implements ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Product product) {
        return jdbcTemplate.update("INSERT INTO product (id,name,price,quantity) values(?,?,?,?)",
                new Object[] {product.getId(),product.getName(),product.getPrice(),product.getQuantity()});
    }

    @Override
    public int update(Product product) {
        return jdbcTemplate.update("UPDATE product SET price = ?, quantity = ? WHERE id = ?",
                new Object[] {product.getPrice(),product.getQuantity(),product.getId()});
    }

    @Override
    public Product findById(int id) {
        Product product = jdbcTemplate.queryForObject("SELECT * FROM product where id=?",
                BeanPropertyRowMapper.newInstance(Product.class),id);
        return product;
    }

    @Override
    public int deleteById(int id) {
        int status = jdbcTemplate.update("DELETE FROM product where id=?",id);
        return status;
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT * FROM product",
                BeanPropertyRowMapper.newInstance(Product.class));
    }

    @Override
    public List<Product> findByName(String name) {
        String query = "SELECT * FROM product WHERE LOWER(name) LIKE '%" + name.toLowerCase() + "%'";
        return jdbcTemplate.query(query,BeanPropertyRowMapper.newInstance(Product.class));
    }
}
