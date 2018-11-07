package client.controller;

import java.awt.*;
import javax.swing.*;

import client.communication.ChatClient;
import client.gui.LoginPanel;
import client.model.LoginData;

import java.awt.event.*;
import java.io.IOException;

/**
 * Acts as a controller between logging in and sending login data
 * 
 * @author juan
 *
 */
public class LoginControl implements ActionListener
{
	/**
	 * What is the "deck" in the deck of cards metaphor?
	 */
	private JPanel container;
	/**
	 * Class for the communication logic
	 */
	private ChatClient client;

	/**
	 * 
	 * @param container the deck
	 * @param client    the communication logic
	 */
	public LoginControl(JPanel container, ChatClient client)
	{
		this.container = container;
		this.client = client;
	}

	/**
	 * handles button clicks
	 */
	public void actionPerformed(ActionEvent ae)
	{
		// Get the name of the button clicked.
		String command = ae.getActionCommand();

		// The Cancel button takes the user back to the initial panel.
		if (command == "Cancel")
		{
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "1");
		}

		// The Submit button submits the login information to the server.
		else if (command == "Submit")
		{
			// Get the username and password the user entered.
			LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
			LoginData data = new LoginData(loginPanel.getUsername(), loginPanel.getPassword());

			// Check the validity of the information locally first.
			if (data.getUsername().equals("") || data.getPassword().equals(""))
			{
				displayError("You must enter a username and password.");
				return;
			} else
			{
				try
				{
					client.sendToServer(data);
				} catch (IOException e)
				{
					client.connectionException(e);
				}
			}

			// Submit the login information to the server.

		}
	}

	/**
	 * After the login is successful, set the User object and display the contacts
	 * screen. - this method would be invoked by the ChatClient
	 * 
	 */
	public void loginSuccess()
	{

	}

	/**
	 * Method that displays a message in the error - could be invoked by ChatClient
	 * or by this class
	 * 
	 * @param error
	 */
	public void displayError(String error)
	{
		LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
		loginPanel.setError(error);

	}
}
