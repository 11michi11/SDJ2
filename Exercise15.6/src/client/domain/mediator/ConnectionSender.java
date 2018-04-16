package client.domain.mediator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.google.gson.Gson;

import client.domain.model.Task;


public class ConnectionSender {

	private Socket socket;

	public ConnectionSender(Socket socket) {
		this.socket = socket;
	}

	public void add(Task task) {	
		Package pkg = new Package(Package.ADD);
		remoteCall(pkg);
		
	}

	public void get() {
		Package pkg = new Package(Package.GET);
		remoteCall(pkg);
	}

	public void size() {
		Package pkg = new Package(Package.SIZE);
		remoteCall(pkg);
	}
	
	private void remoteCall(Package request) {
		String json;
		Gson gson = new Gson();
		try {
			System.out.println("Trying to connect...");
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			
			json = gson.toJson(request);
			out.println(json);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

