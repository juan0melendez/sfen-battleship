package client.gui;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;

import client.communication.ChatClient;
import client.gui.*;
import database.User;

public class ClientGUI extends JFrame
{
	// Private data fields for the 4 views.
	private JPanel view1;
	private JPanel view2;
	private JPanel view3;
	private JPanel view4;

	// Private data field for the chat client.
	private ChatClient client;

	// Private data field for the user object.
	private User user;

	// Private data fields for the card layout.
	private CardLayout cardLayout = new CardLayout();
	private JPanel container = new JPanel(cardLayout);

	// Getter and setter for the user object.
	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	// Constructor that creates the client GUI.
	public ClientGUI()
	{
		// Set up the chat client.
		client = new ChatClient();
		client.setHost("localhost");
		client.setPort(8300);
		try
		{
			client.openConnection();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		// Set the title and default close operation.
		this.setTitle("Chat Client");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create the card layout container.
		container = new JPanel(cardLayout);

		// Create the four views.
		view1 = new InitialPanel(container);
		view2 = new LoginPanel(container, client);
		view3 = new CreateAccountPanel(container, client);
		view4 = new ContactsPanel(container);

		// Add the views to the card layout container.
		container.add(view1, "1");
		container.add(view2, "2");
		container.add(view3, "3");
		container.add(view4, "4");

		// Show the initial view in the card layout.
		cardLayout.show(container, "1");

		// Add the card layout container to the JFrame.
		// GridBagLayout makes the container stay centered in the window.
		this.setLayout(new GridBagLayout());
		this.add(container);

		// Show the JFrame.
		this.setSize(550, 350);
		this.setVisible(true);
	}

	// Main function that creates the client GUI when the program is started.
	public static void main(String[] args)
	{
		new ClientGUI();
	}
}
