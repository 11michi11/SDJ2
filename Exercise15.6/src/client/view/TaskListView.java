package client.view;

import java.util.Observer;

import client.controller.ClientTaskListConstroller;

public interface TaskListView extends Observer{
	
	String get(String text);
	void show(String text);
	void startView(ClientTaskListConstroller controller);

}
