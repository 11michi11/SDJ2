import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	private static ServerSocket welcomingSocket;
	private static final int PORT = 2910;
	private static String clientIP;

	public void start() {
		System.out.println("Starting Server...");
		try {
			welcomingSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			System.out.println("Unable to connect with the given port");
			System.exit(1);
		}
		do {
			System.out.println("Waiting for a client...");
			try {
				Socket client = welcomingSocket.accept();
				Thread t = new Thread(new HandleClient(client));
			} catch (IOException e) {
				System.out.println("Connection error");
				e.printStackTrace();
			}
		} while (true);
	}

	public static void main(String[] args) {
		TCPServer server = new TCPServer();
		server.start();
	}

	class HandleClient implements Runnable {

		private Socket client;

		public HandleClient(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {

			String request, response;
			try {
				clientIP = client.getInetAddress().getHostAddress();
				System.out.println("Welcome " + clientIP);
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

				request = in.readLine();
				System.out.println(request);
				response = "Michaela Golhova";

				out.println("response : " + response);

			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}

		}

	}

}
