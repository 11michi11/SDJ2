
public class Philosopher implements Runnable {

	private int id;
	private Fork leftFork;
	private Fork rightFork;

	public Philosopher(int id, Fork leftFork, Fork rightFork) {
		this.id = id;
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}

	public void doSomething(String action, int sec) {
		try {
			System.out.println(action + " (Phil" + id + ")");
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			doSomething("THINK", 5);
			if (leftFork.getId() < rightFork.getId()) {
				leftFork.getFork(id);
				rightFork.getFork(id);
			} else {
				rightFork.getFork(id);
				leftFork.getFork(id);
			}
			doSomething("EAT", 3);
			rightFork.putbackFork(id);
			leftFork.putbackFork(id);
		}

	}

}
