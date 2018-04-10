package domain.mediator;

import domain.model.Task;



public class ClientTaskListModelManager implements TaskListModel{
	
	private TaskListClient server;
	
	public ClientTaskListModelManager() {
		server = new TaskListClient("localhost", 6789);
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

}
