
public class ThreadSafeBoundedQueue<T> implements QueueADT<T>{
	
	private BoundedArrayQueue<T> queue;
	public ThreadSafeBoundedQueue(int capacity) {
		queue = new BoundedArrayQueue<T>(capacity);
	}

	@Override
	public synchronized void enqueue(T element) {
		queue.enqueue(element);
		
	}
	@Override
	public synchronized T dequeue() {
		return queue.dequeue();
	}

	@Override
	public synchronized int indexOf(T element) {
		return queue.indexOf(element);
	}

	@Override
	public synchronized boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public synchronized boolean isFull() {
		return queue.isFull();
	}

	@Override
	public synchronized int size() {
		return queue.size();
	}

	@Override
	public synchronized T first() {
		return queue.first();
	}
	
	public synchronized String toString() {
		return queue.toString();

	}

	
	
	
}
