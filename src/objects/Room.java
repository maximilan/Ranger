package objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room extends GameObject {

  Map<String, Room> links;
  ArrayList<String> directions;
  String verb;
  Weapon weapon;

  Room(String name, String verb) {
    this(name, "", verb);
  }

  Room(String name, String description, String verb) {
    this(name, description, verb, null);
  }
    
  Room(String name, String description, String verb, Weapon weapon) {
    this.name = name;
    this.description = description;
    this.verb = verb;
    links = new HashMap<String, Room>();
    directions = new ArrayList<String>();
    this.weapon = weapon;
  }
  
  void add_weapon(Weapon w){
      this.weapon = w;
    }

  void link(String key, Room other_room) {
    directions.add(key);
    links.put(key, other_room);
  }

  void set_description(String description) {
    this.description = description;
  }

  public void describe() {
    System.out.println("------" + this.name + "------");
    System.out.println(this.description);
    if (!(this.weapon == null)) {
      System.out.println("\n");
      this.weapon.find();
      }
    System.out.println("\n\n");
    for (String direction : directions) {
      System.out.printf("%s %s in the %s.", links.get(direction).name,
          links.get(direction).verb, direction);
      System.out.print("\n");
      System.out.println("---------------------");

    } // end of for
    
    
  }

  Room move(String direction) {
    if (this.directions.contains(direction)) {
      return links.get(direction);
    } else {
      return null;
    } // end of if-else

  }
  
  Weapon take(String name){
	try{
    if (this.weapon.name.equals(name)){
      Weapon w = this.weapon;
      this.weapon = null;
      return w;
      }
    return null;
    }
  catch(Exception e){
	  return null;
  }
  }
}
