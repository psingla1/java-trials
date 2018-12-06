package helpDeskQ;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

public class HelpDesk {
	private final Queue<Enquiry> enquiries = new ArrayDeque();
	
	public void enquire(final Customer customer, final Category category) {
		enquiries.offer(new Enquiry(customer, category));
	}
	
	public void processAllEnquires() {
		while (!enquiries.isEmpty()) {
			final Enquiry enquiry = enquiries.remove();
			enquiry.getCustomer().reply("Have you tried turning on and off");
		}
		
		Enquiry enquiry;
		/*while((enquiry = enquiries.poll()) != null) {
			enquiry.getCustomer().reply("Have you tried turning on and off");
		} */
	}
	
	public void processPrinterEnquiry() {
		final Enquiry enquiry = enquiries.peek();
		if (enquiry != null && enquiry.getCategory() == Category.PRINTER) {
			enquiries.remove();
			enquiry.getCustomer().reply("Is it out of paper?");
		}
		else {
			System.out.println("No work to do, lets have some wine!");
		}
	}
	

	public void processGeneralEnquiry() {
		final Enquiry enquiry = enquiries.peek();
		if (enquiry != null && enquiry.getCategory() != Category.PRINTER) {
			enquiries.remove();
			enquiry.getCustomer().reply("Have you tried turning on and off");
		}
		else {
			System.out.println("No work to do, lets have some wine!");
		}
		
	}
	
	public void processPrinterEnquiryPredicate() {
		final Predicate<Enquiry> predicate = enq -> enq.getCategory() == Category.PRINTER;
		final String message = "Is it out of paper?";
		
		processEnquiry(predicate, message);
	}
	

	public void processGeneralEnquiryPredicate() {
		final Predicate<Enquiry> predicate = enq -> enq.getCategory() != Category.PRINTER;
		final String message = "Have you tried turning on and off";
		
		processEnquiry(predicate, message);
		
	}
	
	private void processEnquiry(final Predicate<Enquiry> predicate, final String message) {
		final Enquiry enquiry = enquiries.peek();
		if (enquiry != null && predicate.test(enquiry)) {
			enquiries.remove();
			enquiry.getCustomer().reply(message);
		}
		else {
			System.out.println("No work to do, lets have some wine!");
		}
	}
	
	public static void main(String[] args) {
		HelpDesk helpDesk = new HelpDesk();
		helpDesk.enquire(Customer.AARAV, Category.PRINTER);
		helpDesk.enquire(Customer.PURVI, Category.PHONE);
		helpDesk.enquire(Customer.JAI, Category.PRINTER);
		
		//helpDesk.processAllEnquires();
		helpDesk.processPrinterEnquiry();;
		helpDesk.processGeneralEnquiry();;
		helpDesk.processAllEnquires();
	}
}
