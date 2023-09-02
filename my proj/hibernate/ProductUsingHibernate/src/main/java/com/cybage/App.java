package com.cybage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
				System.out.println("6. Find Product By Category");
				System.out.println("7. Find Product Details by Date Range");
				System.out.println("8. Find product by Category");
				System.out.println("9. ExiT");
				switch (scanner.nextInt()) {
				case 1:
					productService.allProductDetails().forEach(System.out::println);
					break;

				case 2:
					Product product = new Product();
					System.out.println("Choose Product Category");
					System.out.println("1.GROCERY, 2.ELECTRONICS, 3.BOOKS, 4.MEN_FASHION, 5.WOMEN_FASHION");
					String cat = getCatMethod(scanner.nextInt());
					product.setProductCategory(Category.valueOf(cat));
					System.out.println("Enter product name");
					String productName=scanner.nextLine()+scanner.nextLine();
					Optional<Product> getProductByName=productService.allProductDetails().stream().filter(p->p.getProductName().equalsIgnoreCase(productName)).findAny();
					if( getProductByName.isEmpty()){
						product.setProductName(productName);
						System.out.println("Enter product description");
						product.setProductDescription(scanner.nextLine());
						System.out.println("Enter product price");
						product.setProductPrice(scanner.nextDouble());
						product.setProductCreatedDate(LocalDate.now());
						productService.addProduct(product);
					}else{
						System.out.println("Product : "+getProductByName.get()+", already exist");
					}
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

				case 6:
					System.out.println("Enter categories to find Product");
					List<String> list = new ArrayList<>();
					String str = scanner.nextLine() + scanner.nextLine();
					String[] multiCat = str.replaceAll(",", "").strip().split("\\s+");
					for (String st : multiCat) {
						list.add(st);
					}
					productService.findProdByCategory(list).forEach(System.out::println);
					break;

				case 7:
					System.out.println("Enter From date");
					String fromDate = scanner.next();
					System.out.println("Enter To date");
					String toDate = scanner.next();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					productService.filterProductByDate(LocalDate.parse(fromDate, formatter),
							LocalDate.parse(toDate, formatter)).forEach(System.out::println);
					break;

				case 8 :
					System.out.println("Choose Category");
					System.out.println("1.GROCERY, 2.ELECTRONICS, 3.BOOKS, 4.MEN_FASHION, 5.WOMEN_FASHION");
					String category = getCatMethod(scanner.nextInt());
					productService.productsByCategory(Category.valueOf(category)).forEach(System.out::println);
					break;

				case 9:
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
