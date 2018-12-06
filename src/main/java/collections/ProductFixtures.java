package collections;

public class ProductFixtures {
	public static Product door = new Product("Wooden Door", 35, 0);
	public static Product floorPanel = new Product("Floor Panel", 25, 1);
	public static Product window = new Product("Glass Window", 10, 2);
	
	public static Supplier bobs = new Supplier("Bobs's household supplies");
	public static Supplier kates = new Supplier("Kate's household supplies");
	
	static {
		bobs.products().add(door);
		bobs.products().add(floorPanel);
		
		kates.products().add(door);
		kates.products().add(window);
		kates.products().add(new Product("Floor Panel", 25, 4));
	}
	
}
