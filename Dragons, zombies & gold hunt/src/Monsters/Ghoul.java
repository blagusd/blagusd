package Monsters;

public class Ghoul extends Monster {
	int GhoulEnergy = 40;
	String name = "Ghoul";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void makeSound() {
		System.out.println("Not great, not terrible... attttack!");
	}
	
	@Override
	public void attack() {
		setDamage(20);
		System.out.println("Ghoul attacks you! Damage: " + getDamage());
	}
	
	@Override
	public boolean isDead() {
		if (GhoulEnergy <= 0) 
			return true;
		else
			return false;
	}

	public int getGhoulEnergy() {
		return GhoulEnergy;
	}

	public void setGhoulEnergy(int ghoulEnergy) {
		GhoulEnergy = ghoulEnergy;
	}
	
	@Override
	public void isAttacked(int damage) {
		GhoulEnergy -= damage;
		System.out.println();
		System.out.println("Ghoul energy now is " + getGhoulEnergy());
		if (isDead()) {
			System.out.println("Ghoul is gone! Good job!");
		}
	}
	
	

}
