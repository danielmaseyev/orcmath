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
	private Button addButton;
	private Button saveButton;
	private FileOpenButton openButton;
//	private TextArea books;
	
	public MainScreen(int width, int height) {
		super(width, height);

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {


		addButton = new Button(40, 300, 100, 30, "Add", new Action() {
			
			@Override
			public void act() {
				
			}
		});
	}

			
		
	
	
}
