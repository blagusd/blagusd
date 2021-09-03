package LotteryGames;

import java.util.Scanner;

import Players.Player;
import Square.Board;

public class TwiceSameNumber extends LotteryGame {
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void play(Board[] b, Player p) {
		System.out.println("This is a game called 'TwiceSameNumber'.");
		System.out.println("You will roll two dice and if you get two of the same numbers - YOU WON! :)");
		System.out.println("Press any key so that game can begin.");
		sc.next();
		int[] results = new int[2];
		for (int i = 0; i < results.length; i++) {
			results[i] = (int)(Math.random() * (6-1) + 1);
			System.out.printf("%d ", results[i]);
		}
		if (results[0] == results[1]) {
			System.out.println("For a long time I have not seen anyone so lucky :) Congratulations!");
		} else {
			System.out.println("Don't worry. The likelihood of something like that happening is just 0.167.");
		}
	}
	//igrac dvaput baca kocku i ako je dobio dvaput isti broj
	//metoda vraca true, inace false
	
	

}
