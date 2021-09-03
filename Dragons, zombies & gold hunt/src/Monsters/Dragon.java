package Monsters;

public class Dragon extends Monster {
	int DragonEnergy = 35;
	String name = "Dragon";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void makeSound() {
		System.out.println("Whooooosh");
	}
	
	@Override
	public void attack() {
		setDamage(15);
		System.out.println("Dragon attacks you! Damage: " + getDamage());
	}
	
	@Override
	public boolean isDead() {
		if (DragonEnergy <= 0) 
			return true;
		else
			return false;
	}

	public int getDragonEnergy() {
		return DragonEnergy;
	}

	public void setDragonEnergy(int dragonEnergy) {
		DragonEnergy = dragonEnergy;
	}
	
	@Override
	public void isAttacked(int damage) {
		DragonEnergy -= damage;
		System.out.println();
		System.out.println("Dragon energy now is " + getDragonEnergy());
		if(isDead()) {
			System.out.println("You killed a dragon! Nice work!");
		}
	}
	

}
