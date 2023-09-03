package com.cybage.controller;

import com.cybage.model.Category;
import com.cybage.model.Product;
import com.cybage.service.ProductService;
import com.cybage.service.ProductServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductController {
    public static void main(String[] args) {
        ProductService productService=new ProductServiceImpl();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean flag = true;
            while (flag) {
                System.out.println("Chose Option");
                System.out.println("1. Display All Product Details");
                System.out.println("2. Create a Product");
                System.out.println("0. ExiT");
                switch (scanner.nextInt()) {
                    case 1:
                        productService.getAllProductDetails().forEach(System.out::println);
                        break;

                    case 2:
                        Product product = new Product();
                        System.out.println("Choose Product Category");
                        System.out.println("1.GROCERY, 2.ELECTRONICS, 3.BOOKS, 4.MEN_FASHION, 5.WOMEN_FASHION");
                        String cat = getCatMethod(scanner.nextInt());
                        product.setProductCategory(Category.valueOf(cat));
                        System.out.println("Enter product name");
                        String productName=scanner.nextLine()+scanner.nextLine();
                        Optional<Product> getProductByName=productService.getAllProductDetails().stream().filter(p->p.getProductName().equalsIgnoreCase(productName)).findAny();
                        if( getProductByName.isEmpty()){
                            product.setProductName(productName);
                            System.out.println("Enter product description");
                            product.setProductDescription(scanner.nextLine());
                            System.out.println("Enter product price");
                            product.setProductPrice(scanner.nextDouble());
                            product.setProductCreatedDate(LocalDate.now());
                            System.out.println(productService.addProduct(product));
                        }else{
                            System.out.println("Product : "+getProductByName.get()+", already exist");
                        }
                        break;

                    case 0:
                        flag = false;
                        break;

                    default:
                        System.out.println("Invalid Option Selected");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getCatMethod(int counter) {
        String cat = "";
        String[] categories = { "GROCERY", "ELECTRONICS", "BOOKS", "MEN_FASHION", "WOMEN_FASHION" };
        for (int i = 0; i <= categories.length - 1; i++) {
            cat = categories[counter - 1];
        }
        return cat;
    }
}