package exerciseB;

public class Client {

	public static void main(String[] args) {
		TaskListClient client = new TaskListClient("127.0.0.1", 2910);
		client.execute();

	}

}
