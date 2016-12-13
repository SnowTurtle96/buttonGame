package snake;

import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;

public class HandleInput {
	private int lives = Constants.STARTING_LIVES;
	private Iterator<JButton> order;
	private JButton current;
	private final LogicController logic;
	private final HighScores highScore;
	private JLabel highScoreLabel;
	private JLabel livesLabel;
	private JLabel scoreLabel;

	HandleInput(LogicController logic, HighScores highScore, JLabel highScoreLabel, JLabel livesLabel, JLabel score) {
		this.highScoreLabel = highScoreLabel;
		this.livesLabel = livesLabel;
		this.highScore = highScore;
		this.scoreLabel = score;
		this.logic = logic;
		setUp();
	}

	public void setUp() {
		this.order = logic.getOrder();
		this.current = order.next();
	}

	void reset() {
		lives = Constants.STARTING_LIVES;
		repaintScoreLabel();
		repaintHighScoreLabel();
		repaintLivesLabel();
		setUp();
	}

	void repaintScoreLabel() {
		scoreLabel.setText("Score: " + logic.getScore());
		scoreLabel.repaint();
	}

	void repaintHighScoreLabel() {
		highScoreLabel.setText("HighScore: " + highScore.getHighScore());
		highScoreLabel.repaint();
	}

	void repaintLivesLabel() {
		livesLabel.setText("Lives: " + lives);
		livesLabel.repaint();
	}

	// This code is called after a button is pressed
	public boolean processButtonPress(JButton button) {
		// attempt to stop any other button being pressed until results of press
		// are sorted this isn't working great though
		System.out.println(button.getName() + "  " + current.getName());
		if (button == current) {
			// move on to next button
			if (order.hasNext()) {
				System.out.println("Waiting for next value");
				current = order.next();
				logic.setEnabledButtons(true);
			} else {
				System.out.println("Increasing Difficulty");
				logic.increaseDifficulty(1);
				repaintScoreLabel();
				// set's up this class with the new queue to be checked
				setUp();
				logic.setEnabledButtons(true);
			}
			return true;
		} else {
			// deal with being wrong
			lives--;
			repaintLivesLabel();
			if (lives == 0) {
				logic.turnBlack();
				highScore.setHighScore(logic.getScore());
				repaintHighScoreLabel();
				highScore.exportHighScore();
			} else {
				// have to start from the start again
				setUp();
				// run through the whole sequence
				logic.runOrder();
				logic.setEnabledButtons(true);
			}
			return false;
		}
	}

}
