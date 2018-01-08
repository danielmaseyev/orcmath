package myPackage.simon;

import java.awt.image.BufferedImage;

import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceDaniel extends Visible {

	void gameOver();

	void setRound(int x);
	void setSequenceSize(int x);

}
