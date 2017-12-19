package myStuff;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField descriptionField;
	private Button addButton;
	public CatalogScreen(int width, int height) {
		super(width, height);
		
	}


	public void initAllObjects(List<Visible> viewObjects) {
		descriptionField = new TextField(40, 40, 200, 30, "Text goes here","description" );
		viewObjects.add(descriptionField);
		addButton = new Button(100,100,20,20,"add",new Action() {
			
			@Override
			public void act() {
				descriptionField.setText("You did it");
				
			}
		});
		
		viewObjects.add(addButton);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
