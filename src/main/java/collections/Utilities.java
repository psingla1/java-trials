package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utilities {
	public static void main(String[] args) {
		
		Product door = ProductFixtures.door;
		Product floorPanel = ProductFixtures.floorPanel;
		Product window = ProductFixtures.window;
		
		List<Product> products = new ArrayList<>();
		products.add(door);
		products.add(floorPanel);
		products.add(window);
		
		List<Product> products1 = new ArrayList<>();
		Collections.addAll(products1, door, floorPanel, window);
		
		final Product product = Collections.min(products, Product.BY_NAME);
		System.out.println(product);
		
		final Product product2 = Collections.max(products, Product.BY_WEIGHT);
		System.out.println(product2);
	}

}
