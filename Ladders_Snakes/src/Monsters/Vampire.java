package Monsters;

public class Vampire extends Monster {
	private String name;
	private int vampireEnergy;
	private int vampireDamage;

	public Vampire(String name, int energy, int damage) {
		this.name = name;
		this.vampireEnergy = energy;
		this.vampireDamage = damage;
	}

	public String getName() {
		return name;
	}

	public int getVampireEnergy() {
		return vampireEnergy;
	}

	public int getVampireDamage() {
		return vampireDamage;
	}

	@Override
	public int attack() {
		System.out.println(getName() + " attacks you. Damage: " + getVampireDamage());
		return vampireDamage;
	}

	@Override
	public boolean isDead() {
		if (vampireEnergy <= 0) 
			return true;
		else
			return false;
	}

	@Override
	public void isAttacked(int damage) {
		vampireEnergy -= damage;
		System.out.println();
		System.out.println("Nice work!");
		if (isDead())
			System.out.println("You killed a " + getName()+  "! Well done :)");
	}
	
	

}
