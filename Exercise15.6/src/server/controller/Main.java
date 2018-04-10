package server.controller;

import server.domain.mediator.TaskListModel;
import server.domain.mediator.TaskListModelManager;
import server.view.TaskListConsole;
import server.view.TaskListView;

public class Main {
	
	public static void main(String[] args) {
		TaskListModel model = new TaskListModelManager();
		TaskListView view = new TaskListConsole();
		TaskListController controller = new TaskListController(model, view);
		view.startView(controller);
	}
	
	
}
