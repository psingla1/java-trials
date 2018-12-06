package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ProductCatalogue implements Iterable<Product> {
	
	private final Set<Product> products = new HashSet<>();
	private final SortedSet<Product> products1 = new TreeSet<>(Product.BY_WEIGHT);
	
	public void isSuppliedBy(Supplier supplier) {
		products1.addAll(supplier.products());
	}

	@Override
	public Iterator<Product> iterator() {
		return products1.iterator();
	}
	
	public Set<Product> lightVanProducts() {
		Product heaviestLightVanProduct = findHeaviestLightVanProduct();
		return products1.headSet(heaviestLightVanProduct);
	}
	
	public Set<Product> heavyVanProducts() {
		Product heaviestLightVanProduct = findHeaviestLightVanProduct();
		return products1.tailSet(heaviestLightVanProduct);
	}

	private Product findHeaviestLightVanProduct() {
		for (Product product : products1) {
			if (product.getWeight() > 20) {
				return product;
			}
		}
		return products1.last();
	}
}
