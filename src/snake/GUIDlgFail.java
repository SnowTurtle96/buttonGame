package snake;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIDlgFail

{
	private JPanel p1;
	private JFrame window;

	public GUIDlgFail() {

		makeFrame();
		showFrame();

	}

	public void makeFrame() {
		p1 = new JPanel();

	}

	public void showFrame() {
		window = new JFrame();
		window.setLocation(200, 90);
		window.setSize(400, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(false);
	}

	public void setVisible() {
		window.setVisible(true);

	}

}