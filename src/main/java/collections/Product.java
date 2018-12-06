package collections;

import java.util.Comparator;
import static java.util.Comparator.comparing;;

public class Product {
	
	public static final Comparator<Product> BY_WEIGHT_JAVA7 
		= new Comparator<Product> () {
		public int compare(final Product p1, Product p2) {
			return Integer.compare(p1.getWeight(), p2.getWeight());
		}
	}; 
	
	public static final Comparator<Product> BY_WEIGHT 
		= comparing(Product::getWeight);
	
	public static final Comparator<Product> BY_NAME 
	= comparing(Product::getName);
	
	private final int id;
	private final String name;
	private final int weight;
	public Product(String name, int weight, int id) {
		this.name = name;
		this.weight = weight;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return "Product{" +
				"name=" + name + " " + "weight=" + weight + '}';
		
		//return "Product{" +
		//"name='" + name + '\'' + ", weight=" + weight + '}';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weight;
		return result;
		// return Objects.hash(name, weight);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		return true;
		
		/*Product other = (Product) obj;
		if (weight != other.weight)
			return false;
		return Objects.equals(name, product.name);
		*/
	}
	
}
