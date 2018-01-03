package myPackage.simon;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenDaniel extends ClickableScreen implements Runnable{
	private TextLabel text;
	private ButtonInterfaceDaniel[] buttons;
	private ProgressInterfaceDaniel progress;
	private ArrayList<MoveInterfaceDaniel>  moving;
	private int roundNumber;
	private boolean Input;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonScreenDaniel(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceDaniel b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		text = new TextLabel(130,230,300,40,"Let's play Simon!");
		moving = new ArrayList<MoveInterfaceDaniel>();
		//add 2 moves to start
		lastSelectedButton = -1;
		moving.add(randomMove());
		moving.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(text);
	}
	private MoveInterfaceDaniel randomMove() 
	{
		 int bIndex = (int)(Math.random()*buttons.length);
		   while(bIndex == lastSelectedButton){
		       bIndex = (int)(Math.random()*buttons.length);
		   }
		   return getMove(bIndex);
	}
	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterfaceDaniel getMove(int bIndex) {
	    return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceDaniel getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 0;	
		buttons = new ButtonInterfaceDaniel[numberOfButtons];
		Color[];
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
