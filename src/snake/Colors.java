/**
 * 
 */
package snake;

import java.awt.Color;

import javax.swing.JButton;

/**
 * @author Jamie
 *
 */
public class Colors {

	private static Color redAlternate;
	private static Color yellowAlternate;
	private static Color greenAlternate;
	private static Color blueAlternate;

	public Colors() {

	}

	public static Color changeRedButton() {
		redAlternate = Color.BLACK;
		return redAlternate;
	}

	public static Color changeYellowButton() {

		yellowAlternate = Color.BLACK;
		return yellowAlternate;
	}

	public static Color changeBlueButton() {
		greenAlternate = Color.BLACK;
		return greenAlternate;
	}

	public static Color changeGreenButton() {
		blueAlternate = Color.BLACK;
		return blueAlternate;
	}

	public static void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException ie) {
			// doNothing
		}
	}

	public static void changeColor(int time, JButton button) {
		pause(time);
		Color colour = button.getBackground();

		if (button.getBackground() == Color.red) {
			button.setBackground(changeRedButton());
		}

		if (button.getBackground() == Color.yellow) {
			button.setBackground(changeYellowButton());
		}

		if (button.getBackground() == Color.green) {
			button.setBackground(changeGreenButton());
		}

		if (button.getBackground() == Color.red) {
			button.setBackground(changeBlueButton());
		}
		pause(300);
		button.setBackground(colour);
	}

}