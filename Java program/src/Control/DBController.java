package Control;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import Model.Movie;
import Model.MovieList;
import Model.ShowTime;
import Model.ShowTimeList;

public class DBController {

	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "movieTheatre", tableName = "movie";
	private ArrayList<Movie> movies;
	private ArrayList<ShowTime> showtimes;
	private MovieList movieList;
	private ShowTimeList showtimeList;
	

	public String connectionInfo = "jdbc:mysql://localhost:3306/movieTheatre", login = "root",
			password = "lindaA5585769.";

	public DBController() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			// If this fails make sure your connectionInfo and login/password are correct
			jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
			System.out.println("Connected to: " + connectionInfo + "\n");
			movies=allMovies();
			showtimes=allShowTime();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public ResultSet readFromTable(String sql) {
		ResultSet rs = null;
		try
		{
			statement = jdbc_connection.prepareStatement(sql);
			rs = statement.executeQuery(sql);
		}
		catch(SQLException e) { e.printStackTrace(); }
		catch(Exception e) { e.printStackTrace(); }
		return rs;
	}
	

	public ResultSet readWholeTable(String tableName) {
		// able to send result set to model controller to construct all types of objects
		String sql = "SELECT * FROM " + tableName + ";";
		return readFromTable(sql);
	}
	
	public ResultSet searchFromTable(String tableName, String attributeName, String searchString) {
		// able to send result set to model controller to construct all types of objects
		String sql = "SELECT * FROM " + tableName + " WHERE " + attributeName + "='" + searchString + "';";		
		return readFromTable(sql);
	}
	

	public ArrayList<Movie> allMovies() {
		movies = new ArrayList<Movie>();
		ResultSet rs = readWholeTable("movie");

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
		ResultSet rs =readWholeTable("showtime");
		

		try {
			while (rs.next()) {
				String showtimeID = rs.getString(1);
				String movieID = rs.getString(2);
				Timestamp movieTime = rs.getTimestamp(3);
				
				System.out.println(movieTime);
			   LocalDateTime dt=convertToEntityAttribute(movieTime);
				String movieRoom = rs.getString(4);
				 movieList=new MovieList(getMovies());
				ShowTime aShowTime=new ShowTime(Integer.parseInt(showtimeID),movieList.searchMovieId(Integer.parseInt(movieID)),dt,movieRoom);
				
				showtimes.add(aShowTime);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(showtimes);
		return showtimes;
	}
	
	 public Timestamp convertToDatabaseColumn(LocalDateTime ldt) {
	        return Timestamp.valueOf(ldt);
	    }


	    public LocalDateTime convertToEntityAttribute(Timestamp ts) {
	    	if(ts!=null){
	    		   return ts.toLocalDateTime();
	    	}
	    	return null;
	    }

	    public ArrayList<Movie> getMovies(){
	    	return movies;
	    }
	    
	    public ArrayList<ShowTime> getShowTime(){
	    	return showtimes;
	    }
	
	

	
}
