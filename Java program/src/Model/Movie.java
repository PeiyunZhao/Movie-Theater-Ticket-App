package Model;

import java.util.ArrayList;

public class Movie {
	
	private String title;
	private ArrayList<Theater> theaters;
	private int MovieId;
	private boolean reservationOnly;
	
	@Override
	public String toString() {
		String movie="";
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

	

}
