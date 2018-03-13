package cd.view;

import cd.controller.CDController;

public interface CDView {

	void start(CDController controller);

	void show(String value);

	String get(String what);
}
