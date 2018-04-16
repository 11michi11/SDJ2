package Exercise1;

public class CounterIncrementer implements Runnable{
	
	private int updates;
	private Counter counter;

	public CounterIncrementer(int updates, Counter counter) {
		this.updates = updates;
		this.counter = counter;
	}

	@Override
	public void run() {
		for(int i=0; i < updates;i++)
			counter.increment();
		System.out.println("value is: " + counter.getValue());
		
	}
	
	

}
