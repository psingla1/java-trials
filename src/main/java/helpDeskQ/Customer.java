package helpDeskQ;

public class Customer {
	public static final Customer PURVI = new Customer("Purvi");
	public static final Customer JAI = new Customer("Jai");
	public static final Customer AARAV = new Customer("Aarav");
	
	private final String name;
	
	public Customer(final String name) {
		this.name = name;
	}
	
	public void reply(final String message) {
		System.out.printf("%s: %s\n", name, message);
	}
}
