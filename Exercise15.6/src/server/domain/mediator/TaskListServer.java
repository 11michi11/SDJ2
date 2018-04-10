package server.domain.mediator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskListServer implements Runnable {

	private ServerSocket welcomeSocket;
	private TaskListModel taskList;
	private int port;

	public TaskListServer(TaskListModel taskList, int port) {
		this.port = port;
		this.taskList = taskList;
	}

	@Override
	public void run() {
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
