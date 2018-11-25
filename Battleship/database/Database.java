package database;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Database
{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	//private ResultSetMetaData rmd;

	public Database() throws IOException
	{
		// Add your code here

		//
		// ResultSet rs;
		// ResultSetMetaData rmd;

		// Read properties file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("lab7out/db.properties");
		prop.load(fis);
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String pass = prop.getProperty("password");

		// Perform the Connection
		try
		{
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method for verifying a username and password.
	public boolean verifyAccount(String username, String password) throws SQLException
	{
		try
		{
			stmt = conn.createStatement();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Execute a query
		try
		{
			rs = stmt.executeQuery("select * from User WHERE username = \"" + username + "\" AND aes_decrypt(password, 'key') = \"" + password + "\"");
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rs.next() == false) {
			return false;
		}
		return true;
	}

	// Method for creating a new account.
	public boolean createNewAccount(String username, String password) throws SQLException
	{
		try
		{
			stmt = conn.createStatement();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			rs = stmt.executeQuery("select * from User WHERE username = \"" + username + "\"");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		if(rs.next() == false) {
			try
			{
				stmt.execute("insert into User values('" + username + "', aes_encrypt('" + password + "', 'key'));");
			} catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			return true;
		}
		
		return false;
	}
}
