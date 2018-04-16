package server.domain.mediator;

import server.domain.model.Task;

public interface TaskListModel {
	
	void add(Task task);
	Task get();
	int size();
	

}
