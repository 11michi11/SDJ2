package utility.collection;

public class DemoQueue {
	
	public static void main(String[] args) {
		BoundedArrayStringQueue queue = new BoundedArrayStringQueue(10);
		
		
		queue.enqueue("Mi�ka");
		queue.enqueue("Micha�");
		queue.enqueue("Jakub");
		queue.enqueue("Angel");
		queue.enqueue("Samuel");
		queue.enqueue("Jackson");
		
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.first());
		System.out.println(queue.indexOf("Micha�"));
		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		
		
		
	}

}
