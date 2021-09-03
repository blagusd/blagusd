package Square;

public abstract class CheckIsSomethingHere {
	private boolean SnakeHere = false;
	private boolean LaddersHere = false;
	private boolean RiddleHere = false;
	private boolean MonsterHere = false;
	private boolean LotteryGameHere = false;
	
	public boolean isSnakeHere() {
		return SnakeHere;
	}
	public void setSnakeHere(boolean snakeHere) {
		SnakeHere = snakeHere;
	}
	public boolean isLaddersHere() {
		return LaddersHere;
	}
	public void setLaddersHere(boolean laddersHere) {
		LaddersHere = laddersHere;
	}
	public boolean isRiddleHere() {
		return RiddleHere;
	}
	public void setRiddleHere(boolean riddleHere) {
		RiddleHere = riddleHere;
	}
	public boolean isMonsterHere() {
		return MonsterHere;
	}
	public void setMonsterHere(boolean monsterHere) {
		MonsterHere = monsterHere;
	}
	public boolean isLotteryGameHere() {
		return LotteryGameHere;
	}
	public void setLotteryGameHere(boolean lotteryGameHere) {
		LotteryGameHere = lotteryGameHere;
	}
	
}
