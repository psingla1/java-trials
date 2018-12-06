package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewsOverMaps {
	public static void main(String[] args) {
		final Map<Integer, Product> idToProduct = new HashMap<>();
		idToProduct.put(1, ProductFixtures.door);
		idToProduct.put(2, ProductFixtures.floorPanel);
		idToProduct.put(3, ProductFixtures.window);
		
		System.out.println(idToProduct);
		System.out.println();
		
		//keyset view: Only Keys
		final Set<Integer> ids = idToProduct.keySet(); //keys are unique so it;s a set
		System.out.println(ids);
		
		ids.remove(1);
		System.out.println(ids);
		System.out.println(idToProduct);
		System.out.println();
		
		//ids.add(4); 
		// UnsupportedOperationException because we don't know the value associated with that key
		
		//Only values
		final Collection<Product> products = idToProduct.values();
		System.out.println(products);
		System.out.println();
		
		products.remove(ProductFixtures.floorPanel);
		System.out.println(products);
		System.out.println(idToProduct);
		System.out.println();
		
		//products.add(ProductFixtures.floorPanel); //error
		
		//EntrySet view: Keys and Values
		final Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet();
		// If we want to iterate over all the elelments in our collection, we can do that with entrySet
		// Map.Entry is an interface that corresponds to the entry for our Integer key and our Product value
		for (Map.Entry<Integer, Product> entry :  entries) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
			entry.setValue(ProductFixtures.floorPanel);
		}
		
		System.out.println(idToProduct);
	}

}
