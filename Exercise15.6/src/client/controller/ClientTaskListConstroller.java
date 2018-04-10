package client.controller;

import client.domain.mediator.TaskListModel;
import client.domain.model.Task;
import client.view.TaskListView;

public class ClientTaskListConstroller {

	private TaskListModel model;
	private TaskListView view;

	public ClientTaskListConstroller(TaskListModel model, TaskListView view) {
		this.model = model;
		this.view = view;
		model.addObserver(view);
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
