package ca.dantav.main.game;

import java.awt.Color;
import java.awt.Rectangle;

public enum Team {

	RED(Color.RED, new Rectangle(-600, 0, 600, 100)),
	GREEN(Color.GREEN, new Rectangle(-600, 100, 600, 100)),
	PURPLE(Color.MAGENTA, new Rectangle(-600, 200, 600, 100)),
	ORANGE(Color.ORANGE, new Rectangle(-600, 300, 600, 100));
	
	private Color color;
	private Rectangle rectangle;
	
	Team(Color color, Rectangle rectangle) {
		this.color = color;
		this.rectangle = rectangle;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	
}
