package Game;

import Square.*;
import Players.*;
import Monsters.*;
import Riddles.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import LotteryGames.*;

public class Game extends Board {

	Board[] b = new Board[106];
	Player p1 = new Player();
	Player p2 = new Player();
	Scanner sc = new Scanner(System.in);
	String next;
	
	Monster dragon = new Dragon("Dragon",10,10);
	Monster ghost = new Ghost("Ghost",20,15);
	Monster vampire = new Vampire("Vampire",25,20);
	Monster zombie = new Zombie("Zombie",30,30);
	Monster teacher = new OOPTeacher("OOP Teacher",1,99);
	Monster[] monsters = {dragon, ghost, vampire, zombie, teacher};
	
	LotteryGame ef = new EasyFour();
	LotteryGame gn = new GuessNumber();
	LotteryGame tsn = new TwiceSameNumber();
	LotteryGame wof = new WheelOfFortune();
	LotteryGame[] lgames = {ef, gn, tsn, wof};
	
	Game() {}
	
	public void loadGame() throws InterruptedException {
		initBoard();
		randomPlacesForLaddersAndSnakes(b);
		randomPlacesForMonsters(b);
		putMonsters(monsters);
		randomPlacesForRiddlesAndLotteryGames(b);
		putRiddles(loadRiddles());
		putLotteryGames(lgames);
		
		System.out.println("Please enter your names: ");
		System.out.println("Player 1: ");
		p1.setName(sc.next());
		System.out.println("Player 2: ");
		p2.setName(sc.next());
		
		do {
			BoardStatus();
			
			System.out.println(p1.getName() + " is on the line.");
			System.out.println("You are currently in the position no. " + p1.getCurrentPosition());
			System.out.println("Your energy is: " + p1.getPlayerEnergy());
			System.out.println("Press any letter to roll the dice.");
			sc.next();
			movingThroughBoard(p1, rollTheDice()); //krece igrac 1 i odmah baca kocku koja ce odrediti njegov trenutni polozaj
			switchPlayers(p1);
			
			System.out.println();
			TimeUnit.SECONDS.sleep(2);
			if (p1.getCurrentPosition() >= 100 || p1.getPlayerEnergy() <= 0) {
				System.out.println(p1.getName() + " is WON!");
				System.exit(0);
			}
			BoardStatus();
			
			System.out.println(p2.getName() + " is on the line.");
			System.out.println("You are currently in the position no. " + p2.getCurrentPosition());
			System.out.println("Your energy is: " + p2.getPlayerEnergy());
			System.out.println("Press any letter to roll the dice.");
			sc.next();
			movingThroughBoard(p2, rollTheDice());
			switchPlayers(p2);
			System.out.println();
			if (p2.getCurrentPosition() >= 100 || p2.getPlayerEnergy() <= 0) {
				System.out.println(p2.getName() + "  WON!");
				System.exit(0);
			}
			TimeUnit.SECONDS.sleep(2);
			
		} while (!(p1.getPlayerEnergy() <= 0 || p2.getPlayerEnergy() <= 0 || p1.getCurrentPosition() >= 100 || p2.getCurrentPosition() >= 100));
		
	}
	
	private static int rollTheDice() {
		int n = (int)(Math.random() * (6-1) + 1);
		System.out.println("You got it: " + n);
		return n;
	}
	
