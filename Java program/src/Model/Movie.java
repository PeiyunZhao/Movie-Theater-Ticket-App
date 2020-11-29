package Model;

import java.util.ArrayList;

public class Movie {
	
	private String title;
	//private ShowTimeList showtimelist;
	private ArrayList<ShowTime> showtimes;
	private int MovieId;
	private boolean reservationOnly;
	private double price;
	
	
	public Movie(int MovieId,String title,boolean reservationOnly,double price) {
		this.MovieId= MovieId;
		this.title=title;
		this.reservationOnly=reservationOnly;
		this.price=price;
		showtimes=new ArrayList<ShowTime>();

		
	}
	
	public void addShowtime(ShowTime st) {
		showtimes.add(st);
	}
	
	@Override
	public String toString() {
		String movie="Movie name: "+title+" costs "+price+" is "+reservationOnly;
		return movie;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMovieId() {
		return MovieId;
	}

	public void setMovieId(int movieId) {
		MovieId = movieId;
	}

	public boolean isReservationOnly() {
		return reservationOnly;
	}

	public void setReservationOnly(boolean reservationOnly) {
		this.reservationOnly = reservationOnly;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ArrayList<ShowTime> getShowTimes() {
		return showtimes;
	}
	
	

}
