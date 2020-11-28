package Control;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import Model.Movie;

public class DBController {

	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "movieTheatre", tableName = "movie", dataFile = "clients.txt";
	private JList<Movie> movieJList;

	public JList<Movie> getMovieJList() {
		return movieJList;
	}

	private DefaultListModel movieList = new DefaultListModel();

	public DefaultListModel<Movie> getMovieList() {
		return movieList;
	}

	private int counter = 0;
	private int index = 0;
	private int newID;

	public int getNewID() {
		return newID;
	}

	public String connectionInfo = "jdbc:mysql://localhost:3306/movieTheatre", login = "root",
			password = "lindaA5585769.";

	public DBController() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			// If this fails make sure your connectionInfo and login/password are correct
			jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
			System.out.println("Connected to: " + connectionInfo + "\n");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Use the jdbc connection to create a new database in MySQL.
	// (e.g. if you are connected to "jdbc:mysql://localhost:3306", the database
	// will be created at "jdbc:mysql://localhost:3306/InventoryDB")
	public void createDB() {
		try {
			statement = jdbc_connection.createStatement();
			statement.executeUpdate("CREATE DATABASE " + databaseName);
			System.out.println("Created Database " + databaseName);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JList populateList() {
		String sql = "SELECT * FROM " + tableName;
		ResultSet movies;
		Movie tempmovie;
		try {
			PreparedStatement statement2 = jdbc_connection.prepareStatement(sql);
			movies = statement2.executeQuery();
			while (movies.next()) {
				tempmovie = new Movie(movies.getInt("mid"), movies.getString("mname"), movies.getString("mtype"),
						movies.getBoolean("mreserve"), movies.getDouble("mprice"));
				movieList.add(counter, tempmovie);
				counter = counter + 1;
				movieList.add(counter, tempmovie);
				counter = counter + 1;
			}
			movies.close();
			statement2.close();
			movieJList = new JList(movieList);
			return movieJList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

//	public static void main(String[] args) {
//
//		DBController theModel = new DBController();
//		theModel.populateList();
//
//	}
}
