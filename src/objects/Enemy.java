package objects;

public class Enemy extends Person{
	
	Enemy(String name, String description, Weapon weapon){
		this.name = name;
		this.description = description;
		this.weapon = weapon;
	}
	
	Boolean fight(Player player){
		int dmg = this.weapon.hit(player);
		if (dmg == 0){
			 if (Math.random() > 0.5){
				 System.out.println("The" + this.name +" fumbles his attack and misses you.");
			 }
			 else{
				 System.out.println(this.name+"closely misses you.");
			 }
		}
		else{
			System.out.printf(this.name+" hits you!You lose %d Hp.%n",dmg);
		}
		return player.isDead();
	}

}
