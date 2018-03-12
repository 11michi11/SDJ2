package exe3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

import exe2.RemoteMessageServer;

public class TaskServer extends UnicastRemoteObject implements RemoteTaskList{

	private static final long serialVersionUID = 1L;
	private TaskList tasks;
	
	protected TaskServer() throws RemoteException {
		super();
		tasks = new TaskList();
	}

	@Override
	public void add(String task) throws RemoteException {
		tasks.addTask(task);
	}

	@Override
	public String remove() throws RemoteException {
		return tasks.remove();
	}

	@Override
	public int size() throws RemoteException {
		return tasks.size();
	}
	
	
	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(1099);
			RemoteServer rmiServer = new TaskServer();
			Naming.rebind("server", rmiServer);
			System.out.println("Server is up");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	

}
