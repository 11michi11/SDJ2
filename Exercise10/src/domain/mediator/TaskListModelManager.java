package domain.mediator;

import domain.model.Task;
import domain.model.TaskList;


public class TaskListModelManager implements TaskListModel{
	
	private TaskList list;
	
	public TaskListModelManager() {
		list = new TaskList();
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
