package objects;

import java.util.Scanner;

class Main {

	static Player setup() {
		Room r1 = new Room("A House", "is");
		r1.set_description("It is night. You suddenly find yourself standing in front of an abondoned villa.\nWindows and doors are boarded up. The only way out is a small path going south.");

		Room r2 = new Room("A Crossroads", "is");
		r2.set_description("You come to a crossroads. A disturbing silence greets you. \nYou seem to be alone");

		r2.link("north", r1);
		r1.link("south", r2);

		Player player = new Player(r1);
		return player;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Player player = setup();
		Scanner user_input = new Scanner(System.in);

		while (true) {
			player.room.describe();
			System.out.print(">>>");
			player.factor(user_input.nextLine());

		} // end of while
	}
}
