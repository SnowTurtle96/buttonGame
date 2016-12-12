package snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Listener implements ActionListener {

	private WaitFor waitFor;
	private JButton button;
	private LogicController logic;

	Listener(WaitFor waitFor, JButton button, LogicController logic) {
		System.out.println(button.getName());
		this.button = button;
		this.waitFor = waitFor;
		this.logic = logic;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// stop things being pressed
		logic.setEnabledButtons(false);
		// make a new thread other wise the whole thing hangs
		Thread thread = new Thread() {
			public void run() {
				waitFor.processButtonPress(button);
			}
		};
		thread.start();
	}

}