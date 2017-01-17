package ca.dantav.main;

import java.awt.Color;
import java.awt.Dimension;

public final class Constants {
	
	/**
	 * Makes sure no one init the class
	 */
	private Constants() {
		throw new AssertionError();
	}
	
	/**
	 * The frame dimensions
	 */
	public static final Dimension FRAME_DIMENSION = new Dimension(600, 400);
	
	/**
	 * 
	 * The title of the game
	 */
	public static final String GAME_TITLE = "Dan's Game";
	
	/**
	 * The colour of the main screen background
	 */
	public static final Color MAIN_BACKGROUND_COLOR = Color.YELLOW;
	
	/**
	 * The colour of the game screen background
	 */
	public static final Color GAME_BACKGROUND_COLOR = Color.BLUE;
	
	/**
	 * The speed multiplier of how fast race will go 
	 */
	public static final int SPEED_MULTIPLIER = 10;

}
