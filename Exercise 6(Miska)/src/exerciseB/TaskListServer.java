package exerciseB;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskListServer {

	private ServerSocket welcomeSocket;
	private TaskList taskList;
	private int port;

	public TaskListServer(TaskList taskList, int port) {
		this.port = port;
		this.taskList = taskList;
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
				Socket client = welcomeSocket.accept();
				Thread t = new Thread(new TaskListCommunicationThreadHandler(client, taskList));
				t.start();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Connection error");
			}
		} while(true);

	}

}
