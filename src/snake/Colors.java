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

		redAlternate = Color.decode("0XFFFFFF");
		return redAlternate;

	}

	public Color changeYellowButton() {

		yellowAlternate = Color.decode("#FFFF00");
		return yellowAlternate;
	}

	public Color changeBlueButton() {
		greenAlternate = Color.decode("#00FF00");
		return greenAlternate;
	}

	public Color changeGreenButton() {
		blueAlternate = Color.decode("#0000FF");
		return blueAlternate;
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

		if (button.getBackground() == Color.red) {
			button.setBackground(changeBlueButton());
		}
		pause(300);
		button.setBackground(colour);
	}

}