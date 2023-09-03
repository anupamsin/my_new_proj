package com.cybage.dao;

import com.cybage.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();

    void save(Product product);
}
