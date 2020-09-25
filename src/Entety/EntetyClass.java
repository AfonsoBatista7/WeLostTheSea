package entety;

import locations.Location;
import objects.NonItem;
import entety.exceptions.*;
import gameSystem.Actions;

public class EntetyClass implements Entety {

	private String name;
	private int money, action;
	private Location location;
	private NonItem objectUsing;
	
	public EntetyClass(String name, Location location, int money, int action) {
		this.name = name;
		this.location = location;
		this.money = money;
		this.action = action;
	}
	
	public EntetyClass(String name, Location location, int action) {
		this.name = name;
		this.location = location;
		this.action = action;
	}
	
	public NonItem getUsingObject() {
		return objectUsing;
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
	
	public int getAction() {
		return action;
	}
	
	public void buy(int price) {
		money=-price;
	}
	
	public void sell(int price) {
		money+=price;
	}
	
	public void action(Actions action, NonItem object, Entety user) {
		int actionValue = action.getValue();
		
		if(!object.isAvailable()) throw new ObjectOccupiedException(object.getUser());         //MELHORAR CODIGO
		if(objectUsing!=null) getLocation().actionObject(objectUsing, user);
		objectUsing = object;
		getLocation().actionObject(object, user);

		this.action=actionValue;
	}

}
