package snake;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIDlgFail

{
	private JPanel p1;
	private JFrame window;
	private JLabel l1;

	public GUIDlgFail() {

		showFrame();
		makeFrame();

	}

	public void makeFrame() {
		p1 = new JPanel(new BorderLayout());
		l1 = new JLabel();
		p1.setBackground(Color.black);
		window.add(p1);
		l1.setText("Failed!");
		p1.add(l1, BorderLayout.CENTER);

	}

	public void showFrame() {
		window = new JFrame();
		window.setSize(400, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);

	}

	public void setVisible() {
		window.setVisible(true);

	}

}