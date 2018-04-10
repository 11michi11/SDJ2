package view;

import controller.ClientTaskListConstroller;

public interface TaskListView {
	
	String get(String text);
	void show(String text);
	void startView(ClientTaskListConstroller controller);

}
