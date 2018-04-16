
public class Test {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new BlockingQueue<String>(20);
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				queue.put("dupa1");
				queue.put("dupa2");
				queue.put("dupa3");
			int q = queue.size();
			System.out.println(q);
			}
		});
		t.start();

}

}
