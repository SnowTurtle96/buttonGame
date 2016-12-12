package snake;

import java.util.ArrayList;
import java.util.Random;

public class LogicController {
	private ArrayList<Integer> order;

	private int difficulty;

	LogicController(int difficulty) {
		this.difficulty = difficulty;
		setUpOrder();
	}

	private void setUpOrder() {
		int i = 0;
		int n = 0;
		while (difficulty < i) {
			Random rand = new Random();
			n = rand.nextInt(4) + 1;

			System.out.println(n);
			i++;

			order.add(n);
		}
	}

	public int getNextButton() {
		return 0;
	}
}
