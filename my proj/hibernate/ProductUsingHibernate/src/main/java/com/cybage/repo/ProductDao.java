package com.cybage.repo;

import java.util.List;

import com.cybage.model.Product;

public interface ProductDao{
	List<Product> getAllEmployee();
	String createProduct(Product product);
	Product getProductById(Integer productId);
	String productDeleteByIds(Product product);
	String updateProductById(Product product);
}
