package GSON;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.google.gson.Gson;

public class ChatClient {

	private Scanner sc;
	private BufferedReader in;
	private PrintWriter out;
	private Socket socket;
	private String host;
	private int port;

	public ChatClient(String host, int port) {
		sc = new Scanner(System.in);
		this.host = host;
		this.port = port;
	}
	
	public void execute() {
		String msgBody;
		Gson gson = new Gson();
		try {
			socket = new Socket(host, port);
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			do {
				System.out.println("Write message:");
				msgBody = sc.nextLine();
				Message msg = new Message(msgBody);
				out.println(gson.toJson(msg));
			}while(!msgBody.equals("EXIT"));
			
		} catch (IOException e) {
			System.out.println("Connection error");
			e.printStackTrace();
		}
	}

}
