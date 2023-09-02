package com.cybage.jpql_project.service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import com.cybage.jpql_project.model.Category;
import com.cybage.jpql_project.model.Product;

public interface ProductService {
    String createProd(Product product);

    Map<Integer, Product> getProductDet();

    Map<Integer, Product> getByCategory(Category category);

    Optional<Product> getById(Integer productId);

    String updateProd(Integer productId, Product product);

    Map<Integer, Product> getProdByPriceAndCat(String sortType, Category category);

    String productDelete(Integer productId);

    Map<Integer,Product> getByMultiCategory(String[] category);

	Map<Integer,Product> getDetailsByDateRange(LocalDate fromDate, LocalDate toDate);
	
	Optional<Product> getProductDetailsByName(String productName);

	Map<Integer,Product> getProductByNameFilter(String productName);

	Map<Integer,Product> getProdByPriceDesc();
	
	Map<Integer,Product> getProdByPriceAsc();

	Map<Integer,Product> getProdByDateDesc();

	Map<Integer,Product> getProdByDateAsc();
}
