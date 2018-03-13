package cd.controller;

import cd.domain.mediator.CDModel;
import cd.domain.model.CD;
import cd.domain.model.CDList;
import cd.view.CDView;

public class CDController {

	private CDModel model;
	private CDView view;
	
	public CDController(CDModel model, CDView view) {
		this.model = model;
		this.view = view;
	}
	
	public void execute(String what) {
		if (what.startsWith("List")) {
			view.show(model.getAll().toString());
		} else if (what.startsWith("Add")) {
			view.show("Add method not yet implemented");
		} else if (what.startsWith("Remove")) {
			String input = view.get("title");
			
			if (input == null)
				return;
			
			String msg = "";
			CD cd = model.removeCd(input);
			
			if (cd != null) 
				msg = "REMOVED: \n" + cd.toString();
			else 
				msg = "No CD with title: \"" + input + "\" found";
			
			view.show(msg);
		} else if (what.startsWith("Search")) {
			String input = view.get("title");
			if (input == null)
				return;
			String msg = "";
			CDList list = model.getCdsByTitle(input);
			for (int i = 0; i < list.getNumberOfCds(); i++) {
				msg += list.getCD(i) + "\n\n\n";
			}
			if (list.getNumberOfCds() == 0) {
				msg = "No CD with title: \"" + input + "\" found";
			}
			view.show(msg);
		} else if (what.startsWith("Quit")) {
			System.exit(0);
		}
	}
	
}
