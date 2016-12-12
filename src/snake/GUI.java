/**
 * 
 */
package snake;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jamie
 *
 */
public class GUI {
	public JFrame window;
	public JButton red, yellow, blue, green;
	public JPanel p1, p2, p3;
	public String color;
	private LogicController logic;
	private HandleInput inputHandler;
	private HighScores highScore;

	public GUI() {
		showFrame();
		makeFrame();
	}

	private void makeFrame() {
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();

		window.setLayout(new BorderLayout());
		p2.setLayout(new FlowLayout());
		p3.setLayout(new FlowLayout());

		p1.setLayout(new GridLayout(2, 2));
		window.add(p2, BorderLayout.NORTH); // Top score bar
		window.add(p1, BorderLayout.CENTER); // Middle Main Game
		window.add(p3, BorderLayout.SOUTH); // Bottom System Status
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
		p1.add(red);
		p1.add(yellow);
		p1.add(blue);
		p1.add(green);
		highScore = new HighScores();
		logic = new LogicController(3, red, yellow, blue, green);
		inputHandler = new HandleInput(logic, highScore);
		// add ActionListners
		red.addActionListener(new Listener(inputHandler, red, logic));
		blue.addActionListener(new Listener(inputHandler, blue, logic));
		yellow.addActionListener(new Listener(inputHandler, yellow, logic));
		green.addActionListener(new Listener(inputHandler, green, logic));
	}

	private void showFrame() {
		window = new JFrame("ButtonGame");
		window.setLocation(200, 90);
		window.setSize(800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}

}
