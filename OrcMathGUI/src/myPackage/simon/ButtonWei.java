package myPackage.simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonWei extends Button implements ButtonInterfaceDaniel {

	private Color color;
	
	public ButtonWei(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		// TODO Auto-generated constructor stub
	}

	public ButtonWei(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void setColor(Color blue) {
		this.setBackground(blue);
		color = blue;
	}

	@Override
	public void highlight() {
		int red = this.color.getRed() + 10;
		int green = this.color.getGreen() + 10;
		int blue = this.color.getBlue() + 10;
		this.setColor(new Color(red, green, blue));
	}

	@Override
	public void dim() {
		int red = this.color.getRed() - 10;
		int green = this.color.getGreen() - 10;
		int blue = this.color.getBlue() - 10;
		this.setColor(new Color(red, green, blue));
		this.setColor(getColor());
	}
	
	public Color getColor() {
		return this.color;
	}

	@Override
	public ButtonWei getButton() {
		return this;
	}

}
