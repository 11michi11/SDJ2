package domain.mediator;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domain.model.Task;

public interface RemoteTaskList extends Remote{
	
	void add(Task task) throws RemoteException;
	Task get() throws RemoteException;
	int size() throws RemoteException;

}

