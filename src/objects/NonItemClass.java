package objects;

import entity.Entity;
import gameSystem.Actions;
import gameSystem.Propertys;

/**
 * @author Afonso Batista
 *
 */
public class NonItemClass extends ObjectClass implements NonItem {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1889613798462084732L;
	
	private String direction;
	private Propertys[] property;
	private Actions action;
	private boolean available;
	private Entity entetyUsing;
	
	public NonItemClass(String type, String direction, String description, Propertys[] property) {
		super(type, description);
		this.direction = direction;
		this.property = property;
		action = Actions.NOTHING;
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
	
	public void stopUsing() {
		entetyUsing = null;
		available = true;
	}
	
	public void stopAction() {
		action = Actions.NOTHING;
	}
	
	public void objectOccupied(Actions action, Entity user) {
		entetyUsing=user;
		this.action = action;
		available=false;
	}
	
	public boolean sameAction(Actions action) {
		return this.action.equals(action);
	}
	
	public Propertys[] getObjectProperty() {
		return property;
	}
}
