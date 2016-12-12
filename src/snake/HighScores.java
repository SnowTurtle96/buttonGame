package snake;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HighScores {
	private int highScore = 0;

	void importHighScore() throws Exception {
		Scanner sc = new Scanner(new File("HighScores.txt"));
		if (sc.hasNextInt()) {
			highScore = sc.nextInt();
		} else {
			throw new Exception("No highscore found");
		}
		sc.close();
	}

	void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	int getHighScore() {
		return highScore;
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
