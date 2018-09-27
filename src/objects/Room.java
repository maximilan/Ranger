package objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room extends GameObject {

	Map<String, Room> links;
	ArrayList<String> directions;
	String verb;
	Weapon weapon;
	Enemy enemy;
	ArrayList<GameObject> items;

	Room(String name, String verb) {
		this(name, "", verb);
	}

	Room(String name, String description, String verb) {
		this(name, description, verb, null, null);
	}

	Room(String name, String description, String verb, Weapon weapon,
			Enemy enemy) {
		this.name = name;
		this.description = description;
		this.verb = verb;
		links = new HashMap<String, Room>();
		directions = new ArrayList<String>();
		this.weapon = weapon;
		this.enemy = enemy;
	}

	void add_weapon(Weapon w) {
		this.weapon = w;
	}

	void link(String key, Room other_room) {
		directions.add(key);
		links.put(key, other_room);
	}

	void set_description(String description) {
		this.description = description;
	}

	public void describe() {
		System.out.println("------" + this.name + "------");
		System.out.println(this.description);
		if (!(this.weapon == null)) {
			System.out.println("\n");
			this.weapon.find();
		}
		System.out.println("\n\n");
		for (String direction : directions) {
			System.out.printf("%s %s in the %s.", links.get(direction).name,
					links.get(direction).verb, direction);
			System.out.print("\n");

		} // end of for
		System.out.println("---------------------");

	}

	public Boolean describe_item(String item) {
		this.items = new ArrayList<GameObject>();
		this.items.add(this);
		this.items.add(this.weapon);
		try {
			this.items.add(this.enemy);
			this.items.add(this.enemy.weapon);
		} catch (Exception e) {
		}

		for (GameObject o : items) {
			try {
				if (o.name.equals(item)) {
					System.out.println("\n" + o.description + "\n");
					return true;
				}
			} catch (Exception e) {
			}
		}
		System.out.println("\nDescription for [" + item + "] not found.\n");
		return false;
	}

	Room move(String direction) {
		if (this.directions.contains(direction)) {
			return links.get(direction);
		} else {
			return null;
		} // end of if-else

	}

	Weapon take(String name) {
		try {
			if (this.weapon.name.equals(name)) {
				Weapon w = this.weapon;
				this.weapon = null;
				return w;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}
}
