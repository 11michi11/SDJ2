
public class Fork {
	
	private int id;
	private boolean isTaken;
	
	public Fork(int id) {
		this.id = id;
		isTaken = false;
	}
	
	public int getId() {
		return id;
	}
	
	public synchronized void getFork(int id) {
		while(isTaken) {
			try {
				System.out.println("Phil" + id + " is waiting " + this.id);
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isTaken = true;
		System.out.println("Phil" + id + " took fork " + this.id);
		notify();
	}
	
	public synchronized void putbackFork(int id) {
		isTaken = false;
		System.out.println("Phil" + id + " put back fork " + this.id);
		notify();
	}

}
