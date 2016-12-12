package snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Listener implements ActionListener {

	private WaitFor waitFor;
	private JButton button;

	Listener(WaitFor waitFor, JButton button) {
		System.out.println(button.getName());
		this.button = button;
		this.waitFor = waitFor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread thread = new Thread() {
			public void run() {
				waitFor.processButtonPress(button);
			}
		};
		thread.start();

	}

}