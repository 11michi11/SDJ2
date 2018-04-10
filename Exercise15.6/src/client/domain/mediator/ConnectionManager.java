package client.domain.mediator;

import java.io.IOException;
import java.net.Socket;
import java.util.Observer;
import java.util.Scanner;

import client.domain.model.Task;

public class ConnectionManager implements TaskListModel{

	private Scanner input;
	private Socket socket;
	private Package response = null;
	private ConnectionSender sender;
	private ConnectionReceiver receiver;

	public ConnectionManager(String host, int port) {
		input = new Scanner(System.in);

		try {
			socket = new Socket(host, port);
			sender = new ConnectionSender(socket);
			receiver = new ConnectionReceiver(this, socket);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void add(Task task) {
		sender.add(task);
	}

	@Override
	public Task get() {
		sender.get();
		while(response == null)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		return response.getTask();
	}

	@Override
	public int size() {
		sender.size();
		while(response == null)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		return Integer.parseInt(response.getText());
	}

	public void receiveResponse(Package msg) {
		response = msg;
		notify();
	}

	@Override
	public void addObserver(Observer o) {
		receiver.addObserver(o);
	}
	
	@Override
	public void deleteObserver(Observer o) {
		receiver.deleteObserver(o);
	}
}
