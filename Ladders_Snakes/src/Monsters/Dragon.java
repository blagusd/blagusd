package Monsters;

public class Dragon extends Monster {
	private String name;
	private int dragonEnergy;
	private int dragonDamage;

	public Dragon(String name, int energy, int damage) {
		this.name = name;
		this.dragonEnergy = energy;
		this.dragonDamage = damage;
	}


	public String getName() {
		return name;
	}

	public int getDragonEnergy() {
		return dragonEnergy;
	}


	public int getDragonDamage() {
		return dragonDamage;
	}
	
	@Override
	public boolean isDead() {
		if (dragonEnergy <= 0) 
			return true;
		else
			return false;
	}

	@Override
	public int attack() {
		System.out.println(getName() + " attacks you. Damage: " + getDragonDamage());
		return dragonDamage;
	}

	@Override
	public void isAttacked(int damage) {
		dragonEnergy -= damage;
		System.out.println();
		System.out.println("Nice work!");
		if (isDead())
			System.out.println("You killed a " + getName() + "! Well done :)");
	}
	

}
