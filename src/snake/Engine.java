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
	private WaitFor waitFor;

	public Engine() {
		showFrame();
		makeFrame();
		logic.runOrder();
	}

	private void runOrder() {
		Iterator<JButton> order = logic.getOrder();
		while (order.hasNext()) {
			JButton button = order.next();
			Colors.changeColor(500, button);
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
		red.setName("Red");
		yellow.setBackground(Color.yellow);
		yellow.setName("Yellow");
		blue.setBackground(Color.blue);
		blue.setName("Blue");
		green.setBackground(Color.green);
		green.setName("Green");
		logic = new LogicController(1, red, yellow, blue, green);
		waitFor = new WaitFor(logic);
		red.addActionListener(new Listener(waitFor, red));
		blue.addActionListener(new Listener(waitFor, blue));
		yellow.addActionListener(new Listener(waitFor, yellow));
		green.addActionListener(new Listener(waitFor, green));

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
