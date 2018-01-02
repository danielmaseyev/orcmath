package myPackage;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPlayer.CustomLabel;
import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class Stuff extends Button implements CustomLabel
{
	
	public Stuff(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
	}
	public void drawButton(Graphics2D g, boolean hover)
	{
		g.setColor( new Color(0,0,0));
	}
	public void updateString1(String string)
	{
		
	}
	public void updateString2(String string)
	{
		
	}
	public void setIconColor(Color color)
	{
		
	}
}



