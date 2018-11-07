package server.communication;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import javax.swing.*;

import client.model.LoginData;

import java.awt.*;

public class GameServer extends AbstractServer
{
	private JTextArea log;
	private JLabel status;

	public GameServer()
	{
		super(12345);
	}

	public GameServer(int port)
	{
		super(port);
	}

	public void setLog(JTextArea log)
	{
		this.log = log;
	}

	public JTextArea getLog()
	{
		return log;
	}

	public void setStatus(JLabel status)
	{
		this.status = status;
	}

	public JLabel getStatus()
	{
		return status;
	}

	@Override
	protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	{
		if (arg0 instanceof LoginData)
		{
			LoginData loginData = (LoginData) arg0;

			System.out.println("Username/Password" + loginData.getUsername() + " " + loginData.getPassword());
		} else if (arg0 instanceof String)
		{
			System.out.println("Message from Client" + arg0.toString() + arg1.toString());
		}
		// log.append("Message from Client" + arg0.toString() + arg1.toString() + "\n");

	}

	protected void listeningException(Throwable exception)
	{
		// Display info about the exception
		System.out.println("Listening Exception:" + exception);
		exception.printStackTrace();
		System.out.println(exception.getMessage());

		/*
		 * if (this.isListening()) { log.append("Server not Listening\n");
		 * status.setText("Not Connected"); status.setForeground(Color.RED); }
		 */

	}

	protected void serverStarted()
	{
		System.out.println("Server Started");
		// log.append("Server Started\n");
	}

	protected void serverStopped()
	{
		System.out.println("Server Stopped");
		// log.append("Server Stopped Accepting New Clients - Press Listen to Start
		// Accepting New Clients\n");
	}

	protected void serverClosed()
	{
		System.out.println("Server and all current clients are closed - Press Listen to Restart");
		// log.append("Server and all current clients are closed - Press Listen to
		// Restart\n");
	}

	protected void clientConnected(ConnectionToClient client)
	{
		System.out.println("Client Connected");
		// log.append("Client Connected\n");
	}

}
