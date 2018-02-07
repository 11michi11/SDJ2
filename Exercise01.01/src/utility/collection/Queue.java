package utility.collection;

public class Queue<T> {
	
	private Node first;

	public Queue(T firstValue) {
		first = new Node<T>(null ,first);
	}
	
	public Queue() {}
	
	
}
