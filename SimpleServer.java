package SN;

import java.net.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class SimpleServer {

	static Random rnd = new Random();
	static MagicEightBall magicEightBall = new MagicEightBall(rnd);
	
	public static void main(String[] args) throws IOException {

		// Hard code in port number if necessary:
		args = new String[] { "30121" };
		
		if (args.length != 1) {
			System.err.println("Usage: java EchoServer <port number>");
			System.exit(1);
		}

		int portNumber = Integer.parseInt(args[0]);

		try (ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
				Socket clientSocket = serverSocket.accept();
				// os sends out objects to client
		        ObjectOutputStream os = new ObjectOutputStream(clientSocket.getOutputStream());
				//PrintWriter responseWriter = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader requestReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				) {
			ArrayList<Packet> dataList = new ArrayList<>();
			createList(dataList);
			
			String requestMissing;
			while ((requestMissing = requestReader.readLine()) != null) {
				// send list of packets to client
				os.writeObject(dataList);
				os.flush();
				System.out.println("\"" + requestMissing + "\" received");
				//String response = magicEightBall.getNextAnswer();
				//System.out.println("Responding: \"" + response + "\"");
				//responseWriter.println(response);
			}
		} catch (IOException e) {
			System.out.println(
					"Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
			System.out.println(e.getMessage());
		}

	}
	
	public static void createList(ArrayList<Packet> dataList) {
		for (int i = 0; i < 20; i++) {
			dataList.add(new Packet(i));
		}
	}

}

