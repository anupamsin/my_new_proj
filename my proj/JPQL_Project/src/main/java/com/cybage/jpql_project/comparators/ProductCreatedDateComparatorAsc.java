package com.cybage.jpql_project.comparators;

import java.util.Comparator;

import com.cybage.jpql_project.model.Product;

public class ProductCreatedDateComparatorAsc implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getProductCreatedDate().compareTo(o2.getProductCreatedDate());
	}

}
