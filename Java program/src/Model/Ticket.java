package Model;

public class Ticket {
	private int ticketId;
	private User user;
	private boolean isReservation;
	private ShowTime showtime;
	private Seat seat;
	
	
	public void takeSeat() {
		seat.setTicket(this);
		
	}
	public void refund() {
		
	}
	
	@Override
	public String toString() {
		String str=
				"Ticket ID:"+ticketId+"\n"+
				"Date: "+showtime.getDateTime()+"\n"+
				"Movie: "+showtime.getMovie().getTitle()+"\n"+
				"Room: "+showtime.getRoom()+"\n"+
				"Seat: "+seat+"\n";
				
		return str;
	}
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isReservation() {
		return isReservation;
	}
	public void setReservation(boolean isReservation) {
		this.isReservation = isReservation;
	}
	public ShowTime getShowtime() {
		return showtime;
	}
	public void setShowtime(ShowTime showtime) {
		this.showtime = showtime;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
}
