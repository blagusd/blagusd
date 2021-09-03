package Monsters;

public class Ghost extends Monster {
	private String name;
	private int ghostEnergy;
	private int ghostDamage;

	public Ghost(String name, int energy, int damage) {
		this.name = name;
		this.ghostEnergy = energy;
		this.ghostDamage = damage;
	}

	public String getName() {
		return name;
	}

	public int getGhostEnergy() {
		return ghostEnergy;
	}

	public int getGhostDamage() {
		return ghostDamage;
	}

	@Override
	public int attack() {
		System.out.println(getName() + " attacks you. Damage: " + getGhostDamage());
		return ghostDamage;
	}

	@Override
	public boolean isDead() {
		if (ghostEnergy <= 0) 
			return true;
		else
			return false;
	}

	@Override
	public void isAttacked(int damage) {
		ghostEnergy -= damage;
		System.out.println();
		System.out.println("Nice work!");
		if (isDead())
			System.out.println("You killed a " + getName() + "! That's interesting...");
	}
	
	
	

}
