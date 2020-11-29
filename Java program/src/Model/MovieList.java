package Model;

import java.util.ArrayList;

public class MovieList {

	private ArrayList<Movie> movieList;

	public MovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
		
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(ArrayList<Movie> movies) {
		movieList = movies;
	}

	public void listAllMovies() {
		// TODO Auto-generated method stub
		for (Movie m : movieList) {
			System.out.println(m);
		}

	}

	public Movie searchMovieId(int id) {
		for (Movie m : movieList) {
			if (m.getMovieId() == id)
				return m;
		}

		return null;
	}

	public Movie searchMovieTitle(String title) {
		for (Movie m : movieList) {
			if (m.getTitle().equals(title))
				return m;
		}

		return null;
	}

	public Movie findRegularMovies() {

		for (Movie m : movieList) {
			if (m.isReservationOnly() == false)
				return m;
		}
		return null;

	}

	public Movie findReservationMovies() {

		for (Movie m : movieList) {
			if (m.isReservationOnly() == true)
				return m;
		}
		return null;

	}

	public ArrayList<Movie> listRegularMovies() {
		ArrayList<Movie> mList = new ArrayList<Movie>();
		for (Movie m : movieList) {
			if (m.isReservationOnly() == false)
				mList.add(m);
		}
		System.out.println(mList);
		return mList;

	}

	public ArrayList<Movie> listReservationMovies() {
		ArrayList<Movie> mList = new ArrayList<Movie>();
		for (Movie m : movieList) {
			if (m.isReservationOnly() == true)
				mList.add(m);
		}
		return mList;

	}

	public Movie selectMovie() {
		Movie selectedMovie = null;
		return selectedMovie;
	}

	public void importShowTime(ArrayList<ShowTime> showtimes) {
		for (ShowTime st : showtimes) {
			Movie movie = searchMovieId(st.getMovieId());
			movie.addShowtime(st);
		}

	}

}
