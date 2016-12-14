package snake;

import java.awt.Color;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;

public class Audio {

	public Audio() {
	}

	public static void playRed() {

		try {

			File filename = new File("ToneA.wav");

			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(filename));
			clip.start();
		} catch (Exception exc) {
			exc.printStackTrace(System.out);
		}
	}

	public static void playYellow() {

		try {

			File filename = new File("ToneB.wav");

			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(filename));
			clip.start();
		} catch (Exception exc) {
			exc.printStackTrace(System.out);
		}
	}

	public static void playGreen() {

		try {

			File filename = new File("ToneC.wav");

			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(filename));
			clip.start();
		} catch (Exception exc) {
			exc.printStackTrace(System.out);
		}
	}

	public static void playBlue() {

		try {

			File filename = new File("ToneD.wav");

			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(filename));
			clip.start();
		} catch (Exception exc) {
			exc.printStackTrace(System.out);
		}
	}

	public static void playAll(JButton button) {
		if (button.getBackground() == Color.red) {
			playRed();
		}
		if (button.getBackground() == Color.green) {
			playGreen();
		}
		if (button.getBackground() == Color.yellow) {
			playYellow();
		}
		if (button.getBackground() == Color.blue)
			playBlue();
	}
}
