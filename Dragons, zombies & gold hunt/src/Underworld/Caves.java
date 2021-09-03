package Underworld;
import Monsters.*;

public class Caves {
	static int numberOfCaves = 20;
	int counter = 0;
	Caves[] usedCaves = new Caves[counter];
	boolean wasHere = false;
	boolean monsterHere = false;
	String name;
	Monster monster;
	Caves[] tunnels = new Caves[4];
	Treasure treasure;
	
	public Treasure getTreasure() {
		return treasure;
	}

	public void setTreasure(Treasure treasure) {
		this.treasure = treasure;
	}

	public Caves[] getTunnels() {
		return tunnels;
	}

	public void setTunnels(Caves[] tunnels) {
		this.tunnels = tunnels;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public Caves (String name) {
		this.name = name;
	}
	
	public Caves (String name, boolean b) {
		this.name = name;
		this.monsterHere = b;
	}

	public boolean isMonsterIsHere() {
		return monsterHere;
	}

	public void setMonsterHere(boolean monsterIsHere) {
		this.monsterHere = monsterIsHere;
	}
	
	public boolean isWasHere() {
		return wasHere;
	}

	public void setWasHere(boolean wasHere) {
		this.wasHere = wasHere;
	}

	public void wasPlayerHere(Caves cave) {
		this.usedCaves[counter++] = cave;
		for(int i = 0; i < usedCaves.length; i++) {
			if (cave == usedCaves[i]) {
				setWasHere(true);
				break;
			}
		}
	}
	
	
	public void toString(Caves cave) {
		if (wasHere) {
			System.out.println("Player was already here.");
			System.out.println("Please choose another one.");
		} else {
			System.out.println("You are in cave " + cave.getName());
			System.out.println("Neighboring caves are: ");
			Caves[] cvs = cave.getTunnels();
			for (int i = 0; i < cvs.length; i++) {
				System.out.printf(cvs[i].getName() + " ");
			}
			System.out.println();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Caves() {
		
	}
	
	public void printTunnels(Caves cave) {
		cave.getTunnels();
		for (int i = 0; i < 4; i++) {
			System.out.printf(tunnels[i].getName() + " ");
		}
	}
	
}
