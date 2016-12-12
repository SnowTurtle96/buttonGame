package snake;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HighScores {
	private int highScore;

	HighScores() {
		try {
			importHighScore();
		} catch (Exception e) {
			setHighScore(0);
		}
	}

	void setHighScore(int highScore) {
		if (this.highScore < highScore) {
			this.highScore = highScore;
		}
	}

	int getHighScore() {
		return highScore;
	}

	void importHighScore() throws Exception {
		Scanner sc = new Scanner(new File("HighScores.txt"));
		if (sc.hasNextInt()) {
			highScore = sc.nextInt();
		} else {
			throw new Exception("No highscore found");
		}
		sc.close();
	}

	void exportHighScore() {
		try {
			PrintWriter writer = new PrintWriter("HighScores.txt", "UTF-8");
			writer.println(highScore);
			writer.close();
		} catch (IOException e) {
			// do something
		}
	}

}