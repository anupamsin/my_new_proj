package com.cybage.service;

import com.cybage.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProductDetails();

    String addProduct(Product product);

    Optional<Product> findById(int id);

    String delete(int ids);

    String updateProduct(Product product2);
}
