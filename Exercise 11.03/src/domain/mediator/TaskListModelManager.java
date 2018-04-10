package domain.mediator;

import java.rmi.RemoteException;

import domain.model.Task;
import domain.model.TaskList;


public class TaskListModelManager implements TaskListModel{
	
	private TaskList list;
	private TaskListServer server;
	
	public TaskListModelManager() {
		list = new TaskList();
		try {
			server = new TaskListServer(this);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
