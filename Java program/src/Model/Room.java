package Model;

import java.util.ArrayList;

public class Room {
	
	private ArrayList<Seat> seats;
	private int roomNumber;
	
	public void displaySeats() {
		
	}
	
	
	public ArrayList<Seat> getSeats() {
		return seats;
	}
	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

}
