
public class ThreadMain {

	public static void main(String[] args) {
		
		ArrayQueue<String> arrayQueue = new ArrayQueue<String>();
		Runnable r = new Adding(arrayQueue, "1", 2000);
		Thread t = new Thread(r);
		t.start();

	}

}
