package com.laptopstore.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class LaptopDTO {
    private Long id;
    @NotNull
    @Length(min = 3,max = 20)
    private String name;

    @NotNull
    @Positive(message = "Negative Price Not Allowed")
    @Range(max = 99999, message = "Price Should be lower than 99999")
    private double price;
    @NotNull
    private String brand;
    @NotNull
    private String storage;
    @NotNull
    private String ram;
    @NotNull
    private String processor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }
}
