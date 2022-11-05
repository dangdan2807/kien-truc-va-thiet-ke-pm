package com.javatechie.redis.controller;

import com.javatechie.redis.entity.Product;
import com.javatechie.redis.respository.ProductRepository;
import com.javatechie.redis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id) {
        return productService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id)   {
        return productService.deleteProduct(id);
    }
}
