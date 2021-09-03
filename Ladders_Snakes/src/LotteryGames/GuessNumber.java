package LotteryGames;

import java.util.Scanner;
import Players.Player;
import Square.Board;

public class GuessNumber extends LotteryGame {
	Scanner sc = new Scanner(System.in);
	private int imaginedNumber = (int)(Math.random() * (15-5) + 5);
	
	public GuessNumber() {}
	
	@Override
	public void play(Board[] b, Player p) {
		System.out.println("This is a game called 'GuessNumber'.");
		System.out.println("Can you guess which number I imagined (5-15)?");
		System.out.println("Let me see what you think: ");
		int next = sc.nextInt();
		if (next == imaginedNumber) {
			System.out.println("Wow! You're really lucky! :)");
		} else {
			System.out.println("Better luck next time x)");
			System.out.println("I imagined " + imaginedNumber);
		}
	}

}
