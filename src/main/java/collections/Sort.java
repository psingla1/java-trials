package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(ProductFixtures.door);
		products.add(ProductFixtures.floorPanel);
		products.add(ProductFixtures.window);
		
		System.out.println(products);
		
		Collections.sort(products, Product.BY_NAME);
		System.out.println(products);
		
		Collections.sort(products, Product.BY_WEIGHT);
		System.out.println(products);

		
		//Better one in Java 8
		
		products.sort(Product.BY_NAME);
		System.out.println(products);
		
		products.sort(Product.BY_WEIGHT);
		System.out.println(products);
	}
}
