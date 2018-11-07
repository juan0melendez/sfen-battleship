package server.cli;

import java.io.IOException;

import server.communication.GameServer;
/**
* Allows the server to be started without a
* heavy GUI
*/
public class GameServerCLI
{
	private GameServer server;

	public GameServerCLI(int port, int timeout)
	{
		// TODO Auto-generated constructor stub
		server = new GameServer(port);

		server.setPort(port);
		server.setTimeout(timeout);

		// Start listening
		try
		{
			server.listen();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Test if listening
		if (server.isListening())
		{
			System.out.println("Server is listening");
		}

		// Display number of Clients:
		System.out.println("Number of Client:" + server.getNumberOfClients());

		// Display the

	}

	public static void main(String[] args)
	{

		new GameServerCLI(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	}

}
