package Model;

public class Payment {
	
	private User user;
	private Ticket ticket;
	private Receipt receipt;
	private boolean annualFee;
	
	
	public void process() {
		
	} 
	
	public boolean authenticate (User user) {
		return true;
	}
	
	public void generateReceipt() {
		
	}
	
	public void generateTicket() {
		
	}
	
	public void refund() {
		
	}
	public boolean requestRefund() {
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
	public boolean isAnnualFee() {
		return annualFee;
	}
	public void setAnnualFee(boolean annualFee) {
		this.annualFee = annualFee;
	}
	
	

}
