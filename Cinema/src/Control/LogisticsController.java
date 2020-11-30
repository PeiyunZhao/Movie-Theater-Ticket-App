package Control;

import Model.Movie;
import Model.MovieList;
import Model.ShowTime;
import Model.Theater;

public class LogisticsController {
	
	private MovieList movies;

	public LogisticsController() {
		movies = new MovieList(); 
	}
	public Movie selectMovie(int id) {
		Movie selectedMovie = null;

		return selectedMovie;
	}

	public Theater selectTheatre() {
		Theater selectedTheater = null;

		return selectedTheater;
	}

	public ShowTime selectShowtime(int id) {
		ShowTime selectedShowtime = null;

		return selectedShowtime;
	}
	
	public MovieList displayMovies() {
		return movies;
	}
	public MovieList getMovies() {
		return movies;
	}
	public void setMovies(MovieList movies) {
		this.movies = movies;
	}
}
