package GSON;

public class Client {

	public static void main(String[] args) {
		ChatClient client = new ChatClient("25.0.70.31", 2910);
		client.execute();
	}
	
}
