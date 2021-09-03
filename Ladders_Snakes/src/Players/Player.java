package Players;
import Square.*;

public class Player extends Board {
	private static int playerDamage = 20;
	private int playerEnergy = 100;
	private String name;
	private int currentPosition = 0;
	boolean playedLotteryGame = false;
	boolean solvedRiddle = false;
	
	public Player() {}
	
	public boolean isSolvedRiddle() {
		return solvedRiddle;
	}

	public void setSolvedRiddle(boolean solvedRiddle) {
		this.solvedRiddle = solvedRiddle;
	}

	public boolean isPlayedLotteryGame() {
		return playedLotteryGame;
	}

	public void setPlayedLotteryGame(boolean playedLotteryGame) {
		this.playedLotteryGame = playedLotteryGame;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPlayerEnergy() {
		return playerEnergy;
	}
	public void setPlayerEnergy(int playerEnergy) {
		this.playerEnergy = playerEnergy;
	}
	public static int getPlayerDamage() {
		return playerDamage;
	}
	
	public int playerCurrentPosition(int moves) {
		currentPosition += moves;
		return currentPosition;
	}

	public int Attack() {
		return playerDamage;
	}
}
