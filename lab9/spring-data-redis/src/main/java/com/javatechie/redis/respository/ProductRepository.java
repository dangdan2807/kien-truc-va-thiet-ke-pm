package com.javatechie.redis.respository;


import com.google.gson.Gson;
import com.javatechie.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.*;

@Repository
public class ProductRepository {
    private static Logger logger = LogManager.getLogger(ProductRepository.class);

    public static final String HASH_KEY = "Product";
    static Gson gson = new Gson();

    @Autowired
    private RedisTemplate template;

    public Product save(Product product) {
        String data = gson.toJson(product);
        logger.info(data);
        template.opsForValue().set(HASH_KEY + "_" + product.getId(), data);
        return product;
    }

    public List<Product> findAll() {
        Collection<String> collection = new ArrayList<>();
        collection.add("Product_1");
        collection.add("Product_2");
        collection.add("Product_3");
        List<String> result = template.opsForValue().multiGet(collection);
        List<Product> productsList = new ArrayList<>();
        result.forEach(item -> {
            Product product = gson.fromJson(item, Product.class);
            productsList.add(product);
        });
        return productsList;
    }

    public Product findProductById(int id) {
        String data = (String) template.opsForValue().get(HASH_KEY + "_" +  id);
        Product product = gson.fromJson(data, Product.class);
        return product;
    }


    public String deleteProduct(int id) {
        template.delete(HASH_KEY + "_" +  id);
        return "product removed !!";
    }
}
