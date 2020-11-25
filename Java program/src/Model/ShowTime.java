package Model;

import java.time.LocalDateTime;

public class ShowTime {

	private Room room;
	private LocalDateTime dateTime;

	@Override
	public String toString() {
		String showTime = "";

		return showTime;
	}

	public void displaySeats() {

	}

	public Seat selectSeat() {
		Seat selectedSeat = null;
		return selectedSeat;

	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
