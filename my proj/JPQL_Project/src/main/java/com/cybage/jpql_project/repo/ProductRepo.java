package com.cybage.jpql_project.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.jpql_project.model.Category;
import com.cybage.jpql_project.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query(value = "select p from Product p where p.productCategory=:category")
    List<Product> getByProductCat(Category category);

	@Query(value = "select p from Product p where p.productCreatedDate>=:fromDate and p.productCreatedDate<=:toDate")
    List<Product> getProdByDateRange(LocalDate fromDate, LocalDate toDate);

	Optional<Product> getByProductName(String productName);

	/*
	 * @Query(value =
	 * "select p from Product p where p.productName like '%:productName%'")
	 * List<Product> getByProductNameFilter(String productName);
	 */
}
