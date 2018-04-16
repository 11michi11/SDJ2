package domain.mediator;

import domain.model.Task;

public interface TaskListModel {
	
	void add(Task task);
	Task get();
	int size();
	

}
