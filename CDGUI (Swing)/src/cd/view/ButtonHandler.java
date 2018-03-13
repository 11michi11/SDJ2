package cd.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import cd.controller.CDController;
import cd.domain.model.CD;
import cd.domain.model.CDList;

public class ButtonHandler implements ActionListener {
	private CDController controller;
	private CDGUI gui;

	public ButtonHandler(CDController controlelr, CDGUI gui) {
		this.controller = controlelr;
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!(e.getSource() instanceof JButton))
			return;

		controller.execute(((JButton) e.getSource()).getText());
	}
}