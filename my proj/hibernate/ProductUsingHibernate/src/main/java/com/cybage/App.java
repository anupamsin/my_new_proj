package com.cybage;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.cybage.model.Category;
import com.cybage.model.Product;
import com.cybage.service.ProductService;

public class App {
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		try (Scanner scanner = new Scanner(System.in)) {
			boolean flag = true;
			while (flag) {
				System.out.println("Chose Option");
				System.out.println("1. View All Product");
				System.out.println("2. Add a product");
				System.out.println("3. Find Product By Id");
				System.out.println("4. Delete Product By Id");
				System.out.println("5. Update Product By Id");
				System.out.println("6. ExiT");
				switch (scanner.nextInt()) {
				case 1:
					productService.allProductDetails();
					break;

				case 2:
					Product product = new Product();
					System.out.println("Choose Product Category");
					System.out.println("1.GROCERY, 2.ELECTRONICS, 3.BOOKS, 4.MEN_FASHION, 5.WOMEN_FASHION");
					String cat = getCatMethod(scanner.nextInt());
					product.setProductCategory(Category.valueOf(cat));
					System.out.println("Enter product name");
					scanner.nextLine();
					product.setProductName(scanner.nextLine());
					System.out.println("Enter product description");
					product.setProductDescription(scanner.nextLine());
					System.out.println("Enter product price");
					product.setProductPrice(scanner.nextDouble());
					product.setProductCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
					productService.addProduct(product);
					break;

				case 3:
					System.out.println("Enter product id to find product details");
					System.out.println(productService.productById(scanner.nextInt()));
					break;

				case 4:
					System.out.println("Enter product id to delete product");
					Product product1 = productService.productById(scanner.nextInt());
					System.out.println(productService.deleteProductByIds(product1));
					break;

				case 5:
					System.out.println("Enter product id to update product");
					Product product2 = productService.productById(scanner.nextInt());
					System.out.println(product2.toString());
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
							System.out.println(product2.toString());
							break;

						case 2:
							System.out.println("Enter updated product name");
							scanner.nextLine();
							product2.setProductName(scanner.nextLine());
							System.out.println(productService.updateProduct(product2));
							System.out.println(product2.toString());
							break;

						case 3:
							System.out.println("Enter updated product description");
							scanner.nextLine();
							product2.setProductDescription(scanner.nextLine());
							System.out.println(productService.updateProduct(product2));
							System.out.println(product2.toString());
							break;

						case 4:
							System.out.println("Enter updated product price");
							System.out.println("Choose Product Category");
							System.out.println("1.GROCERY, 2.ELECTRONICS, 3.BOOKS, 4.MEN_FASHION, 5.WOMEN_FASHION");
							String category = getCatMethod(scanner.nextInt());
							product2.setProductCategory(Category.valueOf(category));
							System.out.println(productService.updateProduct(product2));
							System.out.println(product2.toString());
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

				case 6:
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
