package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import Model.Movie;

public class DBController {
	public Connection jdbc_connection;
	public Statement statement;
	public String localhost = "3306", databaseName = "movieTheatre";
	public String connectionInfo = "jdbc:mysql://localhost:" + localhost + "/" + databaseName+"?serverTimezone=UTC",  
			  login          = "root",
			  password       = "lindaA5585769.";
	
	private String tableName = "movie";
	private int counter = 0;
	private JList<Movie> movieJList;
	private DefaultListModel movieList = new DefaultListModel();
	
	public DBController() {
		try{
			// If this throws an error, make sure you have added the mySQL connector JAR to the project
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// If this fails make sure your connectionInfo and login/password are correct
			jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
			System.out.println("Connected to: " + connectionInfo + "\n");
		}
		catch(SQLException e) { e.printStackTrace(); }
		catch(Exception e) { e.printStackTrace(); }
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
	
	public void insertToTable(String sql) {
		try{
			statement = jdbc_connection.createStatement();
			statement.executeUpdate(sql);
		}
		catch(SQLException e)
		{e.printStackTrace();}
	}
	
	public ResultSet readWholeTable(String tableName) {
		// able to send result set to model controller to construct all types of objects
		String sql = "SELECT * FROM " + tableName;
		return readFromTable(sql);
	}
	
	public ResultSet searchFromTable(String tableName, String attributeName, String searchString) {
		// able to send result set to model controller to construct all types of objects
		String sql = "SELECT * FROM " + tableName + " WHERE " + attributeName + "=" + searchString;		
		return readFromTable(sql);
	}

	

	public DefaultListModel<Movie> getMovieList() {
		// TODO Auto-generated method stub
		return movieList;
	}
	public JList<Movie> getClientJList() {
		return movieJList;
	}

	
	public JList populateList() {
		String sql = "SELECT * FROM " + tableName;
		ResultSet movies;
		Movie tempMovie;
		try {
			PreparedStatement statement2 = jdbc_connection.prepareStatement(sql);
			movies = statement2.executeQuery();
			while(movies.next())
			{
				tempMovie = new Movie(movies.getInt("mid"),
						movies.getString("mname"), 
						movies.getString("mtype"),  
						movies.getBoolean("mreserve"),  
						movies.getDouble("mprice"));
				movieList.add(counter,tempMovie);
				counter = counter + 1;
			}
			movies.close();
			statement2.close();
			movieJList = new JList(movieList);
			return movieJList;
		} catch (SQLException e) { e.printStackTrace(); }
		
		return null;
	}
	
	
	
	
}
