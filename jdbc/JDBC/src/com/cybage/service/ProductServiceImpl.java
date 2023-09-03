package com.cybage.service;

import com.cybage.dao.ProductDao;
import com.cybage.dao.ProductDaoImpl;
import com.cybage.model.Product;

import java.util.List;

public class ProductServiceImpl implements  ProductService{
    ProductDao productDao=new ProductDaoImpl();
    @Override
    public List<Product> getAllProductDetails() {
        return productDao.findAll();
    }

    @Override
    public String addProduct(Product product) {
        productDao.save(product);
        return "Product Created";
    }
}
