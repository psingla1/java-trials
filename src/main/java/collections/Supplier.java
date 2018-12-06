package collections;

import java.util.ArrayList;
import java.util.List;

public class Supplier {

	private final String name;
	private final List<Product> products;
	
	public Supplier(String name) {
		this.name = name;
		this.products = new ArrayList<>();
	}
	
	public List<Product> products() {
		return products;
	}
}
