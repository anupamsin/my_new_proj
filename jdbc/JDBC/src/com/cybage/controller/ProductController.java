package com.cybage.controller;

import com.cybage.model.Category;
import com.cybage.model.Product;
import com.cybage.service.ProductService;
import com.cybage.service.ProductServiceImpl;

import java.time.LocalDate;
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
                System.out.println("3. Find Employee By ID");
                System.out.println("4. Delete Employee By Id");
                System.out.println("5. Update Product Details");
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
                            System.out.println("Enter Product ID");
                            Integer id= scanner.nextInt();
                            product.setProductId(id);
                            product.setProductName(productName);
                            System.out.println("Enter product description");
                            product.setProductDescription(scanner.nextLine()+scanner.nextLine());
                            System.out.println("Enter product price");
                            product.setProductPrice(scanner.nextDouble());
                            product.setProductCreatedDate(LocalDate.now());
                            System.out.println(productService.addProduct(product));
                        }else{
                            System.out.println("Product : "+getProductByName.get()+", already exist");
                        }
                        break;

                    case 3:
                        System.out.println("Enter product id to find product details");
                        int id= scanner.nextInt();
                        if(productService.findById(id).get().getProductId()==null){
                            System.out.println("Invalid Id : "+id);
                        }else{
                            System.out.println(productService.findById(id).get());
                        }
                        break;

                    case 4:
                        System.out.println("Enter product id to delete product");
                        int ids= scanner.nextInt();
                        System.out.println(productService.delete(ids));
                        break;

                    case 5:
                        System.out.println("Enter product id to update product");
                        Product product2 = productService.findById(scanner.nextInt()).get();
                        System.out.println(product2);
                        boolean internalFlag = true;
                        while (internalFlag) {
                            System.out.println("Chose Option");
                            System.out.println("1. Update Price");
                            System.out.println("2. Update Product Name");
                            System.out.println("3. Update Product Description");
                            System.out.println("4. Update Product Category");
                            System.out.println("5. ExiT");
                            switch (scanner.nextInt()) {
                                case 1:
                                    System.out.println("Enter updated product price");
                                    product2.setProductPrice(scanner.nextDouble());
                                    System.out.println(productService.updateProduct(product2));
                                    System.out.println(product2);
                                    break;

                                case 2:
                                    System.out.println("Enter updated product name");
                                    scanner.nextLine();
                                    product2.setProductName(scanner.nextLine());
                                    System.out.println(productService.updateProduct(product2));
                                    System.out.println(product2);
                                    break;

                                case 3:
                                    System.out.println("Enter updated product description");
                                    scanner.nextLine();
                                    product2.setProductDescription(scanner.nextLine());
                                    System.out.println(productService.updateProduct(product2));
                                    System.out.println(product2);
                                    break;

                                case 4:
                                    System.out.println("Enter updated product price");
                                    System.out.println("Choose Product Category");
                                    System.out.println("1.GROCERY, 2.ELECTRONICS, 3.BOOKS, 4.MEN_FASHION, 5.WOMEN_FASHION");
                                    String category = getCatMethod(scanner.nextInt());
                                    product2.setProductCategory(Category.valueOf(category));
                                    System.out.println(productService.updateProduct(product2));
                                    System.out.println(product2);
                                    break;

                                case 5:
                                    internalFlag = false;
                                    break;

                                default:
                                    System.out.println("Invalid Option Selected");
                                    break;
                            }
                        }
                        break;

                    case 0:
                        flag = false;
                        break;

                    default:
                        System.out.println("Invalid Option Selected");
                        break;
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