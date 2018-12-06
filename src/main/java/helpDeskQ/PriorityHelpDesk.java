package helpDeskQ;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityHelpDesk {
	
	private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {
		public int compare(final Enquiry o1, final Enquiry o2) {
			return o1.getCategory().compareTo(o2.getCategory());
		}
	};
	
	private final Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);
	
	public void enquire(final Customer customer, final Category category) {
		enquiries.offer(new Enquiry(customer, category));
	}
	
	public void processAllEnquires() {
		Enquiry enquiry;
		while((enquiry = enquiries.poll()) != null) {
			enquiry.getCustomer().reply("Have you tried turning on and off");
		} 
	}

	
	public static void main(String[] args) {
		PriorityHelpDesk helpDesk = new PriorityHelpDesk();
		helpDesk.enquire(Customer.AARAV, Category.PRINTER);
		helpDesk.enquire(Customer.PURVI, Category.PHONE);
		helpDesk.enquire(Customer.JAI, Category.COMPUTER);
		helpDesk.processAllEnquires();
	}
}
