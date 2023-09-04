package com.cybage.dao;

import com.cybage.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    List<Product> findAll();

    boolean save(Product product);

    Optional<Product> findByProductId(int id);

    String deleteById(int ids);

    String update(Product product);
}
