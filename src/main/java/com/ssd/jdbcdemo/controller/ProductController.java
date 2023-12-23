package com.ssd.jdbcdemo.controller;

import com.ssd.jdbcdemo.entity.Product;
import com.ssd.jdbcdemo.repo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        logger.info("=====>>>>> Executing getAllProducts.");
        List<Product> products = new ArrayList<>();
        products = productRepository.findAll();

        if(products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        logger.info("=====>>>>> Executing getProductById.");
        try {
            Product product = productRepository.findById(id);
            if (null == product) {
                logger.error("=====>>>>> No products found for id " + id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch(Exception e) {
            logger.error("=====>>>>> Exception caught in getProductById. " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        logger.info("=====>>>>> Executing createProduct.");
        try {
            productRepository.save(new Product(product.getId(), product.getName(), product.getPrice(), product.getQuantity()));
        }
        catch(Exception e) {
            logger.error("=====>>>>> Exception caught in createProduct. " + e.getMessage());
            return new ResponseEntity<>("Product saved successfully!",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Product saved successfully!",HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        logger.info("=====>>>>> Executing updateProduct.");
        try {
            Product updatedProduct = productRepository.findById(id);
            if (null != updatedProduct) {
                updatedProduct.setPrice(product.getPrice());
                updatedProduct.setQuantity(product.getQuantity());

                productRepository.update(product);
                return new ResponseEntity<>("Product updated successfully!", HttpStatus.OK);
            }
        } catch(Exception e) {
            return new ResponseEntity<>("Exception caught in updateProduct. " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Cannot find product with id " + id, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
        logger.info("=====>>>>> Executing deleteProduct.");
        int status = productRepository.deleteById(id);
        if (status == 0) {
            return new ResponseEntity<>("Cannot find product",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Product updated successfully!",HttpStatus.OK);
    }

    @GetMapping("/product/{name}")
    public ResponseEntity<List<Product>> findProductByName(@PathVariable("name") String name) {
        logger.info("=====>>>>> Executing findProductByName.");
        List<Product> products = new ArrayList<>();
        products = productRepository.findByName(name);
        if(products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

}
