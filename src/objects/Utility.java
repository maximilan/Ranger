package objects;

public class Utility {

	static int randint(double start, double end) {
		return (int) (start + Math.random() * (end - start));
	}

	public static Player setup() {
		Room house = new Room("A House", "is");
		house.set_description("It is night. You suddenly find yourself standing in front of an abondoned villa.\nWindows and doors are boarded up. The only way out is a small path going south.");

		Room crossroads = new Room("A Crossroads", "is");
		crossroads.set_description("You come to a crossroads. A disturbing silence greets you. \nYou seem to be alone");
		crossroads.link("north", house);
		house.link("south", crossroads);

		Room creek = new Room("A Creek", "lies");
		creek.set_description("A small creek is situated next to the path you follow. The clear water is bathed in a soft moonlight glow.");
		creek.link("east",crossroads);
		crossroads.link("west", creek);
		
		Room woods = new Room("Some woods", "are");
		woods.set_description("The woods greet you with a distant hooting of an owl. You have the feeling, that you are being followed.");
		Weapon w = new Weapon();
		woods.add_weapon(w);
		woods.link("west", crossroads);
		crossroads.link("east", woods);
		
		Room garden = new Room("The Gardens", "are");
		garden.set_description("Once a well-kept rural landscape, Mother Nature has now recaptured what was once hers.\nYou can have difficulties finding a path leading out of this place.");
		garden.link("north", woods);
		woods.link("south", garden);
		
		Room graveyard = new Room("A Graveyard", "is");
		graveyard.set_description("You walk past mighty headstones. You can barely decipher their engravings due too little light.\nYou remember childrens tales about dead who rise at midnight to haunt the living.\nYou quickly turn to leave.");
		graveyard.link("north", crossroads);
		graveyard.link("east", garden);
		garden.link("west", graveyard);
		crossroads.link("south", graveyard);
		

		Player player = new Player(house);
		return player;
	}
}
