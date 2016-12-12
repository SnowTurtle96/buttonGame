/**
 * 
 */
package snake;

import java.awt.Color;

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

	public void changeRedButton() {

		redAlternate = Color.decode("0XFFFFFF");

	}

	public Color changeYellowButton() {

		yellowAlternate = Color.decode("#FFFF00");
		return yellowAlternate;
	}

	public void changeBlueButton() {
		greenAlternate = Color.decode("#00FF00");
	}

	public void changeGreenButton() {
		blueAlternate = Color.decode("#0000FF");
	}

}