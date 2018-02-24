import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class AddingServer {

	private ServerSocket server;
	private Socket client;
	private Map<String, User> users;

	public AddingServer() {
		users = new HashMap<String, User>();
	}

	public void start() {

		try {
			server = new ServerSocket(2910);
			System.out.println("Server up");
			while (true) {
				System.out.println("Listening for connection...");
				client = server.accept();
				System.out.println("Connection received from " + client.getInetAddress());
				Thread t = new Thread(new HandleClient(client));
				t.start();
			}
		} catch (IOException e) {
			System.out.println("Server error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	class HandleClient implements Runnable {

		private Socket client;

		public HandleClient(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {
			ObjectInputStream in;
			ObjectOutputStream out;
			int a, b;
			String userAdr, login;
			int pwd;
			try {
				out = new ObjectOutputStream(client.getOutputStream());
				in = new ObjectInputStream(client.getInputStream());

				userAdr = client.getInetAddress().getHostAddress();
				if (users.containsKey(userAdr)) {
					out.writeUTF("login");
					out.flush();
					login = in.readUTF();
					pwd = in.readInt();
					System.out.println("User " + login + " logging in... pwd = " + pwd);
					User user = users.get(userAdr);
					if (user.authenticate(login, pwd)) {
						out.writeUTF("OK");
						out.flush();
						System.out.println("User " + login + " logged in");
						while (!client.isClosed()) {
							a = in.readInt();
							b = in.readInt();
							System.out.println("Received: " + a + ";" + b + "\nSending: " + (a + b));
							out.writeInt(a + b);
							out.flush();
						}
					} else {
						out.writeUTF("NOT");
						System.out.println("User " + login + "not logged in");
						out.flush();
						out.close();
					}
				}else {
					out.writeUTF("register");
					out.flush();
					login = in.readUTF();
					pwd = in.readInt();
					
					users.put(userAdr, new User(login, pwd));
					out.writeUTF("REGISTERED");
					System.out.println("User " + login + " registered");
				}
				
				out.close();
				in.close();
				client.close();
				
			} catch (IOException e) {
				System.out.println("Connection error: " + e.getMessage());
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		AddingServer server = new AddingServer();
		server.start();
	}

}
