package Monsters;

public class SelfHealingGhoul extends Monster {
	int SelfHealingGhoulEnergy = 50;
	String name = "SelfHealingGhoul";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void makeSound() {
		System.out.println("You cannot hurt me! HE-HE");
	}
	
	@Override
	public void attack() {
		setDamage(25);
		System.out.println("SelfHealingGhoul attacks you! Damage: " + getDamage());
		if (SelfHealingGhoulEnergy < 25)  
			SelfHealingGhoulEnergy += 5;
	}
	
	@Override
	public boolean isDead() {
		if (SelfHealingGhoulEnergy <= 0) 
			return true;
		else
			return false;
	}

	public int getSelfHealingGhoulEnergy() {
		return SelfHealingGhoulEnergy;
	}

	public void setSelfHealingGhoulEnergy(int selfHealingGhoulEnergy) {
		SelfHealingGhoulEnergy = selfHealingGhoulEnergy;
	}
	
	@Override
	public void isAttacked(int damage) {
		SelfHealingGhoulEnergy -= damage;
		System.out.println();
		System.out.println("SelfHealingGhoul energy now is " + getSelfHealingGhoulEnergy());
		if (isDead()) {
			System.out.println("He couldn't heal from that! You rock!");
		}
	}
	

}
