package controller;

import domain.mediator.TaskListModel;
import domain.mediator.TaskListModelManager;
import view.TaskListConsole;
import view.TaskListView;

public class ServerMain {
	
	public static void main(String[] args) {
		TaskListModel model = new TaskListModelManager();
		TaskListView view = new TaskListConsole();
		TaskListController controller = new TaskListController(model, view);
		view.startView(controller);
	}
	
	
}
