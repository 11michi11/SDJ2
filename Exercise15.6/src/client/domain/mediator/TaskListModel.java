package client.domain.mediator;

import java.util.Observer;

import client.domain.model.Task;

public interface TaskListModel{
	
	void add(Task task);
	Task get();
	int size();
	void addObserver(Observer o);
	void deleteObserver(Observer o);
	

}
