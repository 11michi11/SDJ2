package Exercise2;

public class Burgerbar {
	
	private int numberOfBurgers;
	private int maxNumberOfBurgers;
	
	public Burgerbar(int maxNumberOfBurgers) {
		numberOfBurgers = 0;
		this.maxNumberOfBurgers = maxNumberOfBurgers;
	}
	
	public synchronized void makeBurger(String employee) {
		while(numberOfBurgers >= maxNumberOfBurgers)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println(employee + " is ready to make a burger (" +
				numberOfBurgers + " left)");
		numberOfBurgers++;
		notify();
	}
	
	public synchronized void eatBurger(String who) {
		while(numberOfBurgers <= 0)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println(who + " is ready to eat a burger (" +
				numberOfBurgers + " left)");
		numberOfBurgers--;
		notify();
	}
	
	public synchronized int getNumberOfBurgers() {
		return numberOfBurgers;
	}
}
