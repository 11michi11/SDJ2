package client.controller;

import client.domain.mediator.ClientTaskListModelManager;
import client.domain.mediator.TaskListModel;
import client.view.ClientTaskListConsole;
import client.view.TaskListView;

public class ClientMain {
	
	public static void main(String[] args) {
		TaskListModel model = new ClientTaskListModelManager();
		TaskListView view = new ClientTaskListConsole();
		ClientTaskListConstroller controller = new ClientTaskListConstroller(model, view);
		view.startView(controller);
	}
	
	
}
