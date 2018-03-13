package cd.controller;

import cd.domain.mediator.CDModel;
import cd.domain.mediator.CDModelManager;
import cd.view.CDGUI;
import cd.view.CDView;

public class Main {
	public static void main(String args[]) {
		CDModel model = new CDModelManager();
		CDView view = new CDGUI();
		CDController controller = new CDController(model, view);
		view.start(controller);
	}
}
