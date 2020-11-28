package Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Movie;
import Model.MovieList;
import Model.ShowTime;
import Model.Theater;
import server.Model.Item;

public class LogisticsController{
	private ArrayList<Movie> movies;
	private MovieList movieList;
	private Movie movie;
	private MainController mainController;
	private DBController dbController;
	
	
	public LogisticsController() throws IOException {
		while (true) {
			BufferedReader reader =  
	                   new BufferedReader(new InputStreamReader(System.in)); 
	         
	        // Reading data using readLine 
			String command = null;
			while (command == null) {
				command = reader.readLine();
			}

			String[] token = command.split(",");
			int option = Integer.parseInt(token[1]);

			switch (option) {
			case 1: // Print out all regular movies
				ArrayList<Movie> regularMovies = movieList.listRegularMovies();
				break;
				
			case 2: // Print out all reserved movies
				ArrayList<Movie> reservedMovies = movieList.listReservationMovies();
				break;
				
				
			
				
			default:
				System.out.println("Invalid selection. Please try again.\n");
				break;
	
			}
		}
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
	
	public ArrayList<Movie> allMovies() {
		movies = new ArrayList<Movie>();
		ResultSet rs = dbController.readWholeTable("movie");

		try {
			while (rs.next()) {
				String supplierID = rs.getString(1);
				String supplierType = rs.getString(2);
				String companyName = rs.getString(3);
				String address = rs.getString(4);
				String salesContact = rs.getString(5);
				Movie aMovie;
				
				movies.add(aMovie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}

	
	
	
	
	
	
	
	
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
//	public void displayRoom() {
//		return rooms;
//	}
	
	
	
	
	
	
	

}
