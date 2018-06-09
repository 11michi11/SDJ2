
public class QueueList<T> implements QueueADT<T> {

	private ListADT<T> list;

	public QueueListBased() {
		list = new ArrayList<T>();
	}

	@Override
	public void enqueue(T element) {
		list.add(element);
	}

	@Override
	public T dequeue(int index) {
		return list.remove(index);
	}

	@Override
	public int indexOf(T element) {
		return list.indexOf(element);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return list.isFull();
	}

	@Override
	public int size() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}
}
