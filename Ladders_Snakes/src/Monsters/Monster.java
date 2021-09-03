package Monsters;

public abstract class Monster {
	
	public abstract int attack();
	public abstract boolean isDead();
	public abstract void isAttacked(int damage);
	
	public Monster() {
	}
}
