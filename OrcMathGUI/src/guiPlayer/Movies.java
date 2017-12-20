package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Movies extends AnimatedComponent{
	private String name;
	private String genre;
	public Movies(String name, String genre) {
		
		super(40, 40, 48, 51);	
		this.name = name;
		this.genre = genre;
		/*addSequence("resources/sprite.png", 150, 15, 16,48,51,9 );	
		Thread animation = new Thread(this);
		animation.start();*/
		update();
		
		
	}
	public String toString()
	{
		return name+" , "+ genre; 
	}
	

	@Override
	public void update(Graphics2D g) {
		//g.setColor(Color.GREEN);
		super.update(g);

	}

}
