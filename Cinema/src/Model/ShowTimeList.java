package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Control.DBController;

public class ShowTimeList {

	private List<Room> rooms;
	private List<ShowTime> showtimes;
	public ShowTimeList() {
		rooms = new ArrayList<Room>();
		showtimes = new ArrayList<ShowTime>();
	}
	
	public List<Room> getRooms(){
		DBController db = new DBController();
		ResultSet rs = db.readWholeTable("showtime");
		try {
			while(rs.next()) {
				Room room = new Room();
				ShowTime showTime = new ShowTime();
				showTime.setStid(rs.getShort("showid"));
				showTime.setDateTime(rs.getString("showtime"));
				room.setRoomNumber(rs.getString("showroom"));
				if(!rooms.contains(room)) {
					rooms.add(room);
				} 
				showTime.setRoom(room);
				showtimes.add(showTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	public List<ShowTime> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(List<ShowTime> showtimes) {
		this.showtimes = showtimes;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	
}
