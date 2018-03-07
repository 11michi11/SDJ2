package exe3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteTaskList extends Remote {

	public void add(String task) throws RemoteException;
	
	public String remove() throws RemoteException;
	
	public int size() throws RemoteException;
	
}
