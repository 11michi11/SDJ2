import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;
import utility.observer.RemoteSubjectDelegate;

public class Bus implements RemoteSubject<String>{
	private String info;
	private Set<BusPassenger> passengers;
	private static Bus instance; 
	private RemoteSubjectDelegate<String> delegate;

	private Bus() {
		passengers = new HashSet<BusPassenger>();
		this.info = "eXpress " + hashCode() % 100;
		instance = this;
		delegate = new RemoteSubjectDelegate<String>(this);
	}
	
	public static Bus getInstance() {
		if(instance == null)
			instance = new Bus();
		return instance;
	}
	
	public void passengerGettingIn(BusPassenger p) throws RemoteException {
		passengers.add(p);
		addObserver((RemoteObserver<String>) p);
		delegate.notifyObservers("Enter:" + p.getName());
	}

	public void passengerGettingOut(BusPassenger p) throws RemoteException {
		passengers.remove(p);
		deleteObserver((RemoteObserver<String>) p);
		delegate.notifyObservers("Leave:" + p.getName());
	}

	public String getInfo() {
		return info;
	}

	public String getPassengerList() {
		String s = "";
		Iterator<BusPassenger> it = passengers.iterator();
		while (it.hasNext()) {
			s += it.next().toString();
			s += "\n";
		}
		int index = s.lastIndexOf("\n");
		if (index > -1)
			s = s.substring(0, index);
		return s;
	}

	public String toString() {
		return getInfo() + ":\n" + getPassengerList();
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Bus))
			return false;
		Bus b = (Bus) obj;
		return info.equals(b.info);
	}

	@Override
	public void addObserver(RemoteObserver<String> o) throws RemoteException {
		delegate.addObserver(o);
	}

	@Override
	public void deleteObserver(RemoteObserver<String> o) throws RemoteException {
		delegate.deleteObserver(o);
	}
}
