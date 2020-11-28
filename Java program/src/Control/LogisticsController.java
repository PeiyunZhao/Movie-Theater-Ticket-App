package Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import Model.Movie;
import Model.MovieList;
import Model.ShowTime;
import Model.ShowTimeList;
import Model.Theater;


public class LogisticsController{
	private ArrayList<Movie> movies;
	private MovieList movieList;
	private ShowTimeList showtimeList;
	private ArrayList<ShowTime> showtimes;
	private Movie movie;
	private MainController mainController;
	private DBController dbController;
	
	
//	public LogisticsController() throws IOException {
//		while (true) {
//			BufferedReader reader =  
//	                   new BufferedReader(new InputStreamReader(System.in)); 
//	         
//	        // Reading data using readLine 
//			String command = null;
//			while (command == null) {
//				command = reader.readLine();
//			}
//
//			String[] token = command.split(",");
//			int option = Integer.parseInt(token[1]);
//
//			switch (option) {
//			case 1: // Print out all regular movies
//				ArrayList<Movie> regularMovies = movieList.listRegularMovies();
//				System.out.println(regularMovies);
//				break;
//				
//			case 2: // Print out all reserved movies
//				ArrayList<Movie> reservedMovies = movieList.listReservationMovies();
//				System.out.println(reservedMovies);
//				break;
//				
//			case 3://find showtime by movie
//				System.out.println("enter movie id");
//				int movieid=Integer.parseInt(reader.readLine());
//				ArrayList<ShowTime> showtimes = showtimeList.findShowTimeByMovieId(movieid) ;
//				System.out.println(showtimes);
//				break;
//				
//			
//				
//			default:
//				System.out.println("Invalid selection. Please try again.\n");
//				break;
//	
//			}
//		}
//	}
	
	
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
	
	public ArrayList<Movie> allMovies() {
		movies = new ArrayList<Movie>();
		ResultSet rs = dbController.readWholeTable("movie");

		try {
			while (rs.next()) {
				String movieID = rs.getString(1);
				String movieName = rs.getString(2);
			//	String isReserve = rs.getString(3);
				boolean isReserve = rs.getBoolean(3);
				String moviePrice = rs.getString(4);
	
				Movie aMovie=new Movie(Integer.parseInt(movieID),movieName,isReserve,Double.parseDouble(moviePrice));
				
				movies.add(aMovie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(movies);
		return movies;
	}

	
	public ArrayList<ShowTime> allShowTime() {
		showtimes = new ArrayList<ShowTime>();
		ResultSet rs = dbController.readWholeTable("showtime");
		

		try {
			while (rs.next()) {
				String showtimeID = rs.getString(1);
				String movieID = rs.getString(2);
				Date movieTime = rs.getDate(3);
			
				String movieRoom = rs.getString(4);
	
				ShowTime aShowTime=new ShowTime(Integer.parseInt(showtimeID),Integer.parseInt(movieID),movieTime,movieRoom);
				
				showtimes.add(aShowTime);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(showtimes);
		return showtimes;
	}
	
	

	public void run() {
	    dbController = new DBController();
		MovieList theMovie = new MovieList(allMovies());
	
		ShowTimeList theShowTime = new ShowTimeList(allShowTime());
		ArrayList<Movie> regularMovies = theMovie.listRegularMovies();
		System.out.println(regularMovies);
		
	}
	
	

	
	
	
	
	

}
