package objects;

public class Player extends Person{
  
  int maxhp;
  // Player(){
  //  Room r1 = new Room(null);
   // this.Player(r1);
  //}

  Player(Room room){
    this.hp = 20;
    this.maxhp = 20;
    this.weapon = new Weapon();
    this.room = room;
  }
  
  Boolean fight(Enemy enemy){
    int dmg = this.weapon.hit(enemy);
    if (dmg == 0){
       if (Math.random() > 0.5){
         System.out.println("You fumble your attack and miss the "+enemy.name+".");
       }
       else{
         System.out.println("You closely miss the "+enemy.name+".");
       }
    }
    else{
      System.out.printf("You hit the %s,  who loses %d Hp.%n", enemy.name, dmg);
    }
    return enemy.isDead();
  }
  
  void move(String direction){
    
    Room new_room = this.room.move(direction);
    if (new_room != null) this.room = new_room;
    }
}
