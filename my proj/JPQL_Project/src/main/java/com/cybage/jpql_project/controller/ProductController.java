package com.cybage.jpql_project.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.jpql_project.MessageResponse.CentralizedCustomResponse;
import com.cybage.jpql_project.model.Category;
import com.cybage.jpql_project.model.Product;
import com.cybage.jpql_project.service.ProductService;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin(origins = "http://localhost:8080/")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/home")
	public String getHomePage() {
		return "Welcome To Home Page";
	}

	@PostMapping(value = "/createProduct")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		Optional<Product> getProductByName = productService.getProductDetailsByName(product.getProductName());
		if (getProductByName.isEmpty()) {
			return CentralizedCustomResponse.generateResponse("Product Created", HttpStatus.CREATED,
					productService.createProd(product));
		}
		return CentralizedCustomResponse.generateResponse("Product Not Created", HttpStatus.valueOf(303),
				"Product Already Exist, Product Details : " + getProductByName.get());
	}

	@GetMapping(value = "/getProducts")
	public ResponseEntity<Object> getProductDetails() {
		return CentralizedCustomResponse.generateResponse("Product Details", HttpStatus.OK,
				productService.getProductDet());
	}

	/*
	 * @GetMapping(value = "/getProductByCategory/{category}") public Map<Integer,
	 * Product> getProductByCategory(@PathVariable Category category){ return
	 * productService.getByCategory(category); }
	 */

	@GetMapping(value = "/getProductByCategory")
	public ResponseEntity<Object> getProductByCategory(@PathParam("category") Category category) {
		return CentralizedCustomResponse.generateResponse("Product By Category : " + category, HttpStatus.OK,
				productService.getByCategory(category));
	}

	@GetMapping(value = "/getProductById/{productId}")
	public ResponseEntity<Object> getProductById(@PathVariable Integer productId) {
		return CentralizedCustomResponse.generateResponse("Product By Product Id : " + productId, HttpStatus.OK,
				productService.getById(productId));
	}

	@PutMapping(value = "/updateProduct")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product,
			@PathParam("productId") Integer productId) {
		return CentralizedCustomResponse.generateResponse("Product Updated With Product Id : " + productId,
				HttpStatus.OK, productService.updateProd(productId, product));
	}

	// sort data by category and price
	@GetMapping(value = "/sortBy/{sortType}")
	public ResponseEntity<Object> sortByPriceAndCat(@PathVariable String sortType,
			@PathParam("category") Category category) {
		if (sortType.equalsIgnoreCase("dsc")) {
			return CentralizedCustomResponse.generateResponse(
					"Product Details in Descending order and with category of " + category, HttpStatus.OK,
					productService.getProdByPriceAndCat(sortType, category));
		} else if (sortType.equalsIgnoreCase("asc")) {
			return CentralizedCustomResponse.generateResponse(
					"Product Details in Ascending order and with category of " + category, HttpStatus.OK,
					productService.getProdByPriceAndCat(sortType, category));
		} else {
			return CentralizedCustomResponse.generateResponse("No Such Order Exist : " + sortType + " order",
					HttpStatus.NOT_FOUND, null);
		}
	}

	@GetMapping(value = "/sortBy/{sortType}/{filterObject}")
	public ResponseEntity<Object> sortByPriceAndCat(@PathVariable String sortType, @PathVariable String filterObject) {
		if (sortType.equalsIgnoreCase("dsc")) {
			if (filterObject.equalsIgnoreCase("price")) {
				return CentralizedCustomResponse.generateResponse("Product Details in Descending order of price",
						HttpStatus.OK, productService.getProdByPriceDesc());
			} else if (filterObject.equalsIgnoreCase("date")) {
				return CentralizedCustomResponse.generateResponse("Product Details in Descending order of date",
						HttpStatus.OK, productService.getProdByDateDesc());
			}
			return CentralizedCustomResponse.generateResponse("No Such Order Exist : " + sortType + " order",
					HttpStatus.NOT_FOUND, null);
		} else if (sortType.equalsIgnoreCase("asc")) {
			if (filterObject.equalsIgnoreCase("price")) {
				return CentralizedCustomResponse.generateResponse("Product Details in Ascending order of price",
						HttpStatus.OK, productService.getProdByPriceAsc());
			} else if (filterObject.equalsIgnoreCase("date")) {
				return CentralizedCustomResponse.generateResponse("Product Details in Ascending order of price",
						HttpStatus.OK, productService.getProdByDateAsc());
			}
			return CentralizedCustomResponse.generateResponse("No Such Order Exist : " + sortType + " order",
					HttpStatus.NOT_FOUND, null);
		} else {
			return CentralizedCustomResponse.generateResponse("No Such Order Exist : " + sortType + " order",
					HttpStatus.NOT_FOUND, null);
		}
	}

	/*
	 * @GetMapping(value = "/sortByDate/{sortType}") public ResponseEntity<Object>
	 * sortByDate(@PathVariable String sortType) { if
	 * (sortType.equalsIgnoreCase("dsc")) { return CentralizedCustomResponse.
	 * generateResponse("Product Details in Descending order of date",
	 * HttpStatus.OK, productService.getProdByDateDesc()); } else if
	 * (sortType.equalsIgnoreCase("asc")) { return CentralizedCustomResponse.
	 * generateResponse("Product Details in Ascending order of price",
	 * HttpStatus.OK, productService.getProdByDateAsc()); } return
	 * CentralizedCustomResponse.generateResponse("No Such Order Exist : " +
	 * sortType + " order", HttpStatus.NOT_FOUND, null); }
	 */

	@DeleteMapping(value = "/deleteProduct/{productId}")
	public ResponseEntity<Object> deleteProduct(@PathVariable Integer productId) {
		return CentralizedCustomResponse.generateResponse("Product Deletion", HttpStatus.OK,
				productService.productDelete(productId));
	}

	@GetMapping(value = "/multiCategory")
	public ResponseEntity<Object> getProductByMultiCategory(@PathParam("category") String[] category) {
		return CentralizedCustomResponse.generateResponse("Product By Category : " + Arrays.toString(category),
				HttpStatus.OK, productService.getByMultiCategory(category));
	}

	@GetMapping(value = "/productsByDateRange")
	public ResponseEntity<Object> getpProductsDetailByDateRange(@PathParam("fromDate") String fromDate,
			@PathParam("toDate") String toDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return CentralizedCustomResponse.generateResponse("Product Details By Date Range", HttpStatus.OK, productService
				.getDetailsByDateRange(LocalDate.parse(fromDate, formatter), LocalDate.parse(toDate, formatter)));
	}

	@GetMapping(value = "/filterByName")
	public ResponseEntity<Object> getProdDetByFilterName(@PathParam("productName") String productName) {
		return CentralizedCustomResponse.generateResponse(
				"Product Details With Product Name Consist of : " + productName, HttpStatus.OK,
				productService.getProductByNameFilter(productName));
	}

}
