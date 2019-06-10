package objects;

public class Enemy extends Person {

  Enemy(String name) {
    this.name = name;
    this.description = null;
    this.weapon = null;
    
    if (name == "Goblin") {
         this.description = "A small green midget which normally lures on passerbys.";
         this.weapon = new Weapon("Stick");
         this.hp = 4;
    } else {
      
    } // end of if-else
  }
  
  void describe() {
	  System.out.println("You notice a "+this.name+".");
	  System.out.println(this.name+": "+this.description);
	  System.out.println("The "+this.name+" is wielding a "+this.weapon.name+".");
  }
  

  Boolean fight(Player player){
    int dmg = this.weapon.hit(player);
    if (dmg == 0) {
      if (Math.random() > 0.5) {
        System.out.println("The " + this.name
            + " fumbles his attack and misses you.");
      } else {
        System.out.println("The "+this.name + " closely misses you.");
      }
    } else {
      System.out.printf("The "+this.name + " hits you!You lose %d Hp.%n", dmg);
    }
    return player.isDead();
  }

}
