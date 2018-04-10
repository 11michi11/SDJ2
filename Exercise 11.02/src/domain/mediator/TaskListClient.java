package domain.mediator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.google.gson.Gson;

import domain.model.Task;


public class TaskListClient implements TaskListModel{

	private Scanner input;
	private Socket socket;
	private static String host;
	private static int port;

	public TaskListClient(String host, int port) {
		this.host = host;
		this.port = port;
		input = new Scanner(System.in);

	}

	@Override
	public void add(Task task) {	
		Package pkg = new Package(Package.ADD);
		Package response = remoteCall(pkg);
		
	}

	@Override
	public Task get() {
		Package pkg = new Package(Package.GET);
		Package response = remoteCall(pkg);
		return response.getTask();
	}

	@Override
	public int size() {
		Package pkg = new Package(Package.SIZE);
		Package response = remoteCall(pkg);
		return Integer.parseInt(response.getText());
	}
	
	private Package remoteCall(Package request) {
		String json;
		Package response = null;
		Gson gson = new Gson();
		try {
			System.out.println("Trying to connect...");
			socket = new Socket(host, port);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			
			json = gson.toJson(request);
			out.println(json);
			out.flush();

			json = in.readLine();
			response =  gson.fromJson(json, Package.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

}

