package objects;

import java.util.Scanner;

public class Main {


  @SuppressWarnings("resource")
  public static void main(String[] args) {
    Player player = Utility.setup();
    Scanner user_input = new Scanner(System.in);

    while (true) {
      player.room.describe();
      System.out.print(">>>");
      player.factor(user_input.nextLine());

    } // end of while
  }
}
