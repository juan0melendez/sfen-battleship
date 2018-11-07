package client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.controller.InitialControl;

/**
 * Makes the GUI, inits the frames, and attaches the chat client
 * 
 * @author juan
 *
 */
public class ChatGUI extends JFrame
{

	private JPanel initialPane;
	private InitialControl initialControl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ChatGUI frame = new ChatGUI();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		initialPane = new InitialPanel(initialControl);
		setContentPane(initialPane);
	}

}
