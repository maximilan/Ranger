package objects;

public class Person extends GameObject {

	int hp;
	Weapon weapon;
	public Room room;

	boolean isDead() {
		if (hp <= 0) {
			return true;
		}
		return false;
	}

}
