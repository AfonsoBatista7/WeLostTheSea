package Actor;

import locations.Location;

public class ActorClass implements Actor {

	private String name;
	private Location location;
	
	public ActorClass(String name, Location location) {
		this.name = name;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location newLocation) {
		location = newLocation;
	}
	
}
