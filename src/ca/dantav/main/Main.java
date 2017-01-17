package ca.dantav.main;

import java.util.logging.Logger;

import javax.swing.JFrame;




public final class Main {

	/**
	 * The main logger for the game
	 */
	public static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	
	/**
	 * The main method
	 */
	public static void main(String[] args) {
		
		/** Creates a new JFrame */
		JFrame frame = new JFrame();
		
		/** Sets the visibility to true */
		frame.setVisible(true);
		
		/** Makes program close when exited */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/** Sets the title */
		frame.setTitle(Constants.GAME_TITLE);
		
		/** Sets the size of the JFrame */
		frame.setSize(Constants.FRAME_DIMENSION);
		
		/** Adds JPanel onto the frame */
		frame.add(Panel.PANEL);
		
		LOGGER.info("Game starting...");
	}
	
	
	
}
