package test;

import guiTeacher.GUIApplication;

public class Main extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7548071104587737267L;

	public Main(int width, int height) {
		super(width, height);
		setVisible(true);
	}
	
	public static void main(String[] args){
		Main catalog = new Main(800, 550);
		Thread runner = new Thread(catalog);
		runner.start();
	}

	@Override
	public void initScreen() {
		MainScreen screen = new MainScreen(getWidth(), getHeight());
		setScreen(screen);
	}

}
