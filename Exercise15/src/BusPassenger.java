import java.rmi.RemoteException;

import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;

public class BusPassenger implements RemoteObserver<String>{
	private String name;
	private Bus bus;
	private boolean newPassenger;

	public BusPassenger(String name) {
		this.name = name;
		this.bus = null;
		this.newPassenger = false;
	}

	public String getName() {
		return name;
	}

	public boolean isNewPassenger() {
		return newPassenger;
	}

	public Bus getBus() {
		return bus;
	}

	public void getIn() {
		if (this.bus != null)
			getOut();
		this.bus = Bus.getInstance();
		newPassenger = true;
		try {
			bus.passengerGettingIn(this);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getOut() {
		newPassenger = false;
		try {
			bus.passengerGettingOut(this);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bus = null;
	}

	public String toString() {
		return name;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof BusPassenger))
			return false;
		BusPassenger p = (BusPassenger) obj;
		return name.equals(p.name) && ((bus == null & p.bus == null) || bus.equals(p.bus))
				&& newPassenger == p.newPassenger;
	}
	
	@Override
	public void update(RemoteSubject<String> subject, String updateMsg) throws RemoteException {
		String reply = "";
		String message = updateMsg;
		String[] split = message.split(":");
		if(split[1].equals(name))
			return;
		if (split.length != 2) {
			reply = "I don't understand";
		} else {
			if (split[0].equalsIgnoreCase("Enter"))
				reply = "Hello ";
			else
				reply = "Bye Bye ";
			reply += split[1];
		}
		System.out.println(name + "> " + reply);
	}

}