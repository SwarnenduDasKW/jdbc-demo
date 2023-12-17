package com.ssd.jdbcdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products = productRepository.findAll();

        if(products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        Product product = productRepository.findById(id);
        if(null == product) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productRepository.save(new Product(product.getId(),product.getName(),product.getPrice(),product.getQuantity()));
        return new ResponseEntity<>("Product saved successfully!",HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        Product updatedProduct = productRepository.findById(id);
        if (null != updatedProduct) {
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setQuantity(product.getQuantity());

            productRepository.update(product);
            return new ResponseEntity<>("Product updated successfully!",HttpStatus.OK);
        }
        return new ResponseEntity<>("Cannot find product with id " + id, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
        int status = productRepository.deleteById(id);
        if (status == 0) {
            return new ResponseEntity<>("Cannot find product",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Product updated successfully!",HttpStatus.OK);
    }

    @GetMapping("/product/{name}")
    public ResponseEntity<List<Product>> findProductByName(@PathVariable("name") String name) {
        List<Product> products = new ArrayList<>();
        products = productRepository.findByName(name);
        if(products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

}
