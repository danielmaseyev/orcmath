//package test;

//import guiTeacher.GUIApplication;
/*public class Main extends GUIApplication {
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
package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MainScreen extends FullFunctionScreen{
	private Button button;
	private int score = 0;
	private boolean ready = false;
	
	public MainScreen(int width, int height) {
		super(width, height);

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		TextLabel countdown = new TextLabel(100, 100, 150, 20, "");
		TextLabel timer = new TextLabel(140, 100, 170, 20, "");
		viewObjects.add(countdown);
		viewObjects.add(timer);
		Timer end = new Timer(timer, System.nanoTime(), 9, new Action() {

			public void act() {
				button.setEnabled(false);
				button.setText("Done");
			}
			
		});
		Timer wait = new Timer(countdown, System.nanoTime(), 4, new Action() {

			@Override
			public void act() {
				button.setEnabled(true);
				button.setText("Click me!");
				countdown.setText("Go!");
				Thread endThread = new Thread(end);
				endThread.start();
			}
			
		});
		Thread waitThread = new Thread(wait);
		TextLabel scoreText = new TextLabel(40, 100, 100, 20, "Score: " + score);
		viewObjects.add(scoreText);
		button = new Button(40, 300, 100, 30, "Ready", new Action() {
			@Override
			public void act() {
				if (ready) {
					scoreText.setText("Score: " + score);
					score += 1;
				} else {
					ready = true;
					button.setEnabled(false);
					waitThread.start();
				}
			}
		});
		viewObjects.add(button);
		
		
	}

			
		
	
	
}
package test;

import guiTeacher.components.Action;
import guiTeacher.components.Component;
import guiTeacher.components.TextLabel;

public class Timer implements Runnable {
	private long startTime;
	private int duration;
	private Action action;
	private TextLabel text;
	public Timer(TextLabel text, long startTime, int duration, Action action) {
		this.startTime = startTime;
		this.duration = duration;
		this.action = action;
		this.text = text;
	}

	@Override
	public void run() {
		while (System.nanoTime() - startTime <= duration * 1E9) {
			text.setText(String.valueOf(duration - (int)((System.nanoTime() - startTime) / 1E9)));
		}
		action.act();
	}

}
