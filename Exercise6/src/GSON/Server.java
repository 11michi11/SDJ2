package GSON;

public class Server {

	public static void main(String[] args) {
		ChatServer server = new ChatServer(2910);
		server.execute();
	}
	
}
