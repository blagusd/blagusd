package LotteryGames;

import Players.Player;
import Square.Board;

public abstract class LotteryGame extends Board {
	boolean played = false;
	
	public abstract void play(Board[] b,Player p);
	
	public LotteryGame() {}

	public boolean isPlayed() {
		return played;
	}

	public void setPlayed(boolean played) {
		this.played = played;
	}
	
	
}
