

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TaskList {

	private Queue<String> tasks;

	public TaskList() {
		tasks = new ConcurrentLinkedQueue<>();
	}

	public synchronized void addTask(String task) {
		tasks.add(task);
	}

	public synchronized String remove() {
		return tasks.remove();
	}

	public synchronized int size() {
		return tasks.size();
	}

}
