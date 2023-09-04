package com.cybage.service;

import com.cybage.dao.ProductDao;
import com.cybage.dao.ProductDaoImpl;
import com.cybage.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements  ProductService{
    ProductDao productDao=new ProductDaoImpl();
    @Override
    public List<Product> getAllProductDetails() {
        return productDao.findAll();
    }

    @Override
    public String addProduct(Product product) {
        if(productDao.save(product))
            return "Product Created";
        else
            return "Product Creation Failed";
    }

    @Override
    public Optional<Product> findById(int id) {
        return productDao.findByProductId(id);
    }

    @Override
    public String delete(int ids) {
        return productDao.deleteById(ids);
    }

    @Override
    public String updateProduct(Product product) {
        Product product2=new Product();
        product2.setProductId(product.getProductId());
        product2.setProductName(product.getProductName());
        product2.setProductDescription(product.getProductDescription());
        product2.setProductPrice(product.getProductPrice());
        product2.setProductCategory(product.getProductCategory());
        product2.setProductCreatedDate(product.getProductCreatedDate());
        return productDao.update(product);
    }
}
