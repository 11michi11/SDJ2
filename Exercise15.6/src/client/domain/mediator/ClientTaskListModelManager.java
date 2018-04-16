package client.domain.mediator;

import java.util.Observer;

import client.domain.model.Task;

public class ClientTaskListModelManager implements TaskListModel{
	
	private ConnectionManager server;
	
	public ClientTaskListModelManager() {
		server = new ConnectionManager("localhost", 6789);
	}

	@Override
	public synchronized void add(Task task) {
		server.add(task);
	}

	@Override
	public synchronized Task get() {
		return server.get();
	}

	@Override
	public synchronized int size() {
		return server.size();
	}

	@Override
	public void addObserver(Observer o) {
		server.addObserver(o);
	}

	@Override
	public void deleteObserver(Observer o) {
		server.deleteObserver(o);
	}

}
