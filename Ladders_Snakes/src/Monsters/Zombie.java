package Monsters;

public class Zombie extends Monster {
	private String name;
	private int zombieEnergy;
	private int zombieDamage;

	public Zombie(String name, int energy, int damage) {
		this.name = name;
		this.zombieEnergy = energy;
		this.zombieDamage = damage;
	}

	public String getName() {
		return name;
	}

	public int getZombieEnergy() {
		return zombieEnergy;
	}

	public int getZombieDamage() {
		return zombieDamage;
	}

	@Override
	public int attack() {
		System.out.println(getName() + " attacks you. Damage: " + getZombieDamage());
		return zombieDamage;
	}

	@Override
	public boolean isDead() {
		if (zombieEnergy <= 0) 
			return true;
		else
			return false;
	}

	@Override
	public void isAttacked(int damage) {
		zombieEnergy -= damage;
		System.out.println();
		System.out.println("Nice work!");
		if (isDead())
			System.out.println("You killed a " + getName() + "! Well done :)");
		
	}
	
	
	

}
