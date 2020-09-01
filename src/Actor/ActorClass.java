package Actor;

import locations.Location;

public class ActorClass implements Actor {

	private String name;
	private int money;
	private Location location;
	
	public ActorClass(String name, Location location, int money) {
		this.name = name;
		this.location = location;
		this.money = money;
	}
	
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
	
	public int getBalance() {
		return money;
	}
	
	public void buy(int price) {
		money=-price;
	}
	
	public void sell(int price) {
		money+=price;
	}
	
}
