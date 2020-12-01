package Model;

import java.util.ArrayList;

public class Payment {
	
	private User user;
	private Ticket ticket;
	private Receipt receipt;
	private ArrayList<Coupon> coupons;
	private ArrayList<Receipt> recepits;
	
	public Payment(RegisteredUser u) {
		this.user=u;
		this.ticket=user.getWantsTicket();
		if(!u.paidAnnual()) {
			//paying 10$ annual fee before purchasing ticket
			authenticate(u,10.00);
		}
		process();
	}
	
	public Payment(OrdinaryUser u) {
		this.user=u;
		this.ticket=user.getWantsTicket();
		process();
	}
	
	public void process() {
		if (authenticate(user,ticket.getShowtime().getMovie().getPrice())) {
			generateTicket();
		}
	}
	
	public boolean authenticate (User user, Double price) {
		
		FinancialInstitute f= user.getFinancialInstitute();
		int cardnum= f.getCardNumber();
		String address= f.getUserAddress();
		String name=f.getUserName();
		System.out.println("Name: "+name
				+"\nCardNumber: "+cardnum
				+"\nBilling Address: \n"
				+address
				+"\n\nCharging: $"+price);
		
		System.out.println("Authenticating payment method...");
		
		//OUT OF SCOPE:
		//communication with financial institution would happen here....
		//
		

		System.out.println("verified payment");

		return true;
	}
	
	public void generateReceipt(Ticket t, User u, Double price) {
		
		this.receipt=new Receipt(ticket,user,price);
		
		System.out.println("\nPrinting Receipt...\n"+receipt.toString());
	}
	
	public void generateReceipt(User u, Double price) {
		
		this.receipt=new Receipt(u,price);
		
		System.out.println("\nPrinting Receipt...\n"+receipt.toString());
	}
	
	public void generateTicket() {
		
		System.out.println("\nPrinting Ticket....\n");
		System.out.println(user.getWantsTicket().toString());
	}
	
	public void refund() {
		
	}
	
	public boolean refundReceipt() {
		return true;
	}
	public void payAnnualFee(User user) {
		
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Receipt getReceipt() {
		return receipt;
	}
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	

}
