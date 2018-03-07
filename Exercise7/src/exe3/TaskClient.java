package exe3;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TaskClient implements Serializable{

	private static final long serialVersionUID = 1L;
	private RemoteTaskList server;
	
	public TaskClient() {
		try {
			server = (RemoteTaskList) Naming.lookup("rmi://localhost:1099/server");
			server.add("Test");
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
	
}
