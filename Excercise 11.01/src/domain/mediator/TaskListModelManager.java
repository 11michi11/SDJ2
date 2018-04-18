package domain.mediator;

import domain.model.Task;
import domain.model.TaskList;


public class TaskListModelManager implements TaskListModel{
	
	private TaskList list;
	private TaskListServer server;
	
	public TaskListModelManager() {
		list = new TaskList();
		server = new TaskListServer(this, 6789);
		Thread t = new Thread(server);
		t.start();
	}

	@Override
	public synchronized void add(Task task) {
		list.add(task);
	}

	@Override
	public synchronized Task get() {
		return list.getAndRemoveNextTask();
	}

	@Override
	public synchronized int size() {
		return list.size();
	}

}
