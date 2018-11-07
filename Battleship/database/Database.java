package database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 * acts as a connecter between this system and the external interface of the
 * database it is connected to
 * 
 * @author juan
 *
 */
public class Database
{
	private Connection conn;

	// Add any other data fields you like – at least a Connection object is
	// mandatory
	/**
	 * Default Constructor for Database class. Will read the db.properties file and
	 * initialize the Connection private data field based
	 */
	public Database()
	{
		try
		{

			Properties props = new Properties();
			FileInputStream fis = new FileInputStream("db.properties");
			props.load(fis);
			conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"),
					props.getProperty("password"));

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * The method creates a JDBC Statement object that executes the query.
	 * 
	 * @param query an SQL query (i.e., select statement).
	 * @return ArrayList<String> all the data resulting from the query: a comma
	 *         delimited record separating each field
	 */
	public ArrayList<String> query(String query)
	{
		try
		{

			Statement stmt = conn.createStatement();
			ResultSet rs;

			ResultSetMetaData rms;

			rs = stmt.executeQuery(query);
			rms = rs.getMetaData();
			ArrayList<String> res = new ArrayList<String>();

			final int MAX = rms.getColumnCount();

			if (MAX == 0)
				return null;

			while (rs.next())
			{
				String record = "";
				for (int i = 1; i < MAX; i++)
				{
					record = rs.getString(i) + ",";
				}

				record += rs.getString(MAX);

				res.add(record);
			}

			return res;
		} catch (SQLException sql)

		{
			return null;
		}

	}

	/**
	 * creates a JDBC Statement object that executes the DML statement
	 * 
	 * @param dml contains a SQL Data Modification Language statement (i.e., insert,
	 *            update, or delete)
	 * @throws SQLException thrown if statement fails
	 */
	public void executeDML(String dml) throws SQLException
	{
		Statement stmt = conn.createStatement();
		stmt.execute(dml);
	}

}