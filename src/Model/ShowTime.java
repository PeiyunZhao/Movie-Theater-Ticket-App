package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import Control.DBController;

public class ShowTime {

	private int stid;
	private Room room;
	private String dateTime;
	private List<ShowTime> showtimes;
	
	public ShowTime() {
		room = new Room();
	}
	
	public ShowTime getTicketById(String timeId) {
		ShowTime showTime = null;
		String sql = "select * from showtime where showid=" + timeId;
		System.out.println(sql);
		DBController db = new DBController();
		ResultSet rs = db.readFromTable(sql);
		try {
			if (rs.next()) {
				showTime = new ShowTime();
				showTime.setStid(rs.getInt("showid"));
				showTime.setDateTime(rs.getString("showtime")); 
			}
		} catch (SQLException e) {
			return null;
		}
		return showTime;
	}
	


	
	
	@Override
	public String toString() {
		return this.dateTime;
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

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
	}

}
