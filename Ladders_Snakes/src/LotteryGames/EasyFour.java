package LotteryGames;

import java.util.Scanner;

import Players.Player;
import Square.Board;

public class EasyFour extends LotteryGame {
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void play(Board[] b, Player p) {
		System.out.println("This is a game called 'EasyFour'.");
		System.out.println("You will roll two dice and if you get combination 1 & 3 or 3 & 1 - YOU WON! :)");
		System.out.println("Press any key so that game can begin.");
		sc.next();
		int[] results = new int[2];
		for (int i = 0; i < results.length; i++) {
			results[i] = (int)(Math.random() * (6-1) + 1);
			System.out.printf("%d ", results[i]);
		}
		
		if ((results[0] == 1 && results[1] == 3) || (results[1] == 1 && results[0] == 3)) {
			System.out.println("Easy four! Congratulations! Move on dude!");
			p.playerCurrentPosition(7);
		} else {
			System.out.println("Maybe next time...");
		}
		
	}
	
	//igrac baca dvije kockice istovremeno i ako je dobio 1 i 3, 3  i 1
	//pobjedio je i ide naprijed za 7 npr
}
