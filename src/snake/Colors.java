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

	public static Color changeRedButton() {
		redAlternate = Color.decode("#7f0000");
		return redAlternate;
	}

	public static Color changeYellowButton() {
		yellowAlternate = Color.decode("#999900");
		return yellowAlternate;
	}

	public static Color changeBlueButton() {
		blueAlternate = Color.decode("#000099");
		return blueAlternate;
	}

	public static Color changeGreenButton() {
		greenAlternate = Color.decode("#00b300");
		return greenAlternate;
	}

	public static void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException ie) {
			// doNothing
		}
	}

	public static void changeColor(int time, JButton button) {
		pause(300);
		if (button.getBackground() == Color.red) {
			button.setBackground(changeRedButton());
			pause(time);
			button.setBackground(Color.RED);
		}

		if (button.getBackground() == Color.yellow) {
			button.setBackground(changeYellowButton());
			pause(time);
			button.setBackground(Color.yellow);
		}

		if (button.getBackground() == Color.green) {
			button.setBackground(changeGreenButton());
			pause(time);
			button.setBackground(Color.green);
		}

		if (button.getBackground() == Color.blue) {
			button.setBackground(changeBlueButton());
			pause(time);
			button.setBackground(Color.blue);
		}
	}

}