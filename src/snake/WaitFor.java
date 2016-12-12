package snake;

import java.util.Iterator;

import javax.swing.JButton;

public class WaitFor {
	private int lives = 3;
	private Iterator<JButton> order;
	private JButton current;

	public void setUp(Iterator<JButton> order) {
		this.order = order;
	}

	public boolean checkIsWanted(JButton button) {
		if (button == current) {
			// move on to next button
			if (order.hasNext()) {
				current = order.next();
			} else {

			}
			return true;
		} else {
			// deal with being wrong
			lives--;
			return false;
		}
	}

}
