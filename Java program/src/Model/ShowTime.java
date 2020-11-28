package Model;

import java.time.LocalDateTime;
import java.util.Date;


public class ShowTime {

	private String room;
	private LocalDateTime dateTime;
	private int showtimeId;
	private int movieId;
	//private LocalDateTime MovieTime;
	private Date MovieTime;
	
	public ShowTime(int showtimeId, int movieId, Date MovieTime,String room ) {
		this.showtimeId=showtimeId;
		this.movieId=movieId;
		this.MovieTime=MovieTime;
		this.room=room;
	}
	

	@Override
	public String toString() {
		String showTime = "showtime for movie "+movieId+ " is "+MovieTime+" at "+room;

		return showTime;
	}

	public Seat selectSeat() {
		Seat selectedSeat = null;
		return selectedSeat;

	}

	public String getRoom() {
		return room;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public int getMovieId() {
		return movieId;
	}

	public int getShowTimeId() {
		return showtimeId;
	}

}
