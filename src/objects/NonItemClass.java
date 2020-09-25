package objects;

import entety.Entety;
import gameSystem.Propertys;

public class NonItemClass extends ObjectClass implements NonItem {
	
	private String direction;
	private Propertys property;
	private boolean available;
	private Entety entetyUsing;
	
	public NonItemClass(String type, String direction, String description, Propertys property) {
		super(type, description);
		this.direction = direction;
		this.property = property;
		available=true;
	}
	
	public Entety getUser() {
		return entetyUsing;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void objectOccupied(Entety user) {
		entetyUsing=user;
		available=!available;
	}
	
	public Propertys getObjectProperty() {
		return property;
	}
}
