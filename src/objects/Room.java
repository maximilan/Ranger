package objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room extends GameObject{
	
	Map<String, Room> links;
	ArrayList<String> directions;
	
 	Room(String name){
		this.name = name;
		this.description = "";
		links = new HashMap<String, Room>();
		directions = new ArrayList<String>();
	}
	
	Room(String name, String description){
		this.name = name;
		this.description = description;
		links = new HashMap<String, Room>();
		directions = new ArrayList<String>();
	}
	
	void link(String key, Room other_room){
		directions.add(key);
		links.put(key, other_room);
	}
	
	void describe(){
		System.out.println("------"+this.name+"------");
		System.out.println(this.description);
	}
	
	
}
