package snake;

import java.util.Iterator;

import javax.swing.JButton;

public class WaitFor {
	private int lives = 3;
	private Iterator<JButton> order;
	private JButton current;
	private LogicController logic;

	WaitFor(LogicController logic) {
		this.logic = logic;
	}

	public void setUp(Iterator<JButton> order) {
		this.order = order;
	}

	public boolean processButtonPress(JButton button) {
		if (button == current) {
			// move on to next button
			if (order.hasNext()) {
				current = order.next();
			} else {
				logic.increaseDifficulty(1);
			}
			return true;
		} else {
			// deal with being wrong
			lives--;
			return false;
		}
	}

}
