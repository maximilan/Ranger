import objects.Player;
import objects.Utility;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Player player = Utility.setup();
		Scanner user_input = new Scanner(System.in);
		player.room.describe();

		while (true) {
			System.out.print(">>>");
			player.factor(user_input.nextLine());

		} // end of while
	}
}
