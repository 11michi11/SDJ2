import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient {

	private static String host;
	private static final int PORT = 2910;

	public static void main(String[] args) {
		host = "10.152.144.13";
		try {
			System.out.println("Trying to connect...");
			Socket client = new Socket(host, PORT);
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out.println("Michaela Golhová");
			System.out.println(in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
