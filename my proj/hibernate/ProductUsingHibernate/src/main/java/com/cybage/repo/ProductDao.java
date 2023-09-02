package com.cybage.repo;

import com.cybage.model.Category;
import com.cybage.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductDao{
	List<Product> getAllEmployee();
	String createProduct(Product product);
	Product getProductById(Integer productId);
	String productDeleteByIds(Product product);
	String updateProductById(Product product);
	List<Product> getFilterProdByDate(LocalDate fromDate, LocalDate toDate);
	List<Product> getProductByCategory(Category category);

	/*Product getProductByProductName(String productName);*/
}
