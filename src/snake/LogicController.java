package snake;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.Semaphore;

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

	private int noOfButtons;
	private final int startNoOfButtons;
	private int speed; // Variable at which we increase the gaps between flashes
	private Semaphore running = new Semaphore(1);
	private GUIDlgFail failScreen;

	// given difficulty and all the buttons
	LogicController(int score, JButton red, JButton yellow, JButton blue, JButton green) {
		this.startNoOfButtons = score;
		this.noOfButtons = score;
		this.red = red;
		this.yellow = yellow;
		this.blue = blue;
		this.green = green;
		setEnabledButtons(false);
		setUpOrder();
		failScreen = new GUIDlgFail();

	}

	void reset() {
		noOfButtons = 3;
		setUpOrder();
	}

	// sets up a new sequence
	void setUpOrder() {
		order = new ArrayList<JButton>();
		int i = 0;
		int n = 0;
		while (i < noOfButtons) {
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
		noOfButtons += notoincreaseby;
		int i = 0;
		int n = 0;
		while (i < notoincreaseby) {
			n = rand.nextInt(4);
			System.out.println(n);
			switch (n) {
			case 0:
				System.out.println("adding red");
				order.add(red);
				// Audio.playRed();
				break;
			case 1:
				System.out.println("adding blue");
				order.add(blue);
				// Audio.playBlue();
				break;
			case 2:
				System.out.println("adding yellow");
				order.add(yellow);
				// Audio.playYellow();
				break;
			case 3:
				System.out.println("adding green");
				order.add(green);
				// Audio.playGreen();
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

	// goes through the whole sequence and shows it to the player
	public void runOrder() {
		speed();
		Colors.pause(300);
		try {
			running.acquire();
			Colors.pause(speed);
			Iterator<JButton> iterator = order.iterator();
			JButton button;
			while (iterator.hasNext()) {
				button = iterator.next();
				System.out.println(button.getName());
				Colors.changeColor(speed, button);
				Audio.playAll(button);
				System.out.println(speed);

			}
			setEnabledButtons(true);
			running.release();
		} catch (InterruptedException e) {
			Colors.changeColor(0, red);
			Colors.changeColor(0, yellow);
			Colors.changeColor(0, green);
			Colors.changeColor(0, blue);
		}
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
		failScreen.setVisible();
	}

	public int getScore() {
		return noOfButtons - startNoOfButtons;
	}

	public void speed() {
		if (noOfButtons < 4) {
			speed = 400;
		} else if (noOfButtons < 5) {
			speed = 375;
		} else if (noOfButtons < 6) {
			speed = 350;
		} else if (noOfButtons < 7) {
			speed = 325;
		} else if (noOfButtons < 8) {
			speed = 300;

		} else if (noOfButtons < 9) {
			speed = 275;

		} else if (noOfButtons < 10) {
			speed = 250;

		} else if (noOfButtons < 11) {
			speed = 225;
		}

		else {
			speed = 200;
		}
		System.out.println(speed);

	}
}
