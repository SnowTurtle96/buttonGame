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
	public JPanel p1, p2, p3;
	private JLabel highscoreLabel, livesLabel;
	public String color;
	private LogicController logic;
	private HandleInput inputHandler;
	private HighScores highScoreHandler;
	private JLabel scoreLabel;
	private JButton reset;
	private JButton exit;
	private JButton resetHighScore;

	public GUI() {
		showFrame();
		makeFrame();
	}

	private void makeFrame() {
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();

		window.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout());
		p3.setLayout(new FlowLayout());

		p1.setLayout(new GridLayout(2, 2));
		window.add(p2, BorderLayout.NORTH); // Top score bar
		window.add(p1, BorderLayout.CENTER); // Middle Main Game
		window.add(p3, BorderLayout.SOUTH); // Bottom System Status
		red = new JButton();
		yellow = new JButton();
		blue = new JButton();
		green = new JButton();
		reset = new JButton("Reset");
		exit = new JButton("Exit");
		resetHighScore = new JButton("Reset High Score");
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
		scoreLabel.setText("Score: 0");
		p2.add(highscoreLabel, BorderLayout.WEST);
		p2.add(livesLabel, BorderLayout.EAST);
		p2.add(scoreLabel, BorderLayout.NORTH);

		resetHighScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				highScoreHandler.resetHighScore();
				highscoreLabel.setText("HighScore: 0");
				highscoreLabel.repaint();
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		p3.add(resetHighScore);

		highScoreHandler = new HighScores();
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
		window.setLocation(200, 90);
		window.setSize(800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}

}
