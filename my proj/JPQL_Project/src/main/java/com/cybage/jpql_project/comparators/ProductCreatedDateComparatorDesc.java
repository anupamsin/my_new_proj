package com.cybage.jpql_project.comparators;

import java.util.Comparator;

import com.cybage.jpql_project.model.Product;

public class ProductCreatedDateComparatorDesc implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o2.getProductCreatedDate().compareTo(o1.getProductCreatedDate());
	}

}
