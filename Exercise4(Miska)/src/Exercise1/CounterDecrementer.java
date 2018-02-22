package Exercise1;

public class CounterDecrementer implements Runnable{
	
	private int updates;
	private Counter counter;

	public CounterDecrementer(int updates, Counter counter) {
		this.updates = updates;
		this.counter = counter;
	}

	@Override
	public void run() {
		for(int i=0; i < updates;i++)
			counter.decrement();
		System.out.println("value is: " + counter.getValue());
		
	}
	
	

}
