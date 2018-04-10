package domain.mediator;


import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domain.model.Task;


public class TaskListClient extends UnicastRemoteObject implements TaskListModel, Serializable{

	private static final long serialVersionUID = 1L;
	private RemoteTaskList server;

	public TaskListClient(String host) throws RemoteException {
		super();
		try {
			server = (RemoteTaskList) Naming.lookup("rmi://localhost:1099/server");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void add(Task task) throws RemoteException {	
			server.add(task);
	}

	@Override
	public Task get() throws RemoteException{
		return server.get();
	
	}

	@Override
	public int size() throws RemoteException{
		return server.size();
	}
	
	

}

