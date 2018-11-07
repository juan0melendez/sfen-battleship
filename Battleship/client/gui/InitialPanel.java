package client.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.controller.InitialControl;

/**
 * visual component that is the first view the user has of the system
 * 
 * @author juan
 *
 */
public class InitialPanel extends JPanel
{
	// Constructor for the initial panel.
	public InitialPanel(InitialControl ic)
	{
		// Create the controller.
		// InitialControl controller = new InitialControl(container);

		// Create the information label.
		JLabel label = new JLabel("Account Information", JLabel.CENTER);

		// Create the login button.
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(ic);
		JPanel loginButtonBuffer = new JPanel();
		loginButtonBuffer.add(loginButton);

		// Create the create account button.
		JButton createButton = new JButton("Create");
		createButton.addActionListener(ic);
		JPanel createButtonBuffer = new JPanel();
		createButtonBuffer.add(createButton);

		// Arrange the components in a grid.
		JPanel grid = new JPanel(new GridLayout(3, 1, 5, 5));
		grid.add(label);
		grid.add(loginButtonBuffer);
		grid.add(createButtonBuffer);
		this.add(grid);
	}
}
