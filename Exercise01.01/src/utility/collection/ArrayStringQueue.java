package utility.collection;

public class ArrayStringQueue implements StringQueueADT{
	
	private static final int DEAFAUL_CAPACITY = 100;
	private String[] queue;
	private int count;
	private int front;
	
	public ArrayStringQueue(int initialCapacity) {
		queue = new String[initialCapacity];
		count = 0;
		front = 0;
	}
	public ArrayStringQueue() {
		queue = new String[DEAFAUL_CAPACITY];
		count = 0;
		front = 0;
	}

	@Override
	public void enqueue(String element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
