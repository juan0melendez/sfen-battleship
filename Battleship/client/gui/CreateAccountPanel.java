package client.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.controller.CreateAccountControl;

/**
 * Visual component that lets users create an account
 * 
 * @author juan
 *
 */
public class CreateAccountPanel extends JPanel
{

	public JLabel j;
	private ActionListener controller;

	/**
	 * Create the panel.
	 */

	public CreateAccountPanel(CreateAccountControl ac)
	{
		controller = ac;

		initComponents();
	}

	private void initComponents()
	{
		JLabel prompt1 = new JLabel("Enter a username to create an account");
		JLabel prompt2 = new JLabel("Your password must be at least 6 characters");

		JTextField usernameField;
		JTextField passwordField;
		JTextField repeatPasswordField;

		JButton submit = new JButton("Submit");
		JButton cancel = new JButton("Cancel");

		JPanel prompt = new JPanel(new GridLayout(2, 1, 0, 10));
		prompt.add(prompt1);
		prompt.add(prompt2);

		JPanel grid = new JPanel(new GridLayout(3, 2, 10, 10));

		JLabel usernameLabel = new JLabel("Username:", JLabel.RIGHT);
		usernameField = new JTextField(10);
		JLabel passwordLabel = new JLabel("Password:", JLabel.RIGHT);
		passwordField = new JPasswordField(10);
		JLabel repeatPasswordLabel = new JLabel("Repeat password:", JLabel.RIGHT);
		repeatPasswordField = new JPasswordField(10);
		grid.add(usernameLabel);
		grid.add(usernameField);
		grid.add(passwordLabel);
		grid.add(passwordField);
		grid.add(repeatPasswordLabel);
		grid.add(repeatPasswordField);

		JPanel buttons = new JPanel();
		submit.addActionListener(controller);
		cancel.addActionListener(controller);

		buttons.add(submit);
		buttons.add(cancel);

		grid.add(prompt1);
		grid.add(prompt2);

		add(grid, BorderLayout.SOUTH);
		add(buttons);
	}

}
