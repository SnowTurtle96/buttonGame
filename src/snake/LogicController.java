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
	final JButton red;
	final JButton yellow;
	final JButton blue;
	final JButton green;

	private int difficulty;

	// given difficulty and all the buttons
	LogicController(int difficulty, JButton red, JButton yellow, JButton blue, JButton green) {
		this.difficulty = difficulty;
		this.red = red;
		this.yellow = yellow;
		this.blue = blue;
		this.green = green;
		setEnabledButtons(false);
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
		runOrder();
	}

	public void increaseDifficulty(int increase) {
		int i = 0;
		int n = 0;
		while (i < increase) {
			Random rand = new Random();
			n = rand.nextInt(4);
			System.out.println(n);
			switch (n) {
			case 0:
				System.out.println("adding red");
				Colors.changeColor(300, red);
				order.add(red);
				break;
			case 1:
				System.out.println("adding blue");
				Colors.changeColor(300, blue);
				order.add(blue);
				break;
			case 2:
				System.out.println("adding yellow");
				Colors.changeColor(300, yellow);
				order.add(yellow);
				break;
			case 3:
				System.out.println("adding green");
				Colors.changeColor(300, green);
				order.add(green);
			}
			i++;
		}

	}

	// true for turning buttons on
	public void setEnabledButtons(boolean on) {
		red.setEnabled(on);
		blue.setEnabled(on);
		yellow.setEnabled(on);
		green.setEnabled(on);
	}

	public void runOrder() {
		Colors.pause(500);
		Iterator<JButton> iterator = order.iterator();
		setEnabledButtons(true);
		JButton button;
		while (iterator.hasNext()) {
			button = iterator.next();
			System.out.println(button.getName());
			Colors.changeColor(300, button);
		}
		setEnabledButtons(true);
	}

	public Iterator<JButton> getOrder() {
		return order.iterator();
	}

}
