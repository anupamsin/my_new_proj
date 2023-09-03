package com.cybage.model;

import java.time.LocalDate;

public class Product {
    private Integer productId;
    private String productName;

    private String productDescription;
    private Category productCategory;

    //@Temporal(TemporalType.TIMESTAMP) its for java.util.Time
    private LocalDate productCreatedDate;

    private double productPrice;

    public Product() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public LocalDate getProductCreatedDate() {
        return productCreatedDate;
    }

    public void setProductCreatedDate(LocalDate productCreatedDate) {
        this.productCreatedDate = productCreatedDate;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Details : {" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productCategory=" + productCategory +
                ", productCreatedDate=" + productCreatedDate +
                ", productPrice=" + productPrice +
                '}';
    }
}
