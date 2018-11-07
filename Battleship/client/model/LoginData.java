package client.model;

import java.io.Serializable;

import game.model.Validatable;

/**
 * model component that allows the user's data to be stored and sent to the
 * server
 * 
 * @author juan
 *
 */
public class LoginData implements Serializable, Validatable
{
	// Private data fields for the username and password.
	private String username;
	private String password;

	// Getters for the username and password.
	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	// Setters for the username and password.
	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	// Constructor that initializes the username and password.
	public LoginData(String username, String password)
	{
		setUsername(username);
		setPassword(password);
	}
}