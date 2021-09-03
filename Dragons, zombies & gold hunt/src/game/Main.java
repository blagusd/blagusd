package game;
import Monsters.*;
import Players.*;
import Underworld.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Caves cave1 = new Caves("1");
		Caves cave2 = new Caves("2");
		Caves cave3 = new Caves("3");
		Caves cave4 = new Caves("4");
		Caves cave5 = new Caves("5");
		Caves cave6 = new Caves("6");
		Caves cave7 = new Caves("7");
		Caves cave8 = new Caves("8");
		Caves cave9 = new Caves("9");
		Caves cave10 = new Caves("10");
		Caves cave11 = new Caves("11");
		Caves cave12 = new Caves("12");
		Caves cave13 = new Caves("13");
		Caves cave14 = new Caves("14");
		Caves cave15 = new Caves("15");
		Caves cave16 = new Caves("16");
		Caves cave17 = new Caves("17");
		Caves cave18 = new Caves("18");
		Caves cave19 = new Caves("19");
		Caves cave20 = new Caves("20");
		
		Caves[] caves = new Caves[20];
		caves[0] = cave1;
		caves[1] = cave2;
		caves[2] = cave3;
		caves[3] = cave4;
		caves[4] = cave5;
		caves[5] = cave6;
		caves[6] = cave7;
		caves[7] = cave8;
		caves[8] = cave9;
		caves[9] = cave10;
		caves[10] = cave11;
		caves[11] = cave12;
		caves[12] = cave13;
		caves[13] = cave14;
		caves[14] = cave15;
		caves[15] = cave16;
		caves[16] = cave17;
		caves[17] = cave18;
		caves[18] = cave19;
		caves[19] = cave20;
		
		Monster dragon = new Dragon();
		Monster zombie = new Zombie();
		Monster ghoul = new Ghoul();
		Monster selfHealingGhoul = new SelfHealingGhoul();
		
		Monster[] monsters = new Monster[4];
		monsters[0] = dragon;
		monsters[1] = zombie;
		monsters[2] = ghoul;
		monsters[3] = selfHealingGhoul;
		
		Treasure t = new Treasure();
		Shotgun sg = new Shotgun();
		Sword sw = new Sword();
		
		Player player = new Player();
		System.out.println("Your name:");
		player.setName(sc.next());
		System.out.println("Your energy is: " + player.getPlayerEnergy());
		System.out.println("Pick a weapon. To use a sword press 'S', to use a shotgun press 'G'.");
		player.weaponUsed(sc.next());
		if(player.getWeapon().equals("S")) {
			sw.setInUse(true);
		} else if (player.getWeapon().equals("G")){
			sg.setInUse(true);
		}
		System.out.println("You're using a " + player.getWeapon() + ". Let the game begin!");
		System.out.println("You are currently in the cave " + caves[0].getName());
		
		Caves currentCave = caves[0];
		caves[0].setWasHere(true);
		
		putRandomMonstersAndTreasure(caves, monsters, t);
		randCaves(caves, currentCave);
		
		while (!(t.isFound()) && player.getPlayerEnergy() > 0) {
			printMenu(player);
			String next = sc.next();
			if (next.equals("I")) {
				currentCave.toString(currentCave);
				if (currentCave.isWasHere()) {
					currentCave.printTunnels(currentCave);
				} 
			} else if (next.equals("W")) {
				//player.changeWeapon();
				if (player.getWeapon().equals("shotgun")) {
					sg.setInUse(false);
					sw.setInUse(true);
				} else if (player.getWeapon().equals("sword")){
					if (sg.getBullets() > 0) {
						sg.setInUse(true);
						sw.setInUse(false);
						System.out.println("You have " + sg.getBullets() + " bullets left.");
					} else {
						sw.setInUse(true);
						System.out.println("You are out of bullets. Continue using sword.");
					}
				}
			} else if (next.equals("A")) {
				if (currentCave.isMonsterIsHere()) {
					if (sg.isInUse()) {
						currentCave.getMonster().isAttacked(sg.getDamage());
						sg.setBullets(sg.getBullets()-1);
						System.out.println("You have " + sg.getBullets() + " bullets left.");
					} else if (sw.isInUse()){
						currentCave.getMonster().isAttacked(sw.getDamage());
					}
				} else {
					System.out.println("There is no monster here.");
				}
			} else if (next.equals("M")) {
				
				//dohvat i ispis susjednih spilja
				Caves[] tunnelsOfCurrentCave = currentCave.getTunnels();
				System.out.println("Where do u want to go next?");
			
				for (int i = 0; i < tunnelsOfCurrentCave.length; i++) {
					System.out.printf(tunnelsOfCurrentCave[i].getName() + " ");
				}
				System.out.println();
				
				//ispis zvukova iz susjednih spilja ako ih ima
				for (int i = 0; i < 4; i++) {
					if (tunnelsOfCurrentCave[i].isMonsterIsHere()) {
						tunnelsOfCurrentCave[i].getMonster().makeSound();
					}
				}
				
				//je li igrac vec bio ovdje?
				next = sc.next();
				for (int i = 0; i < 4; i++) {
					if (next.equals(tunnelsOfCurrentCave[i].getName())) {
						if (tunnelsOfCurrentCave[i].isWasHere() && !(tunnelsOfCurrentCave[i].isMonsterIsHere())) {
							System.out.println("You already were here.");
						} else {
							currentCave = tunnelsOfCurrentCave[i];
							randCaves(caves, currentCave);
							if (currentCave.isMonsterIsHere()) {
								System.out.println(currentCave.getMonster().getName() + " is here!!!!");
								currentCave.getMonster().makeSound();
								currentCave.getMonster().attack();
								player.isAttacked(currentCave.getMonster().getDamage());
							} else if (currentCave.getTreasure() != null) {
								System.out.println("You found the treasure! You WONNN!!!!");
								t.setFound(true);
							} else {
								System.out.println("Current cave is empty.");
							}
							currentCave.setWasHere(true);
						}
					}
				}
			
			}
			
			
		}
		
		
		sc.close();
		

	}
	
	public static void randCaves(Caves[] cv, Caves current) {
		Caves[] tunnels = new Caves[4];
		Random rand = new Random();
		HashSet<Integer> used = new HashSet<Integer>();
		
			for (int j = 0; j < tunnels.length; j++) {
				int rand_index = rand.nextInt(cv.length);
				while(used.contains(rand_index))
					rand_index = rand.nextInt(cv.length);
				used.add(rand_index);
				tunnels[j] = cv[rand_index];
			}
			current.setTunnels(tunnels);
		
		
	}
	
	public static void putRandomMonstersAndTreasure(Caves[] cv, Monster[] m, Treasure t) {
		Random rand = new Random();
		int[] inds = new int[4];
		for (int i = 0; i < 4; i++) {
			int rand_index = rand.nextInt(cv.length);
			if (rand_index != 0) { //paziti da nije u jedinici
				cv[rand_index].setMonsterHere(true);
				cv[rand_index].setMonster(m[i]);
				inds[i] = rand_index;
			}
		}
		for (int i = 0; i < 4; i++) {
			int rand_ind = rand.nextInt(cv.length);
			if (rand_ind != inds[i]) {
				cv[rand_ind].setTreasure(t);
			}
		}
	}
	
	public static void printMenu(Player player) {
		System.out.println();
		System.out.println("Your current energy is " + player.getPlayerEnergy() + " .");
		System.out.println();
		System.out.println("What do you want to do next?");
		System.out.println("Press 'I' if you want to find out information about the current cave.");
		System.out.println("Press 'W' if you want to switch your weapon.");
		System.out.println("Press 'A' if you want to attack a monster.");
		System.out.println("Press 'M' if you want to move in next cave.");
		System.out.println();
	}

}
