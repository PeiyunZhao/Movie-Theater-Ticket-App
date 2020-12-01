package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Control.DBController;

public class Seat {
	
	private int seatId;
	private Ticket ticket;
	private boolean isOpen; 
	private boolean isReserved;
	
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	
	public List<Seat> getAllSeat(){
		List<Seat> seats = new ArrayList<Seat>();
		DBController db = new DBController();
		ResultSet rs = db.readWholeTable("seat");
		try {
			while(rs.next()) {
				Seat seat = new Seat();
				seat.setSeatId(rs.getInt("seatid"));
				int taken = rs.getInt("seattaken");
				seat.setOpen(taken==0?true:false);
				seats.add(seat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seats;
	}
	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", isOpen=" + isOpen + ", isReserved=" + isReserved + "]";
	}
}
