package entety;

import locations.Location;

import javax.swing.Action;

import entety.exceptions.*;
import gameSystem.Actions;

public class EntetyClass implements Entety {

	private String name;
	private int money, action;
	private Location location;
	
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
	
	public boolean sameAction(int action) {
		return this.action==action;
	}
	
	public void action(Actions action) {
		int actionValue = action.getValue();
		if(sameAction(actionValue)) throw new SameActionException();
		this.action=actionValue;
	}

}
