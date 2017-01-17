package ca.dantav.main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ca.dantav.main.game.Player;
import ca.dantav.main.gfx.Button;
import ca.dantav.main.gfx.GameGraphics;

@SuppressWarnings("serial")
public final class Panel extends JPanel {
	
	/**
	 * The singleton
	 */
	public static final Panel PANEL = new Panel();
	
	/**
	 * The player
	 */
	private Player player;
	
	/**
	 * Creates the panel
	 */
	public Panel() {
		
		/** Sets the visibility to true */
		this.setVisible(true);
		
		/** Sets expected size of the panel */
		this.setSize(Constants.FRAME_DIMENSION);
		
		/** Sets layout to null so buttons can be placed anywhere */
		this.setLayout(null);
		
		/** Sets background */
		this.setBackground(Constants.MAIN_BACKGROUND_COLOR);
		
		/** Sets the player */
		this.player = new Player();
		
		/** Calls the load method */
		load();
	}
	
	
	/**
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		/** Loops through all graphics */
		for(GameGraphics graphic : GameGraphics.values()) {
			
			/** If the current stage is equal to the graphic stage draw it */
			if(graphic.getStage().equals(player.getStage())) {
				graphic.draw(g);
			}
		}
		
	}
	
	/**
	 * Loads up the panel 
	 */
	private final void load() {	
		
		for(final Button button : Button.values()) {
			button.getButton().setSize(button.getRectangle().height, button.getRectangle().width);
			button.getButton().setLocation(button.getRectangle().x, button.getRectangle().y);
			button.getButton().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					button.execute();
					
				}
				
			});
			
			this.add(button.getButton());
		
		}
		
		new Thread(new GameThread()).start();
		
		
	
	}
	
	public Player getPlayer() {
		return player;
	}


}
