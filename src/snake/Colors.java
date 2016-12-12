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

	private Color redAlternate;
	private Color yellowAlternate;
	private Color greenAlternate;
	private Color blueAlternate;

	public Colors() {

	}

	public Color changeRedButton() {

		redAlternate = Color.decode("#7f0000");
		return redAlternate;

	}

	public Color changeYellowButton() {

		yellowAlternate = Color.decode("#999900");
		return yellowAlternate;
	}

	public Color changeBlueButton() {
		blueAlternate = Color.decode("#000099");
		return blueAlternate;
	}

	public Color changeGreenButton() {
		greenAlternate = Color.decode("#00b300");
		return greenAlternate;
	}

	public void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException ie) {
			// doNothing
		}
	}

	public void changeColor(int time, JButton button) {
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

		if (button.getBackground() == Color.blue) {
			button.setBackground(changeBlueButton());
		}
		pause(300);
		button.setBackground(colour);
	}

}