package com.cybage.service;

import com.cybage.model.Product;
import com.cybage.repo.ProductDao;
import com.cybage.repo.ProductDaoImpl;

public class ProductService {
	 ProductDao dao = new ProductDaoImpl();
	 
	 public void allProductDetails(){
		 dao.getAllEmployee().forEach(System.out::println); 
	 }
	 
	 public void addProduct(Product product) {
		 Product product1=new Product();
		 product1.setProductName(product.getProductName());
		 product1.setProductDescription(product.getProductDescription());
		 product1.setProductPrice(product.getProductPrice());
		 product1.setProductCreatedDate(product.getProductCreatedDate());
		 dao.createProduct(product);
	 }
	 
	 public Product productById(Integer productId) {
		 return dao.getProductById(productId);
	 }

	public String deleteProductByIds(Product product) {
		return dao.productDeleteByIds(product);
	}

	public String updateProduct(Product product) {
		Product product2=new Product();
		product2.setProductId(product.getProductId());
		product2.setProductName(product.getProductName());
		product2.setProductDescription(product.getProductDescription());
		product2.setProductPrice(product.getProductPrice());
		product2.setProductCategory(product.getProductCategory());
		product2.setProductCreatedDate(product.getProductCreatedDate());
		return dao.updateProductById(product2);
	}
}
