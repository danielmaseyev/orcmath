package myPackage.simon;

import guiTeacher.GUIApplication;

public class SimonGameDaniel extends GUIApplication {

	public SimonGameDaniel(int width, int height) {
		super(width, height);
		setVisible(true);	
	}

	@Override
	public void initScreen() {
		SimonScreenDaniel screen = new SimonScreenDaniel(getWidth(), getHeight());
		setScreen(screen);
		new Thread(screen).run();
	}

	public static void main(String[] args) {
		SimonGameDaniel catalog = new SimonGameDaniel(800, 550);
		Thread runner = new Thread(catalog);
		runner.start();
	}

}
