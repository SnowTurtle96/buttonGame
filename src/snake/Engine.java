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
	private Colors colorClass;

	public Engine() {
		showFrame();
		makeFrame();
		runOrder();
	}

	private void runOrder() {
		Iterator<JButton> order = logic.getOrder();
		while (order.hasNext()) {
			JButton button = order.next();
			colorClass.changeColor(500, button);
		}
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
		waitFor = new WaitFor(logic);

		colorClass = new Colors();

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
