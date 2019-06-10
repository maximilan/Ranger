import objects.Player;
import objects.Setup;
//import objects.Utility;

import java.util.Scanner;

public class Main {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws InterruptedException {
    Player player = Setup.setup();
    Scanner user_input = new Scanner(System.in);
    player.room.describe();

    while (true) {
      System.out.print(">>>");
     // player.factor(user_input.nextLine());
      if (user_input.hasNextLine()) {
             player.factor(user_input.nextLine());
      
      } // end of if-else
    } // end of while
  }
}
