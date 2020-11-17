package objects;

import entity.Entity;
import gameSystem.Propertys;

/**
 * Not an item;
 * @author Afonso Batista
 */
public interface NonItem extends Object {

	/**
	 * @return the specific location of the object inside the location.
	 */
	String getDirection();
	
	/**
	 * @return the objects property.
	 */
	Propertys getObjectProperty();
	
	/**
	 * @return the entity that is using the item.
	 */
	Entity getUser();
	
	/**
	 * @return true if the object is being used and false if not.
	 */
	boolean isAvailable();
	
	/**
	 * @param user - user that are now using the object.
	 */
	void objectOccupied(Entity user);
}
