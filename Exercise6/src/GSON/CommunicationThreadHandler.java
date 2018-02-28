package GSON;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

public class CommunicationThreadHandler implements Runnable {

	private Socket client;
	private PrintWriter out;
	private BufferedReader in;
	private String ip;
	private LogList log;

	public CommunicationThreadHandler(Socket client, LogList log) {
		this.client = client;
		this.log = log;
	}

	@Override
	public void run() {
		try {
			out = new PrintWriter(client.getOutputStream());
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			Gson gson = new Gson();
			
			while (!client.isClosed()) {
				Message msg = gson.fromJson(in.readLine(), Message.class);
				System.out.println(msg.getBody());
				log.add(new Log(client.getInetAddress().getHostAddress(), msg));
				if (msg.getBody().equals("EXIT")) {
					System.out.println(log.toString());					
					break;
				}
				
			}
		} catch (IOException e) {
			System.out.println("Connection error");
			e.printStackTrace();
		} finally {
			System.out.println("Closing...");
			out.close();
			try {
				in.close();
				client.close();
			} catch (IOException e) {
				System.out.println("Closing error");
				e.printStackTrace();
			}
			
		}

	}

}
