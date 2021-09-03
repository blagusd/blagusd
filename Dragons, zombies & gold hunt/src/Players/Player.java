package Players;

public class Player {
	String name;
	int playerEnergy = 100;
	String weapon;
	Shotgun sg;
	Sword sw;
	
	public Player() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPlayerEnergy() {
		return playerEnergy;
	}
	public void setPlayerEnergy(int playerEnergy) {
		this.playerEnergy = playerEnergy;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	//oruzje koje se koristi
	public void weaponUsed(String s) {
		if (s.equals("S")) {
			setWeapon("sword");
//			sw.setInUse(true);
		} else if (s.contentEquals("G")) {
			setWeapon("shotgun");
//			sg.setInUse(true);
		}
	}
	
	public void changeWeapon() {
		if (weapon == "sword") {
			setWeapon("shotgun");
			System.out.println("Now you are using a " + getWeapon() + ".");
		} else if (weapon == "shotgun") {
			setWeapon("sword");
			System.out.println("Now you are using a " + getWeapon() + ".");
		}
	}
	
	public void isAttacked(int damage) {
		playerEnergy -= damage;
	}

}
