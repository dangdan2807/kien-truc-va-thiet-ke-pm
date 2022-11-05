package com.javatechie.redis.service;

import com.javatechie.redis.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
    Product findProductById(int id);
    String deleteProduct(int id);
}
