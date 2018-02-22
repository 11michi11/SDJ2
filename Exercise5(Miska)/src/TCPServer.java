import java.io.*;
import java.net.*;
public class TCPServer {
	
	private static ServerSocket welcomingSocket;
	private static final int PORT = 2910;
	private static String clientIP;
	
	public static void main(String[] args) {
		System.out.println("Starting Server...");
		try {
			welcomingSocket = new ServerSocket(PORT);			
		} catch (IOException e) {
			System.out.println("Unable to connect with the given port");
			System.exit(1);
		}
		do {
			System.out.println("Waiting for a client...");
			handleClient();		
		} while(true);
	}
	
	public static void handleClient() {
		Socket client = null;
		String request, response;
		try {
			client = welcomingSocket.accept();
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