	public void movingThroughBoard(Player p, int playerPosition) {
		p.playerCurrentPosition(playerPosition);
		int move = (int)(Math.random() * (7-3) + 3); //moze ici unazad za 3,4,...7 mjesta
		
			if (b[p.getCurrentPosition()].isLaddersHere()) {
				p.playerCurrentPosition(move);
				System.out.println("Sorry, you have to move " + move + "steps further :)))");
				movingThroughBoard(p, 0); //rekurzija - kad se pomakne za taj broj opet provjerava postoji li nesto na ploci
			} 
			else if (b[p.getCurrentPosition()].isSnakeHere()) {
				System.out.println("Sorry, you have to move " + move + "steps back :(((");
				p.playerCurrentPosition(-1*move);
				movingThroughBoard(p, 0);
			} 
			else if (b[p.getCurrentPosition()].isMonsterHere()) {
				p.setPlayerEnergy(p.getPlayerEnergy()-b[p.getCurrentPosition()].getMonster().attack());
				System.out.println("If you want to attack monster, press A.");
				System.out.println("If you want to move on, press anything else.");
				next = sc.next();
				if (next.equals("A")) {
					b[p.getCurrentPosition()].getMonster().isAttacked(p.Attack());
					if (b[p.getCurrentPosition()].getMonster().isDead()) {
						b[p.getCurrentPosition()].setMonsterHere(false);
					}
				}
			} 
			else if (b[p.getCurrentPosition()].isRiddleHere()) {
				if (!p.isSolvedRiddle()) {
					System.out.println("You've come to the field where the riddle is!");
					System.out.println("Answer correctly and move forward or answer wrong and move backward.");
					System.out.println(b[p.getCurrentPosition()].getRiddle().getQuestion());;
					System.out.println("Your answer is: ");
					next = sc.next();
					if (next.equals(b[p.getCurrentPosition()].getRiddle().getSolution())) {
						System.out.println("Nice! The answer is correct. Hurry to the finish line!!");
						p.playerCurrentPosition(b[p.getCurrentPosition()].getRiddle().getMoveCorrect());
						movingThroughBoard(p, 0);
					} else {
						System.out.println("Oh no :( Your answer was wrong. Here's the solution: ");
						System.out.println(b[p.getCurrentPosition()].getRiddle().getSolution());
						System.out.println(b[p.getCurrentPosition()].getRiddle().getExplanation());
						p.playerCurrentPosition(b[p.getCurrentPosition()].getRiddle().getMoveWrong());
						movingThroughBoard(p, 0);
					}
					p.setSolvedRiddle(true);
				}
			} 
			else if (b[p.getCurrentPosition()].isLotteryGameHere()) {
				// provjeriti je li igrac vec igrao i pobjedio igru --> TREBALA ISTO I ZA RIDDLE
				if (!p.isPlayedLotteryGame()) {
					int pom = p.getCurrentPosition();
					b[p.getCurrentPosition()].getLotteryGame().play(b, p);
					p.setPlayedLotteryGame(true);
					if (pom != p.getCurrentPosition()) {
						movingThroughBoard(p, 0);
					}
				} 
			}
			
	}
	
	public Player switchPlayers(Player p) {
		if (p == p1) 
			return p2;
		else 
			return p1;
	}
	
	public static Riddle[] loadRiddles() {
		Riddle[] riddles = new Riddle[5];
		riddles[0] = new Riddle("U prestupnoj godini, koliko mjeseci ima 29 dana? (broj)", "12", "Svi, neki imaju i vise od 29", 5, -3);
		riddles[1] = new Riddle("U vreci se nalazi 10 bijelih i 10 crnih carapa. Koliko najmanje carapa treba izvuci da biste sigurno imali jedan par istih? (broj)", "3","logicno :)", 3, -3);
		riddles[2] = new Riddle("Ti si moj sin ali ja nisam tvoj otac. Tko je to rekao?","majka","logicno :)",3, -3);
		riddles[3] = new Riddle("Riba i po, kuna i po, posto 3 ribe? (broj)","3","",2,-2);
		riddles[4] = new Riddle("Ako danas u podne pada jaka kisa, mozemo li ocekivati da ce za 36 sati sijati sunce?","ne","Za 36 sati ce biti ponoc",5,-5);
		return riddles;
	}

	public void putMonsters(Monster[] m) {
		int[] bNum = getNumbersForMonsters();
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (b[bNum[j]].isMonsterHere()) {
					b[bNum[j]].setMonster(m[j]);
				}
			}
		}
	}
	
	public void putRiddles(Riddle[] r) {
		int[] bNum = getNumbersForRiddles();
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < r.length; j++) {
				if (b[bNum[j]].isRiddleHere()) {
					b[bNum[j]].setRiddle(r[j]);
				}
			}
		}
	}

	public void putLotteryGames(LotteryGame[] lg) {
		int[] bNum = getNumbersForLotteryGames();
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < lg.length; j++) {
				if (b[bNum[j]].isLotteryGameHere()) {
					b[bNum[j]].setLotteryGame(lg[j]);
				}
			}
		}
	}
	
	public void initBoard() {
		for (int i = 0; i < b.length; i++) {
			b[i] = new Board();
		}
	}
	
	public void BoardStatus() {
		System.out.printf("Snakes are on fields: ");
		for (int i = 0; i < getNumbersForSnakes().length; i++) {
			System.out.printf("%d ", getNumbersForSnakes()[i]);
		}
		System.out.println();
		System.out.printf("Ladders are on fields: ");
		for (int i = 0; i < getNumbersForLadders().length;i++) {
			System.out.printf("%d ", getNumbersForLadders()[i]);
		}
		System.out.println();
		System.out.printf("Monsters are on fields: ");
		for (int i = 0; i < getNumbersForMonsters().length;i++) {
			System.out.printf("%d ", getNumbersForMonsters()[i]);
		}
		System.out.println();
		System.out.printf("Riddles are on fields: ");
		for (int i = 0; i < getNumbersForRiddles().length;i++) {
			System.out.printf("%d ", getNumbersForRiddles()[i]);
		}
		System.out.println();
		System.out.printf("LotteryGames are on fields: ");
		for (int i = 0; i < getNumbersForLotteryGames().length;i++) {
			System.out.printf("%d ", getNumbersForLotteryGames()[i]);
		}
		
		System.out.println();
		System.out.println();
	}
}
