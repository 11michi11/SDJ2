
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.google.gson.Gson;

public class ChatClient {

	private Scanner input;
	private Socket socket;
	private static String host;
	private static int port;

	public ChatClient(String host, int port) {
		this.host = host;
		this.port = port;
		input = new Scanner(System.in);
	}

	public void execute() {

		try {
			System.out.println("Trying to connect...");
			socket = new Socket(host, port);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (!socket.isClosed()) {
				System.out.println("Write a message");
				String messageBody = input.nextLine();
				Message message = new Message(messageBody);
				Gson gson = new Gson();
				String json = gson.toJson(message);
				out.println(json);
				System.out.println(!socket.isClosed());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void close() {
		try {
			input.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
