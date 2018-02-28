package exerciseB;

public class Server {
	
	public static void main(String[] arg) {
		TaskList task = new TaskList();
		TaskListServer server = new TaskListServer(task, 2910);
		server.execute();
		
		
	}

}
