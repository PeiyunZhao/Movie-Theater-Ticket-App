package Control;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	public String databaseName = "movieTheatre", tableName = "movie";
	

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

	
}
