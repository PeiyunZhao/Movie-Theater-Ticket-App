package Model;

import java.time.LocalDateTime;

public class Receipt {
	private Ticket ticket;
	private int receiptId;
	private int creditCard;
	private LocalDateTime dateTime;
	
	@Override
	public String toString() {
		String receipt="";
		return receipt;
	}
	
	public void refund() {
		
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
