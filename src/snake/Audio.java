package snake;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {

	public Audio() {
	}

	public static void play() {
		try {

			File filename = new File("ToneA.wav");

			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(filename));
			clip.start();
		} catch (Exception exc) {
			exc.printStackTrace(System.out);
		}
	}
}
