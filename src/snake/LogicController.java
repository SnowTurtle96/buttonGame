package snake;

import java.util.Iterator;
import java.util.Queue;
import java.util.Random;

import javax.swing.JButton;

public class LogicController {
	private Queue<JButton> order;
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
		int i = 0;
		int n = 0;
		while (difficulty < i) {
			Random rand = new Random();
			n = rand.nextInt(4);

			i++;
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
		}
	}

	public void increaseDifficulty(int increase) {
		difficulty += increase;
		setUpOrder();
	}

	public Iterator<JButton> getOrder() {
		return order.iterator();
	}

	public JButton getNextButton() throws Exception {

		throw new Exception("invalid number");
	}
}
