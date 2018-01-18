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

	private TextField[] fields; 
	private MainScreen screen;
	private Button button;
	private Button saveButton;
	private FileOpenButton openButton;
	private int score = 0;
	private boolean ready = false;
//	private TextArea books;
	
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

			@Override
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
