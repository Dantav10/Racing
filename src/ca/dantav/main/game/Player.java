package ca.dantav.main.game;


public class Player {
	
	private int money = 100;
	
	private Result result;
	
	private Team team;
	
	private Stage stage = Stage.MAIN_SCREEN;
	
	private int wager;
	
	
	
	public int getWager() {
		return wager;
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void setWager(int wager) {
		this.wager = wager;
	}
	
	public Result getResult() {
		return result;
	}
	
	public void setResult(Result result) {
		this.result = result;
	}
	
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Team getTeam() {
		return team;
	}

}
