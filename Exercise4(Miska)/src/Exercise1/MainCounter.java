package Exercise1;

public class MainCounter {

	public static void main(String[] args) {
		
		Counter counter = new Counter(50, 10);
		CounterIncrementer incrementerOne = new CounterIncrementer(200, counter);
		CounterIncrementer incrementerTwo = new CounterIncrementer(200, counter);
		CounterDecrementer decrementerOne = new CounterDecrementer(200, counter);
		CounterDecrementer decrementerTwo = new CounterDecrementer(200, counter);
		
		Thread incOne = new Thread(incrementerOne);
		incOne.start();
		
		Thread incTwo = new Thread(incrementerTwo);
		incTwo.start();
		
		Thread decOne = new Thread(decrementerOne);
		decOne.start();
		
		Thread decTwo = new Thread(decrementerTwo);
		decTwo.start();
	}

}
