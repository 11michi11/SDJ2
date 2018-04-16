package Exercise1;

public class Counter {

	private long value;
	private long max;
	private long min;

	public Counter(long max, long min) {
		value = 0;
		this.max = max;
		this.min = min;
	}

	public synchronized void increment() {
		while (value >= max) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		value++;
		notifyAll();
		System.out.println(value + ": " + Thread.currentThread().getName());

	}

	public synchronized void decrement() {
		while (value <= min) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		value--;
		notifyAll();
		System.out.println(value + ": " + Thread.currentThread().getName());
	}

	public synchronized long getValue() {
		return value;
	}

}
