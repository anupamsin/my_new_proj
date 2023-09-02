package com.cybage.jpql_project.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.jpql_project.comparators.ProductCreatedDateComparatorAsc;
import com.cybage.jpql_project.comparators.ProductCreatedDateComparatorDesc;
import com.cybage.jpql_project.comparators.ProductPriceComparatorInAsc;
import com.cybage.jpql_project.comparators.ProductPriceComparatorInDsc;
import com.cybage.jpql_project.custom_exception.DataNotFoundException;
import com.cybage.jpql_project.model.Category;
import com.cybage.jpql_project.model.Product;
import com.cybage.jpql_project.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public String createProd(Product product) {
		Product product1 = new Product();
		product1.setProductName(product.getProductName());
		product1.setProductDescription(product.getProductDescription());
		product1.setProductCategory(product.getProductCategory());
		product1.setProductCreatedDate(LocalDate.now());
		product1.setProductPrice(product.getProductPrice());
		productRepo.save(product1);
		return "Product Created";
	}

	@Override
	public Map<Integer, Product> getProductDet() {
		return productRepo.findAll().stream().collect(Collectors.toMap(Product::getProductId, p -> p));
	}

	@Override
	public Map<Integer, Product> getByCategory(Category category) {
		List<Product> prodByCat = productRepo.getByProductCat(category);
		Map<Integer, Product> map = new HashMap<>();
		for (Product p : prodByCat) {
			map.put(p.getProductId(), p);
		}
		return map;
	}

	@Override
	public Optional<Product> getById(Integer productId) {
		Optional<Product> product = productRepo.findById(productId);
		if (product.isPresent())
			return product;
		else
			throw new DataNotFoundException("No Data Found With Product Id : " + productId);
	}

	@Override
	public String updateProd(Integer productId, Product product) {
		Optional<Product> filteredProduct = productRepo.findById(productId);
		if (filteredProduct.isPresent()) {
			Product prod = new Product();
			prod.setProductId(productId);
			prod.setProductName(product.getProductName());
			prod.setProductCategory(product.getProductCategory());
			prod.setProductDescription(product.getProductDescription());
			// DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/MM/dd");
			// LocalDate
			// lDate=LocalDate.parse(product.getProductCreatedDate().toString(),formatter);
			// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			// String dates=sdf.format(product.getProductCreatedDate());
			// System.out.println(product.getProductCreatedDate());
			prod.setProductCreatedDate(filteredProduct.get().getProductCreatedDate());
			prod.setProductPrice(product.getProductPrice());
			productRepo.save(prod);
			return "Updated Successfully : " + prod.getProductId() + ", " + prod.getProductName() + ", "
					+ prod.getProductDescription() + ", " + prod.getProductCategory() + ", "
					+ prod.getProductCreatedDate() + ", " + prod.getProductPrice();
		} else {
			return "Update Failed";
		}
	}

	@Override
	public Map<Integer, Product> getProdByPriceAndCat(String sortType, Category category) {
		Map<Integer, Product> map = getByCategory(category);
		if (sortType.equalsIgnoreCase("asc")) {
			return map.values().stream().sorted(new ProductPriceComparatorInAsc())
					.collect(Collectors.toMap(Product::getProductId, v -> v, (e1, e2) -> e1, LinkedHashMap::new));
		} else if (sortType.equalsIgnoreCase("dsc")) {
			return map.values().stream().sorted(new ProductPriceComparatorInDsc())
					.collect(Collectors.toMap(Product::getProductId, v -> v, (e1, e2) -> e1, LinkedHashMap::new));
		} else {
			throw new DataNotFoundException("No Data Found");
		}
	}

	@Override
	public String productDelete(Integer productId) {
		Optional<Product> product = productRepo.findById(productId);
		if (product.isPresent()) {
			productRepo.delete(product.get());
			return "Product deleted successfully";
		} else
			return "Product deletion failed";
	}

	@Override
	public Map<Integer, Product> getByMultiCategory(String[] category) {
		List<Product> prodList = new ArrayList<>();
		for (String str : category) {
			prodList.addAll(productRepo.findAll().stream()
					.filter(product -> product.getProductCategory().equals(Category.valueOf(str.toUpperCase())))
					.collect(Collectors.toList()));
		}
		return prodList.stream().collect(Collectors.toMap(Product::getProductId, prod -> prod));
	}

	@Override
	public Map<Integer, Product> getDetailsByDateRange(LocalDate fromDate, LocalDate toDate) {
		return productRepo.getProdByDateRange(fromDate, toDate).stream()
				.collect(Collectors.toMap(Product::getProductId, p -> p));
	}

	@Override
	public Optional<Product> getProductDetailsByName(String productName) {
		Optional<Product> getProductByName = productRepo.getByProductName(productName);
		return getProductByName;
	}

	@Override
	public Map<Integer, Product> getProductByNameFilter(String productName) {
		if (productName.length() <= 2) {
			throw new DataNotFoundException("Length of product name must be greater than 2");
		}
		return productRepo.findAll().stream()
				.filter(p -> p.getProductName().toLowerCase().contains(productName.toLowerCase()))
				.collect(Collectors.toMap(Product::getProductId, p -> p));
	}

	@Override
	public Map<Integer, Product> getProdByPriceDesc() {
		return productRepo.findAll().stream().sorted(new ProductPriceComparatorInDsc())
				.collect(Collectors.toMap(Product::getProductId, p -> p, (a, b) -> a, LinkedHashMap::new));
	}

	@Override
	public Map<Integer, Product> getProdByPriceAsc() {
		return productRepo.findAll().stream().sorted(new ProductPriceComparatorInAsc())
				.collect(Collectors.toMap(Product::getProductId, p -> p, (a, b) -> a, LinkedHashMap::new));
	}

	@Override
	public Map<Integer, Product> getProdByDateDesc() {
		return productRepo.findAll().stream().sorted(new ProductCreatedDateComparatorDesc())
				.collect(Collectors.toMap(Product::getProductId, p -> p, (a, b) -> a, LinkedHashMap::new));
	}

	@Override
	public Map<Integer, Product> getProdByDateAsc() {
		return productRepo.findAll().stream().sorted(new ProductCreatedDateComparatorAsc())
				.collect(Collectors.toMap(Product::getProductId, p -> p, (a, b) -> a, LinkedHashMap::new));
	}

}
