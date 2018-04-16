

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import utility.observer.AbstractRemoteSubject;

public class TaskServer extends	AbstractRemoteSubject<String> implements RemoteTaskList{

	private TaskList tasks;
	
	protected TaskServer() throws RemoteException {
		super();
		tasks = new TaskList();
		UnicastRemoteObject.exportObject(this, 0);
	}

	@Override
	public void add(String task) throws RemoteException {
		tasks.addTask(task);
		notifyObservers("Added: " + task);
	}

	@Override
	public String remove() throws RemoteException {
		String task = tasks.remove();
		notifyObservers("Removed: " + task);
		return task;
	}

	@Override
	public int size() throws RemoteException {
		return tasks.size();
	}
	
	
	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(1099);
			AbstractRemoteSubject<String> rmiServer = new TaskServer();
			Naming.rebind("server", rmiServer);
			System.out.println("Server is up");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
