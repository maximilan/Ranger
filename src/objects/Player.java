package objects;

public class Player extends Person {

  int maxhp;

  // Player(){
  // Room r1 = new Room(null);
  // this.Player(r1);
  // }
  
  Weapon weapon;

  Player(Room room) {
    this.hp = 20;
    this.maxhp = 20;
    this.weapon = new Weapon();
    this.room = room;
    this.weapon = null;
  }

  Boolean fight(Enemy enemy) {
    int dmg = this.weapon.hit(enemy);
    if (dmg == 0) {
      if (Math.random() > 0.5) {
        System.out.println("You fumble your attack and miss the "
            + enemy.name + ".");
      } else {
        System.out.println("You closely miss the " + enemy.name + ".");
      }
    } else {
      System.out.printf("You hit the %s,  who loses %d Hp.%n",
          enemy.name, dmg);
    }
    return enemy.isDead();
  }

  void factor(String action) {
    System.out.println("\n");
    String command;
    String parameter;
    String commands[] = action.split(" ");
    command = commands[0];

    try {
      parameter = commands[1];

    } catch (Exception E) {

      parameter = null;

    }

    if (command.equals("go")) {

      Room new_room = this.room.move(parameter);
      if (new_room != null) this.room = new_room;
    }
    
    else if (command.equals("take")) {
      Weapon w = this.room.take(parameter);
      if (!(parameter == null)) {
          this.weapon = w;
          System.out.println("\n\nYou are now wielding a "+this.weapon.name+".\n");
      } 
      }
   
  }
}
