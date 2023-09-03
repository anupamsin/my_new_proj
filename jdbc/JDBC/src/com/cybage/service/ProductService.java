package com.cybage.service;

import com.cybage.dao.ProductDao;
import com.cybage.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProductDetails();

    String addProduct(Product product);
}
