package snake;

import java.util.Iterator;

import javax.swing.JButton;

public class HandleInput {
	private int lives = 5;
	private Iterator<JButton> order;
	private JButton current;
	private LogicController logic;

	HandleInput(LogicController logic) {
		this.logic = logic;
		this.order = logic.getOrder();
		this.current = order.next();
	}

	public void setUp() {
		this.order = logic.getOrder();
		this.current = order.next();
	}

	// This code is called after a button is pressed
	public boolean processButtonPress(JButton button) {
		// attempt to stop any other button being pressed until results of press
		// are sorted this isn't working great though
		System.out.println(button.getName() + "  " + current.getName());
		if (button == current) {
			// move on to next button
			if (order.hasNext()) {
				System.out.println("Waiting for next value");
				current = order.next();
				logic.setEnabledButtons(true);
			} else {
				System.out.println("Increasing Difficulty");
				logic.increaseDifficulty(1);
				// set's up this class with the new queue to be checked
				setUp();
				logic.setEnabledButtons(true);
			}
			return true;
		} else {
			// deal with being wrong
			lives--;
			if (lives == 0) {
				logic.turnBlack();
			} else {
				setUp();
				logic.runOrder();
				logic.setEnabledButtons(true);
			}
			return false;
		}
	}

}
