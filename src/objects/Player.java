package objects;

public class Player extends Person {

	int maxhp;
	int xp;

	Weapon weapon;

	Player(Room room) {
		this.hp = 20;
		this.maxhp = 20;
		this.room = room;
		this.weapon = null;
		this.xp = 0;
		String[] text = new String[10];
	}

	Boolean fight(Enemy enemy) {
		int dmg = this.weapon.hit(enemy);
		if (dmg == 0) {
			if (Math.random() > 0.5) {
				System.out.println("You fumble your attack and miss the " + enemy.name + ".");
			} else {
				System.out.println("You closely miss the " + enemy.name + ".");
			}
		} else {
			System.out.printf("You hit the %s,  who loses %d Hp.%n", enemy.name, dmg);
		}
		return enemy.isDead();
	}

	public void factor(String action){
		System.out.println("\n");
		String command;
		String parameter;
		String commands[] = action.split(" ", 2);
		command = commands[0];

		try {
			parameter = commands[1];

		} catch (Exception E) {

			parameter = null;

		}

		if (command.equals("go")) {

			Room new_room = this.room.move(parameter);
			if (new_room != null)
				this.room = new_room;
			this.room.describe();
			if (this.room.enemy != null) {
				this.attack(this.room.enemy);
			}
		}

		else if (command.equals("take")) {
			Weapon w = this.room.take(parameter);
			if (w == null) {
				System.out.println("Unknown item [" + parameter + "]");
			} else {
				this.weapon = w;
				System.out.println("\n\nYou are now wielding a " + this.weapon.name + ".\n");
				this.weapon.describe();
			}
		}

		else if (command.equals("describe")) {
			if (parameter.equals(this.weapon.name)) {
				this.weapon.describe();
			}
			this.room.describe_item(parameter);
		}

	}

	void attack(Enemy e){
		while (this.hp > 0) {
			this.fight(e);
			e.fight(this);
			if (e.hp <= 0) {
				System.out.println("\nYou have succesfully slain the "+e.name+"!");
				break;
			} // end of if-else
		} // end of while
	}
}
