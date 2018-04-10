package server.controller;

import server.domain.mediator.TaskListModel;
import server.domain.model.Task;
import server.view.TaskListView;

public class TaskListController {

	private TaskListModel model;
	private TaskListView view;

	public TaskListController(TaskListModel model, TaskListView view) {
		this.model = model;
		this.view = view;
	}

	public void execute(int choice) {

		switch (choice) {
		case 1:
			String taskDesc = view.get("Enter task description");
			long time = Long.parseLong(view.get("Enter task time"));
			model.add(new Task(taskDesc, time));
			break;
		case 2:
			view.show(model.get().toString());
			break;
		case 3:
			view.show(Integer.toString(model.size()));
			break;
		case 0:
			System.exit(1);
			break;
		}

	}
	

}
