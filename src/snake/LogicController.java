package snake;

import java.awt.Color;
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
	final Random rand = new Random();

	private int score;

	// given difficulty and all the buttons
	LogicController(int score, JButton red, JButton yellow, JButton blue, JButton green) {
		this.score = score;
		this.red = red;
		this.yellow = yellow;
		this.blue = blue;
		this.green = green;
		setEnabledButtons(false);
		setUpOrder();
	}

	// sets up a new sequence
	void setUpOrder() {
		order = new ArrayList<JButton>();
		int i = 0;
		int n = 0;
		while (i < score) {
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

	// adds a certain number of new elements to the sequence and displays them
	public void increaseDifficulty(int notoincreaseby) {
		score += notoincreaseby;
		int i = 0;
		int n = 0;
		while (i < notoincreaseby) {
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

	// true for turning buttons on, false for not allowing pressing of buttons
	public void setEnabledButtons(boolean on) {
		red.setEnabled(on);
		blue.setEnabled(on);
		yellow.setEnabled(on);
		green.setEnabled(on);
	}

	// goes through the whole sequence and shows it to the playet
	public void runOrder() {
		Colors.pause(500);
		Iterator<JButton> iterator = order.iterator();
		JButton button;
		while (iterator.hasNext()) {
			button = iterator.next();
			System.out.println(button.getName());
			Colors.changeColor(300, button);
		}
		setEnabledButtons(true);
	}

	// returns the sequence
	public Iterator<JButton> getOrder() {
		return order.iterator();
	}

	// turns all buttons black and sets them to unclickable (for when run out of
	// lives)
	public void turnBlack() {
		setEnabledButtons(false);
		red.setBackground(Color.black);
		blue.setBackground(Color.BLACK);
		green.setBackground(Color.black);
		yellow.setBackground(Color.black);
	}

	public int getScore() {
		return score;
	}

}
