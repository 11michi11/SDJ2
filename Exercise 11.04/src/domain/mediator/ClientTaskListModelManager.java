package domain.mediator;

import java.rmi.RemoteException;

import domain.model.Task;

public class ClientTaskListModelManager implements TaskListModel {

	private TaskListModel client;

	public ClientTaskListModelManager() {
		try {
			client = new TaskListClient("localhost");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public synchronized void add(Task task) throws RemoteException {
		client.add(task);

	}

	@Override
	public synchronized Task get() throws RemoteException {
		return client.get();
	}

	@Override
	public synchronized int size() throws RemoteException {
		return client.size();
	}

}
