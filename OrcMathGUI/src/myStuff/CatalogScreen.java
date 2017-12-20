package myStuff;

import java.util.List;

import guiPlayer.Book;
import guiPlayer.CatalogMaker;
import guiPlayer.Movies;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField descriptionField;
	private Button addButton;
	private CatalogMaker catalog;
	private TextArea textArea;
	public CatalogScreen(int width, int height) {
		super(width, height);
		
	}


	public void initAllObjects(List<Visible> viewObjects) {
		catalog  = new CatalogMaker();
		
		descriptionField = new TextField(40, 40, 200, 30, "Text goes here","Movie title" );
		viewObjects.add(descriptionField);
		addButton = new Button(100,100,80,80,"add",new Action() {
		
			public void act() {
	//			descriptionField.setText("You did it");
				addButtonClicked();
				
			}
		});
		
		viewObjects.add(addButton);
		textArea = new TextArea(200, 200, 300, 300, "");
		viewObjects.add(textArea);
	}

	
	
	
	
	protected void addButtonClicked() 
	{
		Movies b = new Movies(descriptionField.getText(),"default author");
		String s = textArea.getText()+ b+ "\n";
		textArea.setText(s);
		catalog.addMovies(b);
	}



}
