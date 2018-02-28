package taskList;
import java.io.*;
import java.net.*;

import com.google.gson.Gson;

public class TaskListCommunicationThreadHandlerTwo implements Runnable {

	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;
	private String ip;
	private TaskList taskList;

	public TaskListCommunicationThreadHandlerTwo(Socket socket, TaskList taskList) {
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.taskList = taskList;
	}

	public void run() {
		String fromClientMessage, toClientMessage;
		Package fromClientPackage, toClientPackage;
		Gson gson;
		while (true) {
			try {
				fromClientMessage = in.readUTF();
				System.out.println("Client> " + fromClientMessage);
				gson = new Gson();
				fromClientPackage = gson.fromJson(fromClientMessage, Package.class);
				System.out.println("Package: " + fromClientPackage.getText());
				if (fromClientPackage.getText().toLowerCase().equals("exit")) {
					break;
				}
				gson = new Gson();
				toClientPackage = operation(fromClientMessage.toUpperCase(), fromClientPackage);
				toClientMessage = gson.toJson(toClientPackage);
				System.out.println("Server> " + toClientMessage);
				out.writeUTF(toClientMessage);
				if (fromClientMessage.toUpperCase().equals("EXIT"))
				{
					break;
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Closing connection??");
	}

	private Package operation(String operation, Package fromClient) {
		Package reply;
		switch (operation) {
		case "ADD":
			taskList.add(fromClient.getTask());
			reply = new Package(Package.ADD);
			break;
		case "GET":
			reply = new Package(Package.GET, taskList.getAndRemoveNextTask());
			break;
		case "SIZE":
			int size = taskList.size();
			if (size > 0) {
				reply = new Package(Package.SIZE + "=" + taskList.size());
			} else {
				reply = new Package("NO TASKS - EMPTY TASK LIST");
			}
			break;
		case "EXIT":
			reply = new Package(Package.EXIT);
			break;
		default:
			reply = new Package("WRONG FORMAT");
			break;
		}
		return reply;
	}
}
