
public class QueueListBased<T> implements QueueADT<T> {

	private ListADT<T> list;

	public QueueListBased() {
		
	}

	@Override
	public synchronized void enqueue(T element) {
		list.add(element);

	}

	@Override
	public synchronized T dequeue(int index) {
		return list.remove(index);
	}

	@Override
	public synchronized int indexOf(T element) {
		return list.indexOf(element);
	}

	@Override
	public synchronized boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public synchronized boolean isFull() {
		return list.isFull();
	}

	@Override
	public synchronized int size() {
		return list.size();
	}
	
	public synchronized String toString() {
		return list.toString();
	}


}
