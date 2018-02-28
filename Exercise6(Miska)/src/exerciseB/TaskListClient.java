package exerciseB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.google.gson.Gson;

public class TaskListClient {

	private Scanner input;
	private Socket socket;
	private static String host;
	private static int port;

	public TaskListClient(String host, int port) {
		this.host = host;
		this.port = port;
		input = new Scanner(System.in);

	}

	public void execute() {
		Package pkg = null;
		String choice, taskName, json;
		int taskTime;
		Gson gson = new Gson();
		try {
			System.out.println("Trying to connect...");
			socket = new Socket(host, port);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			do {
				
				System.out.println("Choose : ADD,GET,SIZE or EXIT");
				choice = input.nextLine();
				pkg = createPackage(choice);
				json = gson.toJson(pkg);
				out.println(json);
				out.flush();
				
				json = in.readLine();
				pkg = gson.fromJson(json, Package.class);
				System.out.println(pkg);

			} while (!pkg.getText().equals("EXIT"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			input.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Package createPackage(String choice) {
		switch(choice) {
		case "ADD":
			System.out.println("Enter task");
			String taskName = input.nextLine();
			
			System.out.println("Enter estimated time");
			int taskTime = Integer.parseInt(input.nextLine());

			return new Package(Package.ADD, new Task(taskName, taskTime));
		case "GET":
			return new Package(Package.GET);
		case "SIZE":
			return new Package(Package.SIZE);
		case "EXIT":
			return new Package(Package.EXIT);
		}
		return new Package("WRONG FORMAT");
	}

}
