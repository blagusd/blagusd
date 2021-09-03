package Monsters;

public abstract class Monster {
	String name;
	int damage;
	int energy;
	
	public abstract void makeSound();
	public abstract void attack();
	public abstract boolean isDead();
	public abstract void isAttacked(int damage);
	
	public Monster() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}

}
