import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Handler;

import com.google.gson.Gson;

public class CommunicationThreadHandler implements Runnable {

	private Socket socket;
	private String ip;
	private static final int PORT = 2910;
	private static ServerSocket welcomingSocket;

	public CommunicationThreadHandler(Socket socket) {
		this.socket = socket;
		ip = "25.88.12.46";
	}

	@Override
	public void run() {

		try {
			ip = socket.getInetAddress().getHostAddress();
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String clientText = in.readLine();
				System.out.println("Client>" + clientText);

				Gson gson = new Gson();
				Message message = gson.fromJson(clientText, Message.class);

				System.out.println(message);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}