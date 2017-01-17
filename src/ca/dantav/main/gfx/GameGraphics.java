package ca.dantav.main.gfx;

import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics;

import ca.dantav.main.Constants;
import ca.dantav.main.Panel;
import ca.dantav.main.game.Result;
import ca.dantav.main.game.Stage;
import ca.dantav.main.game.Team;

public enum GameGraphics {

	
	CURRENT_WAGER(Stage.MAIN_SCREEN) {

		@Override
		public void draw(Graphics g) {
			
			g.setColor(Color.RED);
			g.drawString("Current Wager: " + Panel.PANEL.getPlayer().getWager(), 0, 10);
			
		}
		
	},
	
	
	CURRENT_MONEY(Stage.MAIN_SCREEN) {

		@Override
		public void draw(Graphics g) {
			
			g.setColor(Color.RED);
			g.drawString("Current Money: " + Panel.PANEL.getPlayer().getMoney(), 240, 100);
			
		}
		
	},
	
	LAST_RESULT(Stage.MAIN_SCREEN) {

		@Override
		public void draw(Graphics g) {
			
			Result result = Panel.PANEL.getPlayer().getResult();
			g.setColor(Color.RED);
			g.drawString("Last Result: " + (result == null ? "Haven't Played" : result.toString()), 225, 120);
			
		}
		
	},
	
	CURRENT_TEAM(Stage.MAIN_SCREEN) {

		@Override
		public void draw(Graphics g) {
			
			g.setFont(new Font("Arial", Font.BOLD, 12));
			g.drawString("Current Team:", 0, 375);
			g.setColor(Panel.PANEL.getPlayer().getTeam() == null ? Color.BLACK : Panel.PANEL.getPlayer().getTeam().getColor());
			g.drawString(Panel.PANEL.getPlayer().getTeam() == null ? "None" : Panel.PANEL.getPlayer().getTeam().toString(), 90, 375);
		}
		
	},
	
	BLOCKS(Stage.IN_GAME) {

		@Override
		public void draw(Graphics g) {
			
			for(Team team : Team.values()) {
				
				g.setColor(team.getColor());
				g.fillRect(team.getRectangle().x, team.getRectangle().y, team.getRectangle().width, team.getRectangle().height);
				
				int deltaX = (int) (Math.random() * Constants.SPEED_MULTIPLIER);
				
				team.getRectangle().x = team.getRectangle().x + deltaX;
				
				if(team.getRectangle().x >= 20) {
					
					Panel.PANEL.getPlayer().setMoney(Panel.PANEL.getPlayer().getMoney() + (Panel.PANEL.getPlayer().getTeam().equals(team) ? Panel.PANEL.getPlayer().getWager() : -Panel.PANEL.getPlayer().getWager()));
					Panel.PANEL.getPlayer().setResult(Panel.PANEL.getPlayer().getTeam().equals(team) ? Result.WON : Result.LOST);
					Panel.PANEL.getPlayer().setStage(Stage.MAIN_SCREEN);
					Panel.PANEL.getPlayer().setWager(0);
					Panel.PANEL.getPlayer().setTeam(null);
					
					Panel.PANEL.setBackground(Constants.MAIN_BACKGROUND_COLOR);
				
					for(Team t : Team.values()) {
						
						t.getRectangle().x = -600;
						
					}
					
					for(Button button : Button.values()) {
						
						button.getButton().setVisible(true);
						
					}
					
					return;
				}
				
				Panel.PANEL.setBackground(Constants.GAME_BACKGROUND_COLOR);
			}
			
			
			
			
		}
		
	};
	
	private Stage stage;
	
	GameGraphics(Stage stage) {
		this.stage = stage;
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public abstract void draw(Graphics g);
	
}
