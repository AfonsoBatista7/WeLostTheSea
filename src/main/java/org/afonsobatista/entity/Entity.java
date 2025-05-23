package org.afonsobatista.entity;

import org.afonsobatista.entity.exceptions.EmpetyBagException;
import org.afonsobatista.gameSystem.Actions;
import org.afonsobatista.locations.*;
import org.afonsobatista.objects.*;

/**
 * Entities are like actors, players, NPCs, etc.
 * @author Afonso Batista
 */
public interface Entity {

	/**
	 * @return Player name.
	 */
	String getName();
	
	
	/**
	 *  Sets an entity name.
	 */
	void setName(String name); 
	
	/**
	 * @return Entity location.
	 */
	Location getLocation();
	
	/**
	 * Teleport an Entity to a new location
	 * @param newLocation
	 */
	void setLocation(Location newLocation);
	
	/**
	 * @return the entity total money.
	 */
	double getBalance();
	
	/**
	 * Buy something.
	 * @param price - Money you have to pay.
	 */
	void buy(double price);
	
	/**
	 * Sell something.
	 * @param price - Money you have to gain.
	 */
	void sell(double price);
	
	/**
	 * @return the respective action number.
	 */
	Actions getAction();
	
	/**
	 * Executes an action on an object. 
	 * @param action - The action you want to execute. 
	 * @param object - The object to do the action.
	 */
	void action(Actions action, NonItem object);
	
	/**
	 * @return the object that Entity is currently using.
	 */
	NonItem getSittingObject();
	
	NonItem getUsingObject();
	
	/**
	 * @return true if Entity is using an object and false if not.
	 */
	boolean sittingObject();
	
	/**
	 * The entity stop using the object that he was using.
	 */
	void noLongerSitting();
	
	/**
	 * Gets items.
	 * @param items - list of items the Entity picked. 
	 */
	void getItem(Item item) throws EmpetyBagException;
	
	/**
	 * @param item - Item the Entity wants to drop.
	 * @return Item to drop.
	 * @throws EmpetyBagException - If the wanted item is not in the bag.
	 */
	 Item dropItem(String item) throws EmpetyBagException;
	 
	 double getSellTax();
	 
	 /**
	 * @param item - item.
	 * @return the total quantity of an item. 
	 */
	int getQuantity(String item) throws EmpetyBagException;
	
	boolean isUsingObject(NonItem object);

}
