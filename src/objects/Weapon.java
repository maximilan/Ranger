package objects;

public class Weapon extends GameObject {
	double damage;
	double accuracy;

	Weapon(double damage, double accuracy, String name, String description) {
		this.damage = damage;
		this.accuracy = accuracy;
		this.name = name;
		this.description = description;
	}

	Weapon() {
		this.damage = 1;
		this.accuracy = 0.5;
		this.name = "Stick";
		this.description = "A large piece of wood, ill-suited for combat.";
	}

	void find() {
		System.out.println("\nYou see a " + this.name + " lying in the ground");
	}

	void describe() {
		System.out.printf("\n" + this.name + "\n" + this.description
				+ "\nDamage: %d\nAccuracy: %d\n", this.damage, this.accuracy);
	}

	int hit(Player p) {
		if (Math.random() > accuracy) {
			return 0;
		} else {
			int hitpoints = -(Utility.randint(damage, damage + 5));
			p.hp += hitpoints;
			return hitpoints;
		}
	}

	int hit(Enemy e) {
		if (Math.random() > accuracy) {
			return 0;
		} else {
			int hitpoints = -(Utility.randint(damage, damage + 5));
			e.hp += hitpoints;
			return hitpoints;
		}
	}
}
