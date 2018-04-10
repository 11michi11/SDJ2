package controller;

import domain.mediator.TaskListModel;
import domain.mediator.ClientTaskListModelManager;
import view.ClientTaskListConsole;
import view.TaskListView;

public class ClientMain {
	
	public static void main(String[] args) {
		TaskListModel model = new ClientTaskListModelManager();
		TaskListView view = new ClientTaskListConsole();
		ClientTaskListConstroller controller = new ClientTaskListConstroller(model, view);
		view.startView(controller);
	}
	
	
}
