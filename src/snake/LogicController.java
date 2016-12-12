package snake;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JButton;

/**
 * @author Rob
 *
 */
public class LogicController {
	private ArrayList<JButton> order;
	JButton red;
	JButton yellow;
	JButton blue;
	JButton green;

	private int difficulty;

	// given difficulty and all the buttons
	LogicController(int difficulty, JButton red, JButton yellow, JButton blue, JButton green) {
		this.difficulty = difficulty;
		this.red = red;
		this.yellow = yellow;
		this.blue = blue;
		this.green = green;
		setUpOrder();
	}

	private void setUpOrder() {
		order = new ArrayList<JButton>();
		int i = 0;
		int n = 0;
		while (i < difficulty) {
			Random rand = new Random();
			n = rand.nextInt(4);
			switch (n) {
			case 0:
				order.add(red);
				break;
			case 1:
				order.add(blue);
				break;
			case 2:
				order.add(yellow);
				break;
			case 3:
				order.add(green);
			}
			i++;
		}
	}

	public void increaseDifficulty(int increase) {
		int i = 0;
		int n = 0;
		while (i < increase) {
			Random rand = new Random();
			n = rand.nextInt(4);
			switch (n) {
			case 0:
				order.add(red);
				break;
			case 1:
				order.add(blue);
				break;
			case 2:
				order.add(yellow);
				break;
			case 3:
				order.add(green);
			}
			i++;
		}
	}

	public void runOrder() {
		Iterator<JButton> iterator = order.iterator();
		while (iterator.hasNext()) {
			JButton button = iterator.next();
			Colors.changeColor(500, button);
		}
	}

	public Iterator<JButton> getOrder() {
		return order.iterator();
	}

}
