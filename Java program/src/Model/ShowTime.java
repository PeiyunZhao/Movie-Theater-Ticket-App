package Model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


public class ShowTime {

	private String room;
	private LocalDateTime dateTime;
	private int showtimeId;
	private Movie movie;
	//private LocalDateTime MovieTime;
	private Timestamp MovieTime;
	

	
	public ShowTime(int showtimeId, Movie movie, LocalDateTime dateTime,String room ) {
		this.showtimeId=showtimeId;
		this.movie=movie;
		this.dateTime=dateTime;
		this.room=room;
	//	dateTime = movieTime2.getTimestamp();
	
	}
	

	@Override
	public String toString() {
		String showTime = "showtime for movie "+movie.getTitle()+ " is "+MovieTime+" at "+room;

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
		return movie.getMovieId();
	}

	public int getShowTimeId() {
		return showtimeId;
	}


	public Movie getMovie() {
		
		return m;
	}

}
