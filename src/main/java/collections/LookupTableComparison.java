package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LookupTableComparison {
	private static final int ITERATIONS = 5;
	private static final int NUMBER_OF_PRODUCTS = 20000;
	
	private static final List<Product> products = generateProducts();
	
	public static void main(String args[]) {
		runLookups(new NaiveProductLookupTable());
		runLookups(new MapProductLookupTable());
	}
	
	private static List<Product> generateProducts() {
		final List<Product> products = new ArrayList<>();
		final Random weightGenerator = new Random();
		for (int i = 0; i < NUMBER_OF_PRODUCTS; i++) {
			products.add(new Product("Product" + i, 10 + weightGenerator.nextInt(10), i));
		}
		Collections.shuffle(products);
		Collections.shuffle(products);
		Collections.shuffle(products);
		return products;
	}
	
	private static void runLookups(final ProductLookupTable lookupTable) {
		final List<Product> products = LookupTableComparison.products;
		System.out.println("Running lookups with " + lookupTable.getClass().getSimpleName());
		
		for (int i = 0; i < ITERATIONS; i++) {
			final long startTime = System.currentTimeMillis();
			
			for (Product product : products) {
				lookupTable.addProduct(product);
			}
			
			for (Product product : products) {
				final Product result = lookupTable.lookupById(product.getId());
				if (result != product) {
					throw new IllegalArgumentException("Lookup table returned wrong result for  " + product);
				}
			}
			
			lookupTable.clear();
			System.out.println(System.currentTimeMillis() - startTime + "ms");
		}
	}
}
