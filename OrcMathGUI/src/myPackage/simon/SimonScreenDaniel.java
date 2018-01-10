package myPackage.simon;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenDaniel extends ClickableScreen implements Runnable{
	private TextLabel text;
	private ButtonInterfaceDaniel[] buttons;
	private ProgressInterfaceDaniel progress;
	private ArrayList<MoveInterfaceDaniel>  moving;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonScreenDaniel(int width, int height) {
		super(width, height);
		
	}
	public void run() {
		text.setText("");
	    nextRound();
	}
	private void nextRound() {
		acceptingInput= false;
		roundNumber++;
		moving.add(randomMove());
		setRound();
		setSequenceSize();
		changeText("Simon's turn");
		text.setText("");
		playSequence();
		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
		
		
		
	}
	
	private void playSequence() {
		 ButtonInterfaceDaniel b = null;
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		 for(int i = 0; i < moving.size();i++)
		 {
			 if(b != null)
			 {
				 b.dim();
				 b.getButton();
				 b.highlight();
				 int sleepTime;
				 sleepTime = roundNumber +2;
				 try {
						Thread.sleep(800);
						} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}		
	
			 }
		 }
		 
		 
		
	}
	private void changeText(String string) {
		try {
			Thread.sleep(2000);
			text.setText(string);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}		
	}
	public int setSequenceSize()
	{
		return moving.size();
	}

	public int setRound() {
		return roundNumber;
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
	    return new MoveWei(buttons[bIndex]);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceDaniel getProgress() {
		
		return new ProgressWei(20,20,400,50);
	}

	/**
	 * 
	 */
	private void addButtons() {
		int numberOfButtons = 5;	
		buttons = new ButtonInterfaceDaniel[numberOfButtons];
		Color button1 = new Color(0,0,0);
		Color button2 = new Color(45,54,120);
		Color button3 = new Color(68,100,32);
		Color button4 = new Color(32,32,32);
		Color button5 = new Color(200,200,200);
		Color button6 = new Color(144,23,43);
		Color buttonColors[] = {button1, button2, button3, button4, button5, button6};
		for(int i = 0; i < numberOfButtons;i++)
		{
			final ButtonInterfaceDaniel b = getAButton();
			buttons[i] = b;
			b.setColor(buttonColors[i]);
			   b.setVisible(true);
			   b.setX(350);
			   b.setY(i*50+250);
			 
			   b.setAction(new Action(){

				   public void act(){
					   if(acceptingInput)
					   {
						   Thread blink = new Thread(new Runnable(){

							   public void run(){
									b.highlight();
									try {
									Thread.sleep(800);
									} catch (InterruptedException e) {
									e.printStackTrace();
									}
									b.dim();
							   }

							   });
						   blink.start();
						   if(b == moving.get(sequenceIndex).getButton()) {
							   sequenceIndex++;
						   }
						   else {
							   progress.gameOver();			
						   }
						   if(sequenceIndex == moving.size()){ 
							    Thread nextRound = new Thread(SimonScreenDaniel.this); 
							    nextRound.start(); 
							    
							}
					   }
				   }

				   });
		
		
			 
			   
	}
	/**
	Placeholder until partner finishes implementation of ButtonInterface
	*/
	}
	private ButtonInterfaceDaniel getAButton() 
	{
		return new ButtonWei(250,250,320,35,"Button",null);
		
	}




	
	
	
	
	
}




