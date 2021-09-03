package Square;

import LotteryGames.LotteryGame;
import Monsters.*;
import Riddles.*;

public class Board extends CheckIsSomethingHere {
	int[] usedNumbers = new int[25];
	int[] numbersForLadders = new int[5];
	int[] numbersForSnakes = new int[5];
	int[] numbersForRiddles = new int[5];
	int[] numbersForLotteryGames = new int[4];
	int[] numbersForMonsters = new int[5];
	Monster m;
	Riddle r;
	LotteryGame lg;

	
	public Board() {
	}
	
	public void setMonster(Monster m) {
		this.m = m;
	}
	
	public Monster getMonster() {
		return m;
	}
	
	public Riddle getRiddle() {
		return r;
	}
	
	public void setRiddle(Riddle r) {
		this.r = r;
	}
	
	public void setLotteryGame(LotteryGame lg) {
		this.lg = lg;
	}
	
	public LotteryGame getLotteryGame() {
		return lg;
	}

	public int[] getNumbersForMonsters() {
		return numbersForMonsters;
	}

	public int[] getNumbersForRiddles() {
		return numbersForRiddles;
	}

	public int[] getNumbersForLotteryGames() {
		return numbersForLotteryGames;
	}

	public int[] getNumbersForLadders() {
		return numbersForLadders;
	}

	public int[] getNumbersForSnakes() {
		return numbersForSnakes;
	}

	//metoda koja ce staviti zmije i ljestve na razlicita mjesta
	public void randomPlacesForLaddersAndSnakes(Board[] b) {
		for (int i = 0; i < numbersForLadders.length; i++) {
			numbersForLadders[i] = (int)(Math.random() * (93-10) + 10);
			for (int j = 0; j < usedNumbers.length; j++) {
				if (numbersForLadders[i] == usedNumbers[j]) {
					numbersForLadders[i] = (int)(Math.random() * (93-10) + 10);
				}
			}
			usedNumbers[i] = numbersForLadders[i];
		}
		
		for (int i = 0; i < numbersForSnakes.length; i++) {
			numbersForSnakes[i] = (int)(Math.random() * (93-10) + 10);
			for (int j = 0; j < usedNumbers.length; j++) {
				if (numbersForSnakes[i] == usedNumbers[j]) {
					numbersForSnakes[i] = (int)(Math.random() * (93-10) + 10);
				}
			}
			usedNumbers[numbersForSnakes.length+i] = numbersForSnakes[i];
		}
		
		
			for (int j = 0; j < numbersForLadders.length; j++) {
				b[numbersForLadders[j]].setLaddersHere(true);
			}
			for (int j = 0; j < numbersForSnakes.length; j++) {
				b[numbersForSnakes[j]].setSnakeHere(true);
			}
		
	}
	
	//metoda koja ce staviti zagonetke i igre na srecu na razna mjesta
	public void randomPlacesForRiddlesAndLotteryGames(Board[] b) {
		for (int i = 0; i < numbersForRiddles.length; i++) {
			numbersForRiddles[i] = (int)(Math.random() * (85-5) + 5);
			for (int j = 0; j < usedNumbers.length; j++) {
				if (numbersForRiddles[i] == usedNumbers[j]) {
					numbersForRiddles[i] = (int)(Math.random() * (85-5) + 5);
				}
			}
			usedNumbers[2*numbersForRiddles.length+i] = numbersForRiddles[i];
		}
		
		for (int i = 0; i < numbersForLotteryGames.length; i++) {
			numbersForLotteryGames[i] = (int)(Math.random() * (85-20) + 20);
			for (int j = 0; j < usedNumbers.length; j++) {
				if (numbersForLotteryGames[i] == usedNumbers[j]) {
					numbersForLotteryGames[i] = (int)(Math.random() * (85-20) + 20);
				}
			}
			usedNumbers[3*numbersForLotteryGames.length+i] = numbersForLotteryGames[i];
		}
		
		
			for (int j = 0; j < numbersForRiddles.length; j++) {
				b[numbersForRiddles[j]].setRiddleHere(true);
				
				
			}
			for (int j = 0; j < numbersForLotteryGames.length; j++) {
				b[numbersForLotteryGames[j]].setLotteryGameHere(true);
			}
		
	}
	
	//ovo je metoda koja ce staviti cudovista na razna mjesta
	public void randomPlacesForMonsters(Board[] b) {
		for (int i = 0; i < numbersForMonsters.length; i++) {
			numbersForMonsters[i] = (int)(Math.random() * (100-1) + 1);
			for (int j = 0; j < usedNumbers.length; j++) {
				if (numbersForMonsters[i] == usedNumbers[j]) {
					numbersForMonsters[i] = (int)(Math.random() * (100-1) + 1);
				}
			}
			usedNumbers[4*numbersForMonsters.length+i] = numbersForMonsters[i];
		}
		
		for (int j = 0; j < numbersForMonsters.length; j++) {
			b[numbersForMonsters[j]].setMonsterHere(true);
		}
	}


}
