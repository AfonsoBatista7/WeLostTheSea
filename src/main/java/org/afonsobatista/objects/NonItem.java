package org.afonsobatista.objects;

import org.afonsobatista.entity.Entity;
import org.afonsobatista.gameSystem.Actions;
import org.afonsobatista.gameSystem.Programs;
import org.afonsobatista.gameSystem.Propertys;
 
import java.util.*;

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
	Propertys[] getObjectProperty();
	
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
	void objectOccupied(Actions action, Entity user);
	
	/**
	 * @param action - Action that wants to do doing.
	 * @return true if the action that a entity is currently doing is the same as <action>.
	 */
	boolean sameAction(Actions action);
	
	/**
	 * Stop using an object.
	 */
	void stopUsing();
	
	/**
	 * Stops any action some entity is doing on the object.
	 */
	void stopAction();
}
