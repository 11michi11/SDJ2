package exerciseB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

public class TaskListCommunicationThreadHandler implements Runnable {

	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	private String ip;
	private TaskList tasklist;

	public TaskListCommunicationThreadHandler(Socket socket, TaskList tasklist) {
		this.socket = socket;
		this.tasklist = tasklist;
	}

	@Override
	public void run() {

		try {
			ip = socket.getInetAddress().getHostAddress();
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String clientText = in.readLine();
				System.out.println("Client>" + clientText);
				Gson gson = new Gson();
				Package task = gson.fromJson(clientText, Package.class);
				System.out.println(task);
				String json = gson.toJson(operation(task));
				out.println(json);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Package operation(Package request) {
		switch (request.getText()) {
		case "ADD":
			tasklist.add(request.getTask());
			return new Package(Package.ADD);
		case "GET":
			return new Package(Package.GET, tasklist.getAndRemoveNextTask());
		case "SIZE":
			return new Package(Package.SIZE + "=" + tasklist.size());

		case "EXIT":
			System.out.println("Exit");
			return new Package(Package.EXIT);
		default:
			break;
		}
		return new Package("WRONG FORMAT");
	}

}
