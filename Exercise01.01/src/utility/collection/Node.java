package utility.collection;

public class Node<T> {

	private Node next;
	private T value;

	public Node(Node next, T value) {
		this.next = next;
		this.value = value;
	}

}
