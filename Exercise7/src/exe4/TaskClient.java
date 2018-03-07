package exe4;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import exe2.RemoteMessageServer;

public class TaskClient extends UnicastRemoteObject implements Serializable, ReplyTo {

	private static final long serialVersionUID = 1L;
	private RemoteTaskList server;

	public TaskClient(String task) throws RemoteException {
		super();
		try {
			server = (RemoteTaskList) Naming.lookup("rmi://localhost:1099/server");
			server.add(task, this);

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public TaskClient() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter task");
		try {
			TaskClient client1 = new TaskClient(in.nextLine());
			TaskClient client2 = new TaskClient(in.nextLine());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void inform(String task) throws RemoteException {
		System.out.println("New task added:" + task);
	}

}
