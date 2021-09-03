package Monsters;

public class OOPTeacher extends Monster {
	private String name;
	private int teacherEnergy;
	private int teacherDamage;

	public OOPTeacher(String name, int energy, int damage) {
		this.name = name;
		this.teacherEnergy = energy;
		this.teacherDamage = damage;
	}

	public String getName() {
		return name;
	}

	public int getTeacherEnergy() {
		return teacherEnergy;
	}

	public int getTeacherDamage() {
		return teacherDamage;
	}


	@Override
	public int attack() {
		System.out.println(getName() + " got you! It's over for you buddy. Damage: " + getTeacherDamage());
		return teacherDamage;
	}

	@Override
	public boolean isDead() {
		if (teacherEnergy <= 0) 
			return true;
		else
			return false;
	}

	@Override
	public void isAttacked(int damage) {
		teacherEnergy -= damage;
		System.out.println();
		System.out.println("Nice work!");
		if (isDead())
			System.out.println("You killed a TEACHER!!! Well done :)");
	}
	
	

}
