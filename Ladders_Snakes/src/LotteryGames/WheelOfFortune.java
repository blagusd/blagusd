package LotteryGames;
import java.util.Scanner;

import Players.*;
import Square.*;

public class WheelOfFortune extends LotteryGame {
	Scanner sc = new Scanner(System.in);

	@Override
	public void play(Board[] b,Player p) {
		System.out.println("This is a game called 'WheelOfForutne'.");
		System.out.println("You'll spin the wheel and see what you get.");
		System.out.println("Press any key so that game can begin.");
		sc.next();
		
		int numberOfOperation = (int)(Math.random() * (5-1) + 1);
		System.out.println(numberOfOperation);
		if (numberOfOperation == 1) {
			System.out.println("You get extra 20 units of energy!");
			p.setPlayerEnergy(p.getPlayerEnergy()+20);
		} else if (numberOfOperation == 2) {
			System.out.println("Oh no! You lost 20 units of energy :(");
			p.setPlayerEnergy(p.getPlayerEnergy()-20);
		} else if (numberOfOperation == 3) {
			System.out.println("You just killed one monster! Now this game is less danger...");
			int randomMonster = (int)(Math.random() * 4);
			int[] mNum = getNumbersForMonsters();
			b[mNum[randomMonster]].setMonsterHere(false);
		} else if (numberOfOperation == 4) {
			if (p.getCurrentPosition() > 10) {
				p.playerCurrentPosition(-10);
				System.out.println("Sorry... you just moved 10 places backward.");
			} else {
				play(b, p); //ponovo 'vrti' kotac
			}
		} else if (numberOfOperation == 5) {
			p.playerCurrentPosition(10);
			System.out.println("Wow! 10 steps closer to the finish line.");
		}
	}

	//npr. igrac moze dobiti dodatnu energiju, moze mu se energija oduzeti
	//moze ukloniti jedno cudovista sa polja, moze ici neki odredjeni broj
	//polja nazad ili naprijed i sl.
}
