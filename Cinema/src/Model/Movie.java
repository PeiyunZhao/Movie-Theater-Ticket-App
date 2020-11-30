package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Control.DBController;

public class Movie {
	
	private String title;
	private ArrayList<Theater> theaters;
	private int MovieId;
	private boolean reservationOnly;
	private Double price;
	
	public Movie getMovieById(int mid) {
		Movie movie = null;
		String sql = "select * from Movie where mid=" + mid;
		System.out.println(sql);
		DBController db = new DBController();
		ResultSet rs = db.readFromTable(sql);
		try {
			if(rs.next()) {
				movie = new Movie();
				movie.setMovieId(rs.getInt("mid"));
				movie.setTitle(rs.getString("mname"));
				int reservationOnly = rs.getInt("mreserve");
				movie.setReservationOnly(reservationOnly==1?true:false);
				movie.setPrice(rs.getDouble("mprice"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	@Override
	public String toString() {
		return "Movie [title=" + title + ", MovieId=" + MovieId + ", reservationOnly=" + reservationOnly + ", price="
				+ price + "]";
	}

}
