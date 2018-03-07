package exe4;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class TaskServer extends UnicastRemoteObject implements RemoteTaskList{

	private static final long serialVersionUID = 1L;
	private TaskList tasks;
	private ArrayList<ReplyTo> toInform;
	
	protected TaskServer() throws RemoteException {
		super();
		tasks = new TaskList();
		toInform = new ArrayList<ReplyTo>();
	}

	@Override
	public void add(String task, ReplyTo who) throws RemoteException {
		tasks.addTask(task);
		toInform.add(who);
		replyAll(task);
	}

	@Override
	public String remove() throws RemoteException {
		return tasks.remove();
	}

	@Override
	public int size() throws RemoteException {
		return tasks.size();
	}
	
	private void replyAll(String task) {
		for(ReplyTo e : toInform)
			try {
				e.inform(task);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
