package myStuff;

import java.util.List;

import guiPlayer.Book;
import guiPlayer.CatalogMaker;
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
		
		descriptionField = new TextField(40, 40, 200, 30, "Text goes here","description" );
		viewObjects.add(descriptionField);
		addButton = new Button(100,100,20,20,"add",new Action() {
		
			public void act() {
	//			descriptionField.setText("You did it");
				addButtonClicked();
				
			}
		});
		
		viewObjects.add(addButton);
		textArea = new TextArea(200, 200, 300, 300, "Text Area");
		viewObjects.add(textArea);
	}

	
	
	
	
	protected void addButtonClicked() 
	{
		Book b = new Book(descriptionField.getText(),"default author", 1000);
		String s = textArea.getText()+ b+ "\n";
		textArea.setText(s);
		catalog.addBook(b);
	}



}
