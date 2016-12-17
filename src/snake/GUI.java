/**
 * 
 */
package snake;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Jamie
 *
 */
public class GUI {
	public JFrame window;
	public JButton red, yellow, blue, green;
	public JPanel p1, p2, p3, p4, p5;
	private JLabel highscoreLabel, livesLabel;
	public String color;
	private LogicController logic;
	private HandleInput inputHandler;
	private HighScores highScoreHandler;
	private JLabel scoreLabel;
	private JButton reset;
	private JButton exit;

	public GUI() {
		showFrame();
		makeFrame();
	}

	private void makeFrame() {
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel(); // I hate swing
		p5 = new JPanel(); // I hate swing

		window.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout()); // WORK
		p3.setLayout(new FlowLayout());
		p4.setLayout(new FlowLayout());
		p1.setLayout(new GridLayout(2, 2));
		window.add(p2, BorderLayout.NORTH); // Top score bar
		window.add(p1, BorderLayout.CENTER); // Middle Main Game
		window.add(p3, BorderLayout.SOUTH); // Bottom System Status
		p2.add(p4, BorderLayout.CENTER);
		red = new JButton();
		yellow = new JButton();
		blue = new JButton();
		green = new JButton();
		reset = new JButton("Reset");
		exit = new JButton("Exit");
		highscoreLabel = new JLabel();
		livesLabel = new JLabel();
		scoreLabel = new JLabel();

		initColour();
		red.setName("Red");
		yellow.setName("Yellow");
		blue.setName("Blue");
		green.setName("Green");
		p1.add(red);
		p1.add(yellow);
		p1.add(blue);
		p1.add(green);

		livesLabel.setText("Lives: " + Constants.STARTING_LIVES);
		scoreLabel.setText("Round: 0");
		p2.add(highscoreLabel, BorderLayout.EAST);
		p2.add(livesLabel, BorderLayout.WEST);
		p4.add(scoreLabel);
		highScoreHandler = new HighScores();

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				highScoreHandler.exportHighScore();
				System.exit(0);
			}
		});
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread thread = new Thread() {
					public void run() {
						initColour();
						logic.reset();
						inputHandler.reset();
					}
				};
				thread.start();
			}
		});
		p3.add(exit);
		p3.add(reset);

		highscoreLabel.setText("HighScore: " + highScoreHandler.getHighScore());
		logic = new LogicController(3, red, yellow, blue, green);
		inputHandler = new HandleInput(logic, highScoreHandler, highscoreLabel, livesLabel, scoreLabel);
		// add ActionListners
		red.addActionListener(new Listener(inputHandler, red, logic));
		blue.addActionListener(new Listener(inputHandler, blue, logic));
		yellow.addActionListener(new Listener(inputHandler, yellow, logic));
		green.addActionListener(new Listener(inputHandler, green, logic));
	}

	private void initColour() {
		red.setBackground(Color.red);
		yellow.setBackground(Color.yellow);
		blue.setBackground(Color.blue);
		green.setBackground(Color.green);

	}

	private void showFrame() {
		window = new JFrame("ButtonGame");
		window.setSize(800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new GUI();
	}

}
