package objects;
import java.util.Scanner;

class Ranger{
  
    
    
  
  @SuppressWarnings("resource")
public static void main(String[] args){
    Player player = Utility.setup();
    Scanner user_input =  new Scanner(System.in);
    
    while (true) { 
      player.room.describe();
      System.out.print(">>> ");
      player.make(user_input.next());
      System.out.print("\n\n\n");
      
      
    } // end of while
    }
  }
