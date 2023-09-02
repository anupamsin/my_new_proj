package com.cybage.jpql_project.comparators;

import com.cybage.jpql_project.model.Product;

import java.util.Comparator;

public class ProductPriceComparatorInAsc implements Comparator<Product> {
      @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getProductPrice(), o2.getProductPrice());
    }
}
