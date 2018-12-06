package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class CollectionConcepts {
	public static void main(String[] args) {
		Product door = new Product("Wooden Door", 35, 0);
		Product floorPanel = new Product("Floor Panel", 25, 1);
		Product window = new Product("Glass Window", 10, 2);
		
		Collection<Product> products = new ArrayList<>();
		products.add(door);
		products.add(floorPanel);
		products.add(window);
		
		final Iterator<Product> productIterator = products.iterator();
		while (productIterator.hasNext()) {
			Product product = productIterator.next();
			System.out.println(product);
		}
		while (productIterator.hasNext()) {
			Product product = productIterator.next();
			if (product.getWeight() > 20) {
				System.out.println(product);
			}
			else {
				productIterator.remove();
			}
			System.out.println(products);
			System.out.println(products.size());
			System.out.println(products.isEmpty());
			System.out.println(products.contains(window));
			System.out.println(products.contains(door));
			
			List<Product> otherProducts = new ArrayList<>();
			otherProducts.add(door);
			otherProducts.add(window);
			
			products.removeAll(otherProducts);
			System.out.println(products);
		}
		
		
		for (Product product : products) {
			System.out.println(product);
		}
		
		//Exception because iterationg and changing the list at the same time
		for (Product product : products) {
			if (product.getWeight() > 20) {
				System.out.println(product);
			}
			else {
				products.remove(product);
			}
		}
	}
	
	
}
