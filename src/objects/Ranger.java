package objects;
import java.util.Scanner;

class Ranger{
  
    
    
  
  public static void main(String[] args){
    Player player = Utility.setup();
    Scanner user_input =  new Scanner(System.in);
    
    while (true) { 
      player.room.describe();
      System.out.print(">>> ");
      player.move(user_input.next());
      
      
    } // end of while
    }
  }
