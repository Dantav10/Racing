package ca.dantav.main.gfx;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ca.dantav.main.Main;
import ca.dantav.main.Panel;
import ca.dantav.main.game.Player;
import ca.dantav.main.game.Stage;
import ca.dantav.main.game.Team;

public enum Button {

	START(new JButton("Start Game"), new Rectangle(220, 140, 100, 150)) {

		@Override
		public void execute() {
		
			if(Panel.PANEL.getPlayer().getTeam() == null) {
				Main.LOGGER.info("You need to bet on team.");
				return;
			}
			
			if(Panel.PANEL.getPlayer().getWager() <= 0) {
				Main.LOGGER.info("You need to bet something on the game.");
				return;
			}
			
			Panel.PANEL.getPlayer().setStage(Stage.IN_GAME);
		
			for(Button button : values()) {
				button.getButton().setVisible(false);
			}
		}
		
	},
	
	
	WAGER(new JButton("Set Wager"), new Rectangle(500, 0, 50, 100)) {

		@Override
		public void execute() {
			
			String name = JOptionPane.showInputDialog(Panel.PANEL,
                    "Type in the wager:", null);
			
			if(!name.matches("-?\\d+(\\.\\d+)?")) {
				Main.LOGGER.info("Please type in numbers");
				return;
			}
			
			int amount = Integer.parseInt(name);
			
			if(Panel.PANEL.getPlayer().getMoney() < amount) {
				Main.LOGGER.info("You cannot bet that much money.");
				return;
			}
			
			
			
			
			Panel.PANEL.getPlayer().setWager(amount);
			
			
			
			
		}
		
	},
	
	TEAM(new JButton("Set Team"), new Rectangle(500, 326, 50, 100)) {

		@Override
		public void execute() {
			
			String name = JOptionPane.showInputDialog(Panel.PANEL,
                    "Type in the team[GREEN, RED, ORANGE, PURPLE]:", null).toUpperCase();
			
			Team betTeam = null;
			
			for(Team team : Team.values()) {
				if(name.equals(team.toString())) {
					betTeam = team;
					break;
				}
			}
			
			if(betTeam == null) {
				Main.LOGGER.info("Not a real team. please pick another");
				return;
			}
			
			
			Panel.PANEL.getPlayer().setTeam(betTeam);

			
			
			
		}
		
	};
	
	

	private JButton button;
	
	private Rectangle rectangle;
	
	Button(JButton button, Rectangle rectangle) {
		this.button = button;
		this.rectangle = rectangle;
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public JButton getButton() {
		return button;
	}
	
	
	public abstract void execute();
}
