package Monsters;

public class Zombie extends Monster {
	int ZombieEnergy = 30;
	String name = "Zombie";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void makeSound() {
		System.out.println("Brainzzzzzzzzz");
	}
	
	@Override
	public void attack() {
		setDamage(10);
		System.out.println("Zombie attacks you! Damage: " + getDamage());
	}
	
	@Override
	public boolean isDead() {
		if (ZombieEnergy <= 0) 
			return true;
		else
			return false;
	}

	public int getZombieEnergy() {
		return ZombieEnergy;
	}

	public void setZombieEnergy(int zombieEnergy) {
		ZombieEnergy = zombieEnergy;
	}
	
	@Override
	public void isAttacked(int damage) {
		ZombieEnergy -= damage;
		System.out.println();
		System.out.println("Zombie energy now is " + getZombieEnergy());
		if(isDead()) {
			System.out.println("Now he stays dead! You are great!");
		}
	}
	

}
