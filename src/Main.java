import objects.Player;
import objects.Setup;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class Main {

  @SuppressWarnings("resource")
  public static void main(String[] args){ 
	  
	//Creating GUI
	JFrame frame = new JFrame("Ranger");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	frame.setSize(700, 500);
	JLabel output = new JLabel("");
	JLabel prompt = new JLabel(">>>");
	JTextField textfield = new JTextField(15);
	JPanel panel = new JPanel();
	panel.add(prompt);
	panel.add(textfield);
	
	frame.getContentPane().add(BorderLayout.SOUTH, panel);
	frame.setVisible(true);
	
	//Initializing Player
    Player player = Setup.setup();
    Scanner user_input = new Scanner(System.in);
    player.room.describe();

    //Game loop
    while (true) {
      System.out.print(">>>");
      if (user_input.hasNextLine()) {
             player.factor(user_input.nextLine());
      }
    } 
  }
}
