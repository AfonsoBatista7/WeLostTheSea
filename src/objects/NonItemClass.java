package objects;

import entity.Entity;
import gameSystem.Propertys;

/**
 * @author Afonso Batista
 *
 */
public class NonItemClass extends ObjectClass implements NonItem {
	
	private String direction;
	private Propertys property;
	private boolean available;
	private Entity entetyUsing;
	
	public NonItemClass(String type, String direction, String description, Propertys property) {
		super(type, description);
		this.direction = direction;
		this.property = property;
		available=true;
	}
	
	public Entity getUser() {
		return entetyUsing;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void objectOccupied(Entity user) {
		entetyUsing=user;
		available=!available;
	}
	
	public Propertys getObjectProperty() {
		return property;
	}
}
