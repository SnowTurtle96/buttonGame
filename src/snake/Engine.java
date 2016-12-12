/**
 * 
 */
package snake;

import java.awt.Color;
import java.awt.GridLayout;

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
	public static Engine engine;
	public JPanel p1;
	public String color;
	private int z;
	private LogicController logic;

	public Engine() {
		showFrame();
		makeFrame();
		runOrder();
	}

	public void runOrder() {
		changeRed(600);
	}

	private void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException ie) {
			// doNothing           
		}
	}

	private void changeRed(int time) {
		pause(time);
		red.setBackground(Color.orange);
		pause(300);
		red.setBackground(Color.red);
	}

	public void makeFrame() {
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
		list();
	}

	public void showFrame() {
		window = new JFrame("ButtonGame");
		window.setLocation(200, 90);
		window.setSize(800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

	public static void main(String[] args) {
		new Engine();
	}

	public void displayPattern() {
		red.setBackground(Color.black);
	}

	public int list() {
		return z;
	}
}
