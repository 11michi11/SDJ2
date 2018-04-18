
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;

public class ChatServer {

	private ServerSocket welcomeSocket;
	private int port;

	public ChatServer(int port) {
		this.port = port;
	}

	public void execute() {
		System.out.println("Starting server");
		try {
			welcomeSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		do {
			System.out.println("Waiting for client");
			try {
				Socket socket = welcomeSocket.accept();
				Thread t = new Thread(new CommunicationThreadHandler(socket));
				t.start();
			} catch (IOException e) {
				System.out.println("Connection error");
				e.printStackTrace();
			}
		} while (true);
	}

}
