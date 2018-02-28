package taskList;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TaskList {
	private Queue<Task> tasks;

	public TaskList() {
		tasks = new ConcurrentLinkedQueue<Task>();
	}

	public synchronized void add(Task task) {
		tasks.add(task);
	}

	public synchronized Task getAndRemoveNextTask() {
		return tasks.poll();
	}

	public synchronized int size() {
		return tasks.size();
	}

	public String toString() {
		return "Tasks=" + tasks;
	}
}