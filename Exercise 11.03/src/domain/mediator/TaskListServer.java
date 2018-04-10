package domain.mediator;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

import domain.model.Task;
import domain.model.TaskList;

public class TaskListServer extends UnicastRemoteObject implements RemoteTaskList {

	private TaskListModel taskList;
	private static final long serialVersionUID = 1L;

	public TaskListServer(TaskListModel taskList) throws RemoteException {
		super();
		this.taskList = taskList;
	}
	
	private void startRegistry() {
		try {
			Registry reg = LocateRegistry.createRegistry(1099);
			RemoteServer rmiServer = new TaskListServer(taskList);
			Naming.rebind("server", rmiServer);
			System.out.println("Server is up");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void add(Task task) throws RemoteException {
		taskList.add(task);
		
	}
	
	@Override
	public Task get() throws RemoteException {
		return taskList.get();
	}

	@Override
	public int size() throws RemoteException {
		return taskList.size();
	}

}
