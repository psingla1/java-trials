package collections;

import java.util.HashMap;
import java.util.Map;

public class Java8Enhancements {
	
	public static void main(String[] args) {
		final Product defaultProduct = new Product("Whatever the customwe wants", 100, -1);
		
		final Map<Integer, Product> idToProduct = new HashMap<>();
		idToProduct.put(1, ProductFixtures.door);
		idToProduct.put(2, ProductFixtures.floorPanel);
		idToProduct.put(3, ProductFixtures.window);
		
		Product result = idToProduct.get(10);
		System.out.println(result);
		System.out.println();
		
		Product result1 = idToProduct.getOrDefault(10, defaultProduct); // does not modify the map
		System.out.println(result1);
		System.out.println(idToProduct.get(10));
		System.out.println();
		
		// It won't update the value if the key never existed before.
		Product result2 = idToProduct.replace(1, new Product("Big Door", 50, 1));
		System.out.println("Replaced value " +result2);
		System.out.println(idToProduct.get(1));
		System.out.println();
		
		idToProduct.replaceAll((id, oldProduct) ->
			new Product(oldProduct.getName(), oldProduct.getWeight() + 10, id));
		System.out.println(idToProduct);
		System.out.println();
		
		//update the map
		Product result3 = idToProduct.computeIfAbsent(10, (id) -> new Product("Custom Product", 10, id));
		System.out.println(result3);
		System.out.println(idToProduct.get(10));
		System.out.println();
		
		Product result4 = idToProduct.computeIfAbsent(2, (id) -> new Product("Custom Product", 10, id));
		System.out.println(result4);
		System.out.println(idToProduct.get(2));
		System.out.println();
		
		idToProduct.forEach((key, value) -> {
			System.out.println(key + " -> " + value);
		});
	}
}
