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
		this.order = logic.getOrder();
		this.current = order.next();
	}

	public void setUp() {
		this.order = logic.getOrder();
		this.current = order.next();
	}

	public boolean processButtonPress(JButton button) {
		logic.setEnabledButtons(false);
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
				setUp();
			}
			return true;
		} else {
			// deal with being wrong
			lives--;
			logic.setEnabledButtons(true);
			return false;
		}
	}

}
