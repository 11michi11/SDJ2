package exe4;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReplyTo extends Remote {

	public void inform(String task) throws RemoteException;
	
}
