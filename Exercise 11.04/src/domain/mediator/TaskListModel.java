package domain.mediator;

import java.rmi.RemoteException;

import domain.model.Task;

public interface TaskListModel {
	
	void add(Task task) throws RemoteException;
	Task get() throws RemoteException;
	int size() throws RemoteException;
	

}
