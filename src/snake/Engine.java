/**
 * 
 */
package snake;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jamie
 *
 */
public class Engine {
	public JFrame window;
	public JButton red, yellow, blue, green;
	public JPanel p1;
	public String color;
	private LogicController logic;

	public Engine() {
		showFrame();
		makeFrame();
		runOrder();
	}

	private void runOrder() {
		Iterator<JButton> order = logic.getOrder();
		while (order.hasNext()) {
			JButton button = order.next();
			changeRed(500, button);
		}
	}

	private void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException ie) {
			// doNothing
		}
	}

	private void changeRed(int time, JButton button) {
		pause(time);
		Color colour = button.getBackground();
		button.setBackground(Color.orange);
		pause(300);
		button.setBackground(colour);
	}

	private void makeFrame() {
		p1 = new JPanel();
		p1.setLayout(new GridLayout(2, 2));
		window.add(p1);

		red = new JButton();
		yellow = new JButton();
		blue = new JButton();
		green = new JButton();

		red.setBackground(Color.red);
		yellow.setBackground(Color.yellow);
		blue.setBackground(Color.blue);
		green.setBackground(Color.green);
		logic = new LogicController(4, red, yellow, blue, green);

		p1.add(red);
		p1.add(yellow);
		p1.add(blue);
		p1.add(green);
	}

	private void showFrame() {
		window = new JFrame("ButtonGame");
		window.setLocation(200, 90);
		window.setSize(800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

	public static void main(String[] args) {
		new Engine();
	}

}
