package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Control.DBController;

public class MovieList {

	private ArrayList<Movie> movies;

	public String displayRegularMovies() {
		String regularMovies = "";
		
		return regularMovies;
	}

	public String displayReservationMovies() {
		String reservationMovies = "";
		
		return reservationMovies;
	}

	public Movie selectMovie() {
		Movie selectedMovie = null;
		
		return selectedMovie;
	}

	public ArrayList<Movie> getMovies() {
		movies = new ArrayList<Movie>();
		DBController db = new DBController();
		String sql="select * from movie where mreserve=0";
		ResultSet rs = db.readFromTable(sql);
		try {
			while(rs.next()) {
				Movie m = new Movie();
				m.setMovieId(rs.getInt("mid"));
				m.setTitle(rs.getString("mname"));
				int reservationOnly = rs.getInt("mreserve");
				m.setReservationOnly(reservationOnly==1?true:false);
				m.setPrice(rs.getDouble("mprice"));
				movies.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}

	public void setGloabData(String movieTitle) {
		AppSeting.movie.setTitle(movieTitle);
		for (Movie movie : movies) {
		if (movie.getTitle().equals(movieTitle)) {
			AppSeting.movie.setMovieId(movie.getMovieId());
			AppSeting.movie.setPrice(movie.getPrice());
			break;
		}
	}
	}
	
	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}

	public ArrayList<Movie> getBookMovies() {
		movies = new ArrayList<Movie>();
		DBController db = new DBController();
		String sql="select * from movie where mreserve=1";
		ResultSet rs = db.readFromTable(sql);
		try {
			while(rs.next()) {
				Movie m = new Movie();
				m.setMovieId(rs.getInt("mid"));
				m.setTitle(rs.getString("mname"));
				int reservationOnly = rs.getInt("mreserve");
				m.setReservationOnly(reservationOnly==1?true:false);
				m.setPrice(rs.getDouble("mprice"));
				movies.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}

}
