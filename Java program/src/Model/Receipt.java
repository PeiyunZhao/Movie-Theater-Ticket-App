package Model;

import java.time.LocalDateTime;
import java.util.Random;

public class Receipt {
	private Ticket ticket;
	private int receiptId;
	private int creditCard;
	private LocalDateTime dateTime;
	private String str;
	private double price;
	private boolean isRefunded = false;
	
	
	public Receipt(Ticket ticket, User u, double price) {
		this.receiptId= new Random().nextInt(100000);
		this.price=price;
		this.creditCard=u.getCreditCard();
		this.ticket=ticket;
		dateTime=LocalDateTime.now();
		
		str ="Date: "+dateTime+"\n"
				+"Receipt Number: "+receiptId+"\n"
				+" * Ticket number: "+ticket.getTicketId()+"\n"
				+" * Movie: "+ticket.getShowtime().getMovie().getTitle()+"\n"
				+" * ShowTime Purchased: "+ticket.getShowtime().getDateTime()+"\n"
				+"Total Amount Spent: "+price+"\n";
	}
	
	public Receipt(User u, double price) {
		this.receiptId= new Random().nextInt(100000);
		this.creditCard=u.getCreditCard();
		this.price=price;
		dateTime=LocalDateTime.now();
		
		str ="Date: "+dateTime+"\n"
				+"Receipt Number: "+receiptId+"\n"
				+" * Account Renewal \n"
				+"Total Amount Spent: "+price+"\n";
	}


	@Override
	public String toString() {
		return str;
	}
	
	public void getRefund() {
		isRefunded=true;
		
		str ="Date: "+dateTime+"\n"
				+"Receipt Number: "+receiptId+"\n"
				+" * Account Renewal \n"
				+"Total Amount Refunded: "+price+"\n";
	}
	
	
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public int getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
	public int getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	

}
