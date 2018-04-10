

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;

public class TaskClient implements Serializable, RemoteObserver<String>{

	private static final long serialVersionUID = 1L;
	private RemoteTaskList server;
	
	public TaskClient() {
		try {
			server = (RemoteTaskList) Naming.lookup("rmi://localhost:1099/server");
			server.add("Test");
			server.addObserver(this);
			System.out.println(server.size());
			System.out.println(server.remove());
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TaskClient();
	}
	
	@Override
	public void update(RemoteSubject<String> subject, String updateMsg) throws RemoteException {
		System.out.println(updateMsg);
	}
	
}
